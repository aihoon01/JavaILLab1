package ThreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ImageProcessingThreadPool {

    public static void main(String[] args) {
        // Create a ThreadPoolExecutor with 4 core threads and 4 maximum threads
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                4, // corePoolSize
                4, // maximumPoolSize
                60L, // keepAliveTime
                TimeUnit.SECONDS, // time unit for keepAliveTime
                new LinkedBlockingQueue<Runnable>() // workQueue
        );

        // Simulate processing 10 images
        for (int i = 1; i <= 10; i++) {
            int imageId = i;
            executor.submit(() -> processImage(imageId));
        }

        // Shutdown the executor
        executor.shutdown();

        try {
            // Wait for all tasks to complete
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All image processing tasks completed.");
    }

    private static void processImage(int imageId) {
        System.out.println("Processing image " + imageId + " on thread " + Thread.currentThread().getName());

        // Simulate image processing by sleeping for a random time
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Image " + imageId + " processed.");
    }
}
