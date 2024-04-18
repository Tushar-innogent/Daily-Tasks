package multithreading;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorService {

//	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		executorService.execute(new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("ExecutorService");
//
//			}
//		});
//		executorService.shutdown();
//	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService eService = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 10; i++) {
			eService.submit(() -> {
				System.out.println(Thread.currentThread().getName());
			});
		}
		eService.shutdown();

		try {
			// Wait for all tasks to complete or for 1 minute, whichever comes first
			eService.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.err.println("Tasks interrupted");
		}

		System.out.println("All tasks completed");

//			ExecutorService executorService = Executors.newFixedThreadPool(2 );
//			
//			executorService.awaitTermination(8, TimeUnit.MICROSECONDS);
//			
//	        Set<Callable<String>> callables = new HashSet<Callable<String>>();  
//	        callables.add(new Callable<String>() {  
//	            public String call() throws Exception {  
//	                return "Task 1";  
//	            }  
//	        });  
//	        callables.add(new Callable<String>() {  
//	            public String call() throws Exception {  
//	                return "Task 2";  
//	            }  
//	        });  
//	        callables.add(new Callable<String>() {  
//	            public String call() throws Exception {  
//	                return "Task 3";  
//	            }  
//	        });  
//	        callables.add(new Callable<String>() {  
//	        	public String call() throws Exception {  
//	        		return "Task 4";  
//	        	}  
//	        });  
//	        callables.add(new Callable<String>() {  
//	        	public String call() throws Exception {  
//	        		return "Task 5";  
//	        	}  
//	        });  
//	  
//	        List<Future<String>> futures  = executorService.invokeAll(callables);  
//	  
//	  
//	        futures.forEach(a-> {
//				try {
//					System.out.println(a.get());
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ExecutionException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			});
//	        
//	        executorService.execute(new Runnable() {  
//	              
//	            @Override  
//	            public void run() {  
//	                System.out.println("ExecutorService");  
//	                  
//	            }  
//	        });
//	        
//	        executorService.shutdownNow();  
//	        
//	        
//	        
//	        System.out.println(executorService.isTerminated());
	}
}
