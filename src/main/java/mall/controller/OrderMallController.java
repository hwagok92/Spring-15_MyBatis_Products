package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.Member;
import order.model.Order;
import product.model.CompositeDao;

@Controller
public class OrderMallController {
	final String command = "/order.mall";
	final String getPage = "ShopList";
	
	@Autowired
	CompositeDao compositeDao;
	
	@RequestMapping(command)
	public String doAction(HttpSession session, Model model) {
		Member loginInfo = (Member) session.getAttribute("loginInfo");
		
		if(loginInfo==null) {//로그인이 안되어 있으면 로크인폼으로 다시 돌아가라
			session.setAttribute("destination", "redirect:/order.mall");
			return "redirect:/loginForm.me";
		}
		else {
			List<Order> lists = compositeDao.orderMall(loginInfo.getId());
			model.addAttribute("lists",lists);
		}
			
		
		return getPage;
	}
	
	
}
