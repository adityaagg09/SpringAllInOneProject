package Base.Concurrency;

public class RunThreadWhichImplementsRunnable implements Runnable {
    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println(Thread.currentThread().getId());
            try {
                Thread.sleep(500); // It will hault the process for around 1/2 sec
            } catch (InterruptedException e) {
                e.printStackTrace(); // What does this do ?
                Thread.currentThread().interrupt(); // It should get interrupted
                break;  // if in a for loop else everytime it will throw this exception
            }
        }
        System.out.println("In runnable");
    }
}
