package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {
	// Map<key:상품번호,value:주문수량>
	private Map<Integer, Integer> orderlists = null;

	public MyCartList() {
		// 장바구니 하나에 묶음으로 넣기위한 코드 {(5번상품 2개) 혹은 (2번상품 3개)} 그래서 계속 이 정보를 유지하기 위해서
		// session으로 설정한다.
		orderlists = new HashMap<Integer, Integer>();
		// 지금 이 안에 장바구니 목록들이 들어간다.
	}

	public void addOrder(int pnum, int oqty) {
		if (orderlists.containsKey(pnum) == false) { // =>내가 가져온 상품 번호가 이미 있는것이냐? 아니라면 새상품이지
			orderlists.put(pnum, oqty);

		} else { // 이미 있는 상품이면
			int oldoqty = orderlists.get(pnum); // 키에 해당하는 번호를 알면 상품 수량도 알수있다
			orderlists.put(pnum, oldoqty + oqty);
			// 같은 것 orderlists.put(pnum, orderlists.get(pnum);
		}

	}

	// 장바구니
	public Map<Integer, Integer> getAllOrderLists() {
		return orderlists;
	}

}
