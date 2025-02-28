package code;

import java.util.Scanner;

class A{
    public int a(int x) {
        return x * x;
    }

    public static int b(int x) {
        return x * x + 1;
    }

    private int c(int x) {
        return x * x + 2;
    }

    private static int d(int x) {
        return x * x + 3;
    }
}

class hello {
    public int f(int x) {
        return x * x;
    }

    public static int g(int x) {
        return x * x + 1;
    }

    private int h(int x) {
        return x * x + 2;
    }

    private static int i(int x) {
        return x * x + 3;
    }

    public static void main(String[] args) {
        System.out.printf("hello");
        // Scanner scanner= new Scanner(System.in);
        // int a=scanner.nextInt();
        // int b=scanner.nextInt();
        // System.out.printf("hello %d \n",a+b);
        // System.out.print(a+b);
        // System.out.println(a+b);
        // scanner.close();
        System.out.printf("hello %d \n", f(5));
        System.out.printf("hello %d \n", g(5));
        System.out.printf("hello %d \n", h(5));
        System.out.printf("hello %d \n", i(5));
        A a = new A();
        System.out.printf("hello %d \n", a.a(5));  
        System.out.printf("hello %d \n", a.b(5));
        System.out.printf("hello %d \n",A.b(5));
        System.out.printf("hello %d \n", a.c(5));
        System.out.printf("hello %d \n", a.d(5));

    }
}