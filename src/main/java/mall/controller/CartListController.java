package mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import mall.cart.ShoppingInfo;
import product.model.Product;
import product.model.ProductDao;

@Controller
public class CartListController { //CartAddController에서 넘어옴
	final String command = "/list.mall";
	final String getPage = "MallList";
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session) {
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		
		Map<Integer, Integer> maplists = mycart.getAllOrderLists();
		System.out.println("장바구니 상품 갯수: " + maplists.size());
		
		Set<Integer> keylist = maplists.keySet();
		System.out.println("keylist: " + keylist);
		
		List<ShoppingInfo> shoplists = new ArrayList<ShoppingInfo>();
		int totalAmount = 0;
		for(Integer pnum : keylist) {
			
			Integer oqty = maplists.get(pnum);
			System.out.println(pnum + ":" + oqty);
			
			//장바구니에 있는 상품들이 담겨져있음
			Product product= productDao.getData(pnum);
			ShoppingInfo shopInfo = new ShoppingInfo();
			shopInfo.setPnum(pnum); //이미 장바구니에 담겨있는것이라 장바구니에서 직접 가져왔다
			shopInfo.setPname(product.getName());
			shopInfo.setQty(oqty); //이미 장바구니에 담겨있는것이라 장바구니에서 직접 가져왔다
			shopInfo.setPrice(product.getPrice());
			shopInfo.setAmount(product.getPrice()*oqty);
			
			totalAmount += product.getPrice()*oqty;
			
			shoplists.add(shopInfo);
		}
		
		session.setAttribute("shoplists", shoplists);
		session.setAttribute("totalAmount", totalAmount);
		return getPage; //MallList.jsp(상품번호,상품명,주문수량,단가,금액)을 담는 것을 따로 만든다 mall.cart패키지\ShoppingInfo에.
	}
	
}
