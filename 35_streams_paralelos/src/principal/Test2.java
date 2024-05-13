package principal;

import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		List<Integer> nums = List.of(5,11,22,3,4,5,9,4,6,-3,3,-8);
		nums.parallelStream()
		.distinct()
		.filter(n->n>0)
		.sequential()
		.forEach(System.out::println);;
	}
}
