class Box {
    public synchronized void openingBox(Thread t) throws InterruptedException {
        System.out.println("opening box by " + t.getName());
        Thread.sleep(5000);
        System.out.println("Box closed by " + t.getName());
    }

    public void putThingsInBox(Thread t) throws InterruptedException {
        System.out.println("putThingsInBox by thread" + t.getName());
        Thread.sleep(4000);
        System.out.println("Things placed exiting " + t.getName());
    }
}

public class Synchronization {
    static Box box = new Box();
    public static void main(String[] args) throws Exception {


        Thread t1 = new Thread() {
            public void run() {
                try {
                    box.openingBox(this);
                } catch(Exception e) {

                }
            }
        };
        Thread t2 = new Thread() {
            public void run()  {
                try {
                    box.putThingsInBox(this);
                } catch(Exception e) {

                }
            }
        };

        t1.setName("thread1");
        t2.setName("thread2");

        t1.start();
        t2.start();
    }
}