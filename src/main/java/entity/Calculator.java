package entity;

public class Calculator {

    public static int result = 0;

    public static int add (int x,int y) {
        return result = x + y;
    }

    public static int subtract (int x,int y) {
        return result = x - y;
    }

    public static int multiply (int x,int y) {
        return result = x * y;
    }

    public static int division (int x,int y) {
        return result = x / y;
    }

    public static int count (int x) throws InterruptedException{
        Thread.sleep(1000);
        result = result + x;
        return result;
    }

    public synchronized static int synCount (int x) throws InterruptedException{
        Thread.sleep(1000);
        result = result + x;
        return result;
    }

    public static void clear() {
        result = 0;
        System.out.println("方法清零");
    }
}
