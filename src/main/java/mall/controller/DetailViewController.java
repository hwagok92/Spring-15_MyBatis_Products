package mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.ShoppingInfo;
import product.model.CompositeDao;

@Controller
public class DetailViewController {
	final String command = "/detailView.mall";
	final String getPage = "ShopResult";
	
	@Autowired
	CompositeDao compositeDao;
	
	@RequestMapping(command)
	public String doAction(@RequestParam("oid") int oid, Model model) {//oid에서 넘어온 번호가 뭔지 알아낸 다음 상품이름과 수량 단가 금액을 가져오는걸 표시한다.
		
		// 순번 상품명(상품번호) 수량 단가 금액을 담고 있는 클래스가 ShoppingInfo에 담겨저 있어서 그걸 가져온다
		List<ShoppingInfo> lists = compositeDao.showDetail(oid);
		model.addAttribute("lists",lists);
		model.addAttribute("oid",oid);
		
		
		return getPage;
		}
	
}
