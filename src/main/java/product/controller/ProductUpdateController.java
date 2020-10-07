package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;

import product.model.Product;
import product.model.ProductDao;

@Controller
public class ProductUpdateController {
	final String command = "update.prd";
	final String getPage = "ProductUpdateForm";
	final String gotoPage = "redirect:/list.prd";
	@Autowired
	ProductDao productDao;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction(@RequestParam(value="num", required=true) int num, Model model, HttpSession session) {
		//�α����� �ȵǾ������� �α��� �������� �ѱ�� �޼���
		if(session.getAttribute("loginInfo")==null) {
			session.setAttribute("destination", "redirect:/insert.prd?num="+num);
			
			return "redirect:/loginForm.me";
		}
		
		
		
		Product product = productDao.getUpdate(num); 
		model.addAttribute("product",product); 
		return getPage;
	}
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doAction(@Valid Product product,
							BindingResult result) {
			
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		String uploadPath = servletContext.getRealPath("/resources");
		//C:\Spring_ysy\~~~resources\��������.jpg
		//��������� ���ڸ� ������ ���� �����̴�.
		
		//�� ���� ���ڸ� �ִ� �̹������Ͽ� ������ ������ �۾��̴�.
		File file = new File(uploadPath + File.separator + product.getImage());
		
		
		File delFile = new File(uploadPath + File.separator + product.getUploadOld());
		delFile.delete();
		
		MultipartFile multi = product.getUpload();
		try {
			multi.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		productDao.updateProduct(product);
		mav.setViewName(gotoPage);
		
		return mav;
	}
	
	
}
