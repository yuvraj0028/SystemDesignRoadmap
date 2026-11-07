package SystemDesignRoadmap.design_patterns.singleton.java;

class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

public class Singleton {
    public static void main(String[] args) {
        ThreadSafeSingleton a = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton b = ThreadSafeSingleton.getInstance();

        System.out.println(a == b ? "Equal" : "Unequal");
    }
}
