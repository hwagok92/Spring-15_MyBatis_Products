package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDetailViewController {

		final String command = "/detail.prd";
		final String getPage = "ProductDetailView";
		
		@Autowired
		ProductDao productDao;
		
		@RequestMapping(value=command, method = RequestMethod.GET)
		public String doAction(@RequestParam(value="num", required=true) int num, 
				Model model) {
			Product product = productDao.getData(num);
			model.addAttribute("product",product);
			return getPage;
		}
		
}
