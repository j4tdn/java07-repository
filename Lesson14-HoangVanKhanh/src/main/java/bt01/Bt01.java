package bt01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Bt01 {
	public static void main(String[] args) {
		List<Integer> integers =Arrays.asList(1,2,3,4,5,6,5,5,3,1);
		List<Integer> a = new ArrayList<>();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (Integer integer:integers) {
            addElement(map, integer);
        }
        System.out.print("Các phần tử xuất hiện 1 lần: ");
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                System.out.print(key + " ");
            }
        }
        System.out.println("\nCác phần tử xuất hiện nhiều lần");
        for (Integer key : map.keySet()) {
            if (map.get(key) != 1) {
                System.out.print(key + " ");
            }
        }
	}
	
	public static void addElement(Map<Integer, Integer> map, int element) {
        if (map.containsKey(element)) {
            int count = map.get(element) + 1;
            map.put(element, count);
        } else {
            map.put(element, 1);
        }
    }

}
