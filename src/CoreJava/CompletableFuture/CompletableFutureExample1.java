package CoreJava.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample1 {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });

        // thenApplyAsync() method is used to process and transform the result of a CompletableFuture when it arrives.

        CompletableFuture<Integer> result = future.thenApplyAsync(value -> {
            System.out.println("Computation Result " + value);
            return value * 2;
        });

        // thenAccept() method is used to consume the result of a CompletableFuture when it arrives.
        result.thenAccept(value -> System.out.println("Value" + value));

        // block the main thread to wait for the result
        result.join();
    }
}

// diffence between thenApply() and thenApplyAsync() method, thenApply() method is used to process and transform the result of a CompletableFuture when it arrives.
// The thenApplyAsync() method is used to process and transform the result of a CompletableFuture asynchronously using the provided executor when it arrives.
