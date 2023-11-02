package asyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class runAsync {
    public static void  delay(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {

        Runnable runnable = ()->{
            delay(1);
            System.out.println("From runnable " + Thread.currentThread().getName());
        };

        Runnable runnable1 = ()->{
            delay(1);
            System.out.println("From runnable1 " + Thread.currentThread().getName());
        };
        CompletableFuture<String> completableFuture = null;

        completableFuture = CompletableFuture.runAsync(runnable).thenApply(s->s+" add");

        System.out.println("RUNNING NEXT");
        CompletableFuture<Void> completableFuture1 = completableFuture.thenRun(runnable1);

        System.out.println("From MAIN "+Thread.currentThread().getName());

        completableFuture.join();
        completableFuture1.join();
        System.out.println(completableFuture);
    }
}
