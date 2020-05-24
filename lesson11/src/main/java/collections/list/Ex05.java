package collections.list;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
	public static void main(String[] args) {
		List<String> first = mockList("a","b","c","d");
		List<String> secord = mockList("e","f","g","h","c","d");
		//hop
		List<String> mergeList=new ArrayList<>(first);
	//	mergeList.addAll(first);
		mergeList.addAll(secord);
		mergeList.forEach(s->System.out.print(s+" "));
	
		//giao
		System.out.println("\n===============");
		List<String> juctionList=new ArrayList<>(first);
		juctionList.retainAll(secord);
		juctionList.forEach(s->System.out.print(s+" "));
		
	}

	private static List<String> mockList(String... strings) {
		List<String> result = new ArrayList<>();
		for (String s : strings) {
			result.add(s);
		}
		return result;
	}
}
