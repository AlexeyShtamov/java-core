package school.sorokin.javacore.multithreading.lesson6;

import java.util.concurrent.CompletableFuture;

public class Task {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        task.findMagicNum(5);

        Thread.sleep(2000);
    }

    public void findMagicNum(int number){
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() ->
        {
            int finalNum = 1;
            try {
                if (number >= 10) throw new IllegalArgumentException("Cannot be more than 10");
                Thread.sleep(100);
                for (int i = 2; i <= number; i++) {
                    finalNum *= i;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return finalNum;
        })
                .thenApply(num -> num*(int)(Math.random()*10))
                .exceptionally(ex -> {
                    System.out.println("Thre ex: " + ex.getMessage());
                    return 0;
                });
        cf1.thenAccept(System.out::println);

        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() ->
                {
                    int finalNum = 1;
                    try {
                        if (number >= 10) throw new IllegalArgumentException("Cannot be more than 10");
                        Thread.sleep(100);
                        for (int i = 1; i <= number; i++) {
                            finalNum += i;
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return finalNum;
                })
                .exceptionally(ex -> {
                    System.out.println("The ex: " + ex.getMessage());

                    return 0;
                });
        cf2.thenAccept(System.out::println);

        cf1.thenCombine(cf2, Integer::sum).thenAccept(System.out::println);

    }


}
