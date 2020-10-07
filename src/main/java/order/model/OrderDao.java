package order.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import product.model.Product;

@Component("myOrderDao")
public class OrderDao {
	private final String namespace = "order.model.Order";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	/* ��������� Dao�� �غ��ϴ� ���� */

	public void insertData(String id) {
		sqlSessionTemplate.insert(namespace + ".InsertData", id);
	}

	public int getMaxOid() {
		int maxOid = sqlSessionTemplate.selectOne(namespace+".GetMaxOid");
		return maxOid;
	}
}
