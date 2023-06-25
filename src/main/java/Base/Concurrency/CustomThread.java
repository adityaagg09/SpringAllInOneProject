package Base.Concurrency;

// Here we can extend thread
public class CustomThread extends Thread{
    public void run() {
        System.out.println("I'm a custom thread");
    }
}
