public class Counter {

    private  int count = 0;

    public  synchronized void increment() {
        count++;

    }
    public  synchronized void dicrement() {
        count--;

    }

    public int getCount() {
        return count;
    }
}
