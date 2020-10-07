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
		//<Ű(��ǰ��ȣ),��(�ֹ�����)>
		
		Set<Integer> keylist = maplists.keySet();
		System.out.println("keylist: "+keylist); //5����ǰ 11����ǰ�� ����ִ�.
		
		
		//oid,mid,orderdate
		Member member =(Member) session.getAttribute("loginInfo");
		orderDao.insertData(member.getId());
		
		//2����ǰ�� �ֹ������� 3������? �׷� ��ٱ��Ͽ��� ���°��̴�
		int maxOid = orderDao.getMaxOid(); //���� ū oid���� �����´�
		for(Integer pnum : keylist) {
			Integer qty = maplists.get(pnum);
			
			productDao.updateStock(pnum,qty);
			
			//orderdetails:odid,oid,pnum,qty
			//--oid : �ֹ���ȣ, pnum : ��ǰ��ȣ, qty : �ֹ�����
			OrderDetail odBean = new OrderDetail();
			odBean.setOid(maxOid);
			odBean.setPnum(pnum);
			odBean.setQty(qty);
			
			orderDetailDao.insertData(odBean);
		
		}
		memberDao.updatePoint(member.getId(),100);//������ ȸ�� 100 ����Ʈ�� �߰������ְڴ�. =>MemberDao =>member.xml=> �ٽ� �����.
		
		session.removeAttribute("mycart");//�׷� ���� ��ٱ��ϰ� �������� �ȴ�
		return gotoPage;
	}
}
