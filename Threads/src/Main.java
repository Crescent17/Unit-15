public class Main {
    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the main thread");
        AnotherThread anotherThread = new AnotherThread();
        anotherThread.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");
    }
}
