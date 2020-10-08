package product.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mall.cart.ShoppingInfo;
import order.model.Order;

@Component("myCompositeDao")
public class CompositeDao {
	
	final String namespace="product.model.Composite";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<Order> orderMall(String id) {
		List<Order> lists = new ArrayList<Order>(); //장바구니 안에 있는 주문내역이 order객체가 되어서 들어간다
		lists = sqlSessionTemplate.selectList(namespace+".OrderMall",id);
		return lists;
	}
	
	public List<ShoppingInfo> showDetail(int oid){
		List<ShoppingInfo> lists = new ArrayList<ShoppingInfo>();
		lists = sqlSessionTemplate.selectList(namespace+".ShowDetail",oid);
		return lists;
	}
	
	
}
