package corp.alv.challenges.study.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {
    public static void main(String[] args) {
        // Create an ExecutorService with a custom ThreadFactory
        ThreadFactory customThreadFactory = new CustomThreadFactory("MyPool");
        ExecutorService executor = Executors.newFixedThreadPool(5, customThreadFactory);

        // Submit tasks to the executor
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
            });
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
