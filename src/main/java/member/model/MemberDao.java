package member.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import product.model.Product;
import utility.Paging;

@Component("myMemberDao")
public class MemberDao {
	private final String namespace="member.model.Member";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insertData(Member member){
		sqlSessionTemplate.insert(namespace+".InsertData",member);
	}
	
	public int getTotalCount(Map<String,String> map){
		int cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return cnt;
	}
	
	public List<Member> getDataList(Paging paging,Map<String,String> map){
		
		List<Member> lists = new ArrayList<Member>();
		RowBounds rowBounds = new RowBounds(paging.getOffset(),paging.getLimit()); // 10,5
		lists = sqlSessionTemplate.selectList(namespace+".GetDataList",map,rowBounds);
		return lists;
	}
	
	public void deleteData(String id){
		sqlSessionTemplate.delete(namespace+".DeleteData",id);
	}
	
	public Member getData(String id){
		Member member = null;
		member = sqlSessionTemplate.selectOne(namespace+".GetData",id);
		return member;
	}
							//id,point두가지 를 한번에 보낼 수 없다 그래서 객체를 만들어 묶어서 보낸다
	public void updatePoint(String id,int point) {
		Member bean = new Member();
		bean.setId(id);
		bean.setMpoint(point);
		
		sqlSessionTemplate.selectOne(namespace+".UpdatePoint",bean);
	}
	
	
}







