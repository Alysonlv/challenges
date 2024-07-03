package corp.alv.challenges.study.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DefaultThreadFactoryExample {
    public static void main(String[] args) {
        // Create an ExecutorService with the default ThreadFactory
        ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
        ExecutorService executor = Executors.newFixedThreadPool(3, defaultThreadFactory);

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
