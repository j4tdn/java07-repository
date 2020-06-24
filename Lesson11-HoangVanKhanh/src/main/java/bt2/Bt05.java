package bt2;

import java.util.Map;

import service.ExpenseService;
import service.ExpenseServiceImpl;

public class Bt05 {
	private static ExpenseService<String, Integer> service = new ExpenseServiceImpl();

	public static void main(String[] args) {
		Map<String, Integer> expenses = service.getAll();
		System.out.println("1. List of Expenses");
		expenses.forEach((e, a) -> System.out.println(e + " :" + a + " VND"));
		System.out.println("===============================================");
		System.out.println("2.Expenses greater than 500000 VND");
		ExpenseUtils.expenseMore500(expenses);
		System.out.println("================================================");
		System.out.println("Sort By Key");
		ExpenseUtils.sortByKey(expenses);
		System.out.println("=================================================");
		System.out.println("Sort By Value");
		for (String key : ExpenseUtils.sortByValue(expenses).keySet()) {
			System.out.println(key + " :" + ExpenseUtils.sortByValue(expenses).get(key) + " VND");
		}

	}

}
