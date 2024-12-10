package CoreJava.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ChainingWithCombine {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });

        CompletableFuture<Integer> result = future.thenCombine(future2, Integer::sum);
        result.thenAccept(sum -> System.out.println("Sum " + sum));
        result.join();
    }
}
