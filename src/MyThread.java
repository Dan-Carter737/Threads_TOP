public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Stream" + Thread.currentThread().getName() + " STREAM OK");
    }
}
