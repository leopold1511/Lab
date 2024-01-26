import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Main {

    public static void main(String[] args) {
        Object resourceA = new Object();
        Object resourceB = new Object();
        int i = 0;
        new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Thread 1: locked resource A");
                try {
                    Thread.sleep(1000);
                } catch (Throwable ignored) {
                }
                System.out.println("Thread 1 trying to get B");
                synchronized (resourceB) {
                    System.out.println("Thread 1: locked resource B");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("Thread 2: locked resource B");
                try {
                    Thread.sleep(1000);
                } catch (Throwable ignored) {
                }
                System.out.println("Thread 2 trying to get A");
                synchronized (resourceA) {
                    System.out.println("Thread 2: locked resource A");
                }
            }
        }).start();
        new Thread(()-> {
            try {
                Thread.sleep(3000);
            } catch (Throwable ignored) {
            }
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            long[] t = threadMXBean.findDeadlockedThreads();
            if (t != null) {
                System.out.println("Deadlock");
            }
        }).start();

    }
}