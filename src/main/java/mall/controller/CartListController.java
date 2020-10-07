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
public class CartListController { //CartAddController���� �Ѿ��
	final String command = "/list.mall";
	final String getPage = "MallList";
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session) {
		
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		
		Map<Integer, Integer> maplists = mycart.getAllOrderLists();
		System.out.println("��ٱ��� ��ǰ ����: " + maplists.size());
		
		Set<Integer> keylist = maplists.keySet();
		System.out.println("keylist: " + keylist);
		
		List<ShoppingInfo> shoplists = new ArrayList<ShoppingInfo>();
		int totalAmount = 0;
		for(Integer pnum : keylist) {
			
			Integer oqty = maplists.get(pnum);
			System.out.println(pnum + ":" + oqty);
			
			//��ٱ��Ͽ� �ִ� ��ǰ���� ���������
			Product product= productDao.getData(pnum);
			ShoppingInfo shopInfo = new ShoppingInfo();
			shopInfo.setPnum(pnum); //�̹� ��ٱ��Ͽ� ����ִ°��̶� ��ٱ��Ͽ��� ���� �����Դ�
			shopInfo.setPname(product.getName());
			shopInfo.setQty(oqty); //�̹� ��ٱ��Ͽ� ����ִ°��̶� ��ٱ��Ͽ��� ���� �����Դ�
			shopInfo.setPrice(product.getPrice());
			shopInfo.setAmount(product.getPrice()*oqty);
			
			totalAmount += product.getPrice()*oqty;
			
			shoplists.add(shopInfo);
		}
		
		session.setAttribute("shoplists", shoplists);
		session.setAttribute("totalAmount", totalAmount);
		return getPage; //MallList.jsp(��ǰ��ȣ,��ǰ��,�ֹ�����,�ܰ�,�ݾ�)�� ��� ���� ���� ����� mall.cart��Ű��\ShoppingInfo��.
	}
	
}
