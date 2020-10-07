package product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

/*ProductDao  myProductDao = new ProductDao();*/

@Component("myProductDao")
public class ProductDao {
	
	private String namespace = "product.model.Product";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int getTotalCount(Map<String,String> map){
		int cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}
	
	public List<Product> getDataList(Paging paging,Map<String,String> map){
		
		List<Product> lists = new ArrayList<Product>();
		RowBounds rowBounds = new RowBounds(paging.getOffset(),paging.getLimit()); // 10,5
		lists = sqlSessionTemplate.selectList(namespace+".GetDataList",map,rowBounds);
		return lists;
	}
	
	public int insertData(Product bean){
		int cnt = sqlSessionTemplate.insert(namespace+".InsertData",bean);
		return cnt;
	}
	
	public Product getData(int num) {
		Product product = sqlSessionTemplate.selectOne(namespace+".GetData",num);
		return product;
		
	}
	
	public Product getUpdate(int num) {
		Product product = sqlSessionTemplate.selectOne(namespace+".GetUpdate",num);
		return product;
	}
	
	public void updateProduct(Product product) {
		sqlSessionTemplate.update(namespace+".UpdateProduct", product);
	}
	
	public void deleteData(int num) {
		sqlSessionTemplate.delete(namespace+".DeleteData",num);
	}
	
	public void updateStock(Integer pnum, Integer qty) {
		Product bean = new Product();
		bean.setNum(pnum);
		bean.setStock(qty);

		sqlSessionTemplate.update(namespace + ".UpdateStock", bean);// update는 키와 값 하나씩만 넣을 수 있다 값을 두개 이상 넣을 수가 없어서
																		// product bean으로 값들을 하나로 묶어야 한다
	}
}










