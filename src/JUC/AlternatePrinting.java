package JUC;

public class AlternatePrinting {

    private static final Object lock = new Object();
    private static boolean isOdd = false;

    public static void main(String[] args) {
        Thread T1 = new Thread(() -> {
            for (int i = 0; i <= 100; i += 2) {
                synchronized (lock) {
                    while (isOdd) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    System.out.println("t1:" + i);
                    isOdd = true;
                    lock.notify();
                }
            }
        });
        Thread T2 = new Thread(() -> {
            for (int i = 1; i < 100; i += 2) {
                synchronized (lock) {
                    while (!isOdd) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    System.out.println("t2:" + i);
                    isOdd = false;
                    lock.notify();
                }

            }
        });
        T1.start();
        T2.start();
    }
//
//    public static void main(String[] args) {
//        Thread oddThread = new Thread(() -> {
//            for (int i = 1; i <= 100; i += 2) {
//                synchronized (lock) {
//                    while (isOdd) {
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            Thread.currentThread().interrupt();
//                            return;
//                        }
//                    }
//                    System.out.println("t1:"+i);
//                    isOdd = true;
//                    lock.notify();
//                }
//            }
//        });
//
//        Thread evenThread = new Thread(() -> {
//            for (int i = 2; i <= 100; i += 2) {
//                synchronized (lock) {
//                    while (!isOdd) {
//                        try {
//                            lock.wait();
//                        } catch (InterruptedException e) {
//                            Thread.currentThread().interrupt();
//                            return;
//                        }
//                    }
//                    System.out.println("t2:"+i);
//                    isOdd = false;
//                    lock.notify();
//                }
//            }
//        });
//
//        oddThread.start();
//        evenThread.start();
//    }

}
