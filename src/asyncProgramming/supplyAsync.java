package asyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class supplyAsync {
    public static void  delay(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompletableFuture<String> getCompose(String s){
        return CompletableFuture.supplyAsync(() -> s+"compose Addition ");
    }

    public static CompletableFuture<String> independent(){
        return CompletableFuture.supplyAsync(() -> "independent Addition ");
    }



    public static void main(String[] args) {
        Supplier<Integer> supplier = ()->{
            System.out.println("supplier "+Thread.currentThread().getName());
          return  Thread.currentThread().getPriority()+100;
        };

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier).thenCombine(independent(), (a, i)-> a+i);


        CompletableFuture<Void> completableFuture1 = completableFuture.thenApply(s-> s+" Apply addition ").thenCompose(supplyAsync::getCompose).thenAccept(System.out::println);

        System.out.println(completableFuture.join());
        completableFuture1.join();
    }
}
