public class PrimeSumMultiThreaded {

    static class PrimeSumWorker extends Thread {
        private final int start, end;
        private long localSum = 0;

        public PrimeSumWorker(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    localSum += i;
                }
            }
        }

        public long getLocalSum() {
            return localSum;
        }

        private boolean isPrime(int n) {
            if (n <= 1) return false;
            if (n == 2) return true;
            if (n % 2 == 0) return false;
            for (int i = 3; i * i <= n; i += 2) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int limit = 1_000_000;
        int numThreads = 4;
        int rangeSize = limit / numThreads;
        PrimeSumWorker[] workers = new PrimeSumWorker[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int start = i * rangeSize + 1;
            int end = (i == numThreads - 1) ? limit : (start + rangeSize - 1);
            workers[i] = new PrimeSumWorker(start, end);
            workers[i].start();
        }

        long totalSum = 0;
        for (PrimeSumWorker worker : workers) {
            worker.join();
            totalSum += worker.getLocalSum();
        }

        System.out.println("Sum of all prime numbers up to " + limit + " is: " + totalSum);
    }
}
