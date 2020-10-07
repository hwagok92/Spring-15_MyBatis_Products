package product.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {
	final String command = "/delete.prd";
	final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(command)
	public String doAction(@RequestParam(value="num", required=true) int num) {
		
		Product product=productDao.getData(num);
		System.out.println(product.getImage());
		
		//그림 파일이 있는 경로
		String uploadPath = servletContext.getRealPath("/resources");
		
		//기존에 있는 파일을 지우는 코드
		File delFile = new File(uploadPath + File.separator + product.getImage());
		delFile.delete(); 
		
		productDao.deleteData(num);
		return gotoPage;
	}
}
