package BasicJava;

class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread extends Thread {
    Table t;

    MyThread(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(5);
    }
}

public class ThreadBasic {
    public static void main(String args[]) {
        Table obj = new Table();
        MyThread t1 = new MyThread(obj);
        MyThread t2 = new MyThread(obj);
        t1.start();
        t2.start();
    }
}
