package date02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import service.ExpenseService;
import service.ExpenseServiceImpl;

public class Ex05 {
	private static ExpenseService<String, Integer> service = new ExpenseServiceImpl();

	public static void main(String[] args) {
		Map<String, Integer> expenses = service.getAll();
		System.out.println("1. Danh sách các khoản chi tiêu:");
		expenses.forEach((t, i) -> System.out.println(t + ": " + i + " nghìn VNĐ"));
		System.out.println("===================");
		System.out.println("2. TT các khoản chi lớn hơn 500 nghìn VNĐ:");
		listed(expenses);
		System.out.println("===================");
		System.out.println("3. Sắp xếp các khoản chi theo thứ tự tăng dần của các key(khoản CT):");
		sortByKey(expenses);
		System.out.println("===================");
		System.out.println("4. Sắp xếp các khoản chi theo thứ tự giảm dần của các value(tiền):");
		sortByValue(expenses);
	}

	private static void listed(Map<String, Integer> expenses) {
		Set<String> set = expenses.keySet();
		for (String key : set) {
			if (expenses.get(key) > 500) {
				System.out.println(key + ": " + expenses.get(key) + " nghìn VNĐ");
			}
		}
	}

	private static void sortByKey(Map<String, Integer> expenses) {
		Set<String> set = expenses.keySet();
		List<String> lists = new ArrayList<>(set);
		lists.sort((l1, l2) -> l1.compareTo(l2));
		lists.forEach(l -> System.out.println(l + ": " + expenses.get(l) + " nghìn VNĐ"));
	}

	private static void sortByValue(Map<String, Integer> expenses) {
		Set<String> set = expenses.keySet();
		List<String> lists = new ArrayList<>(set);
		for (int i = 0; i < lists.size() - 1; i++) {
			for (int j = i + 1; j < lists.size(); j++) {
				if (expenses.get(lists.get(i)) < expenses.get(lists.get(j))) {
					String tmp = lists.get(i);
					lists.set(i, lists.get(j));
					lists.set(j, tmp);
				}
			}
		}
		lists.forEach(l -> System.out.println(l + ": " + expenses.get(l) + " nghìn VNĐ"));
	}
}