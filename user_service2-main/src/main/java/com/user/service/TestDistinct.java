package com.user.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestDistinct {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Rama", "Kama", "Rama", "Nama");

		 List<Integer> ls =Arrays.asList(2,3,4,9,8,7,6,4,0);

		// List<Integer> ls =
		// list.stream().distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList());

		System.out.println(ls);

		Map<String, Long> collct = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(collct);

	}
}
