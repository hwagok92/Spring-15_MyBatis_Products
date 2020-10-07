package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList {
	// Map<key:��ǰ��ȣ,value:�ֹ�����>
	private Map<Integer, Integer> orderlists = null;

	public MyCartList() {
		// ��ٱ��� �ϳ��� �������� �ֱ����� �ڵ� {(5����ǰ 2��) Ȥ�� (2����ǰ 3��)} �׷��� ��� �� ������ �����ϱ� ���ؼ�
		// session���� �����Ѵ�.
		orderlists = new HashMap<Integer, Integer>();
		// ���� �� �ȿ� ��ٱ��� ��ϵ��� ����.
	}

	public void addOrder(int pnum, int oqty) {
		if (orderlists.containsKey(pnum) == false) { // =>���� ������ ��ǰ ��ȣ�� �̹� �ִ°��̳�? �ƴ϶�� ����ǰ����
			orderlists.put(pnum, oqty);

		} else { // �̹� �ִ� ��ǰ�̸�
			int oldoqty = orderlists.get(pnum); // Ű�� �ش��ϴ� ��ȣ�� �˸� ��ǰ ������ �˼��ִ�
			orderlists.put(pnum, oldoqty + oqty);
			// ���� �� orderlists.put(pnum, orderlists.get(pnum);
		}

	}

	// ��ٱ���
	public Map<Integer, Integer> getAllOrderLists() {
		return orderlists;
	}

}
