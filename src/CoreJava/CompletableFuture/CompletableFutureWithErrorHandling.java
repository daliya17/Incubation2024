package CoreJava.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureWithErrorHandling {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return  10 / 0;
        });

        future.exceptionally(ex -> {
            System.out.println("Error Occured " + ex.getMessage());
            return -1;
        }).thenAccept(value -> {
            System.out.println("Fallback " + value);
        });
        future.join();
    }

}


