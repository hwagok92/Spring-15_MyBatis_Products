package order.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myOrderDetailDao")
public class OrderDetailDao {
	private final String namespace="orderdetail.model.OrderDetail";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	//여기까지가 Dao의 준비 과정
	
	public void insertData(OrderDetail odBean) {
		sqlSessionTemplate.insert(namespace+".InsertData",odBean);
	}
}
