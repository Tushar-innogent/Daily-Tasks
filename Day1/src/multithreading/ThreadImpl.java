package multithreading;

import java.util.ArrayList;
import java.util.List;

public class ThreadImpl {

	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }

        // Test with stream()
        long startTimeStream = System.currentTimeMillis();
        int sumStream = list.stream().mapToInt(Integer::intValue).sum();
        long endTimeStream = System.currentTimeMillis();
        System.out.println("Stream result: " + sumStream);
        System.out.println("Stream time: " + (endTimeStream - startTimeStream) + " ms");

        // Test with parallelStream()
        long startTimeParallelStream = System.currentTimeMillis();
        int sumParallelStream = list.parallelStream().mapToInt(Integer::intValue).sum();
        long endTimeParallelStream = System.currentTimeMillis();
        System.out.println("ParallelStream result: " + sumParallelStream);
        System.out.println("ParallelStream time: " + (endTimeParallelStream - startTimeParallelStream) + " ms");
        
	}
}

class Customer{
	
	String name;

	public Customer(String name) {
		super();
		this.name = name;
	}
	
	
}