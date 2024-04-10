package corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {

	public static void main(String[] args) {
		
		/*int[] arr = {12,24,12,1,24,4,5,6};
		
		String[] sArr = {"sdkjf", "sds", "harsh", "Nihal", "tanishk"};
		
		Stream<String> stream1 = Arrays.stream(sArr);
		
		stream1.filter(name -> name.length()>4).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
		
//		List<String> list = stream1.collect(Collectors.toList());
//		
//		System.out.println(list);
		
		Stream<int[]> stream = Stream.of(arr);
		
		stream.forEach(a -> System.out.println(Arrays.toString(a)));
		
//		stream.sorted().forEach(System.out::println);
		
//		Arrays.stream(arr).sorted().forEach(System.out::print);
		
//		filter, map, count, sorted, collect, Collectors
		
		
//		Stream.of("Tushar","patidar").limit(1).forEach(System.out::print);;
		
		Stream.generate(()->"tushar").limit(5).forEach(a->System.out.printf(a + " "));*/
		

		ArrayList<Character> alist = new ArrayList<Character>();
		
		alist.add('a');
		alist.add('t');
		alist.add('v');
		alist.add('H');
		alist.add('A');
		
//		alist.stream().filter(a -> a>90).iterator().forEachRemaining(System.out::println);;
	
		IntStream stream = "12345_abcdefg".chars();
//		stream.forEach(p -> System.out.println(p));
		
//		Stream<String> stream2 = Stream.of("hello@Hi@hey".split("\\@"));
//		stream2.forEach(System.out::println);
		
		alist.stream().map(Character::toUpperCase).forEach(System.out::println);
	}
}
