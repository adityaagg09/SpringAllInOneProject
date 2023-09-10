package Base.Concurrency;

public class Volatile {


    // As multiple processors operate in parallel, and independently multiple caches may possess different copies of the same memory block, this creates a cache coherence problem
    // this can be resolved by using the volatile keyword

    // ---------------------Volatile Keyword ------------------------

    // When a variable is declared as volatile it's value is written directly into memory and read from memory only, not from cached-specific memory
    // So that each thread has the latest value
    private static volatile int countOfPeople = 0 ;

    // The order of volatile is not changed, it's get executed in the same manner it is declared as not true with other elements
    // All the data above this keyword is flushed to the main memory

    // All operations to it are atomic

    public static class informationAboutVolatile extends Thread {
        @Override
        public void run() {
            // Simulate some game events
            for (int i = 0; i < 10 ; i++) {
                // Update the counter
                    countOfPeople++;
                System.out.println("Player updated counter: " + countOfPeople );
            }
        }
    }

    public static void main(String[] args) {
        // Create multiple player threads
        informationAboutVolatile player1 = new informationAboutVolatile();
        informationAboutVolatile player2 = new informationAboutVolatile();

        player1.start();
        player2.start();
    }

}
