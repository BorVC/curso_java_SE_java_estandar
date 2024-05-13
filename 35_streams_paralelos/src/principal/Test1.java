package principal;

import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		List<Integer> nums = List.of(5,11,22,3,4,5,9,4,6);
		nums.stream()
		.parallel()
		.distinct()
		.count();
	}
}
