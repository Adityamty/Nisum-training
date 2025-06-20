public class EvenOddThreadDemo {
    static class EvenThread extends Thread {
        public void run() {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even: " + i);
                try {
                    Thread.sleep(500); 
                } catch (InterruptedException e) {
                    System.out.println("Even thread interrupted.");
                }
            }
        }
    }
    static class OddThread extends Thread {
        public void run() {
            for (int i = 1; i < 10; i += 2) {
                System.out.println("Odd: " + i);
                try {
                    Thread.sleep(500); 
                } catch (InterruptedException e) {
                    System.out.println("Odd thread interrupted.");
                }
            }
        }
    }
    public static void main(String[] args) {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();

        evenThread.start();
        oddThread.start();
    }
}
