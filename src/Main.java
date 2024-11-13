import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyThread thread = new MyThread();
        thread.start();

        Counter counter = new Counter();

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Runnable() {
            public void run() {
                System.out.println("Another thread was executed");
            }
        });

        ExecutorService service1 = Executors.newSingleThreadExecutor();
        ExecutorService service2 = Executors.newFixedThreadPool(2);

        Thread s1 = new Thread(() -> {
            for (int i = 0; i <= 1000; i++) {
                counter.increment();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //service1.submit(s1);
        service1.shutdown();
        Thread s2 = new Thread(() -> {
            for (int i = 1000; i>= 0; i--) {
                counter.dicrement();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        //service2.submit(s2);
        service2.shutdown();

        //while (!service.isTerminated()) {}

        System.out.println("Final Counter " + counter.getCount());







    }
}