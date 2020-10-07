package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.Member;
import member.model.MemberDao;
import order.model.OrderDao;
import order.model.OrderDetail;
import order.model.OrderDetailDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController {
	final String command = "/calculate.mall";
	final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	MemberDao memberDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	
	@RequestMapping(command)
	public String doAction(HttpSession session) {
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		Map<Integer,Integer> maplists = mycart.getAllOrderLists();
		//<키(상품번호),값(주문수량)>
		
		Set<Integer> keylist = maplists.keySet();
		System.out.println("keylist: "+keylist); //5번상품 11번상품이 들어있다.
		
		
		//oid,mid,orderdate
		Member member =(Member) session.getAttribute("loginInfo");
		orderDao.insertData(member.getId());
		
		//2번상품의 주문수량이 3개였다? 그럼 장바구니에서 빼는것이다
		int maxOid = orderDao.getMaxOid(); //가장 큰 oid값을 가져온다
		for(Integer pnum : keylist) {
			Integer qty = maplists.get(pnum);
			
			productDao.updateStock(pnum,qty);
			
			//orderdetails:odid,oid,pnum,qty
			//--oid : 주문번호, pnum : 상품번호, qty : 주문수량
			OrderDetail odBean = new OrderDetail();
			odBean.setOid(maxOid);
			odBean.setPnum(pnum);
			odBean.setQty(qty);
			
			orderDetailDao.insertData(odBean);
		
		}
		memberDao.updatePoint(member.getId(),100);//구매한 회원 100 포인트를 추가시켜주겠다. =>MemberDao =>member.xml=> 다시 여기로.
		
		session.removeAttribute("mycart");//그럼 이제 장바구니가 없어지게 된다
		return gotoPage;
	}
}
