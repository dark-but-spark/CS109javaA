package code;
import java.util.Scanner;
class hello
{
    public static void main(String[] args) {
        System.out.printf("hello");
        Scanner scanner= new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        System.out.printf("hello %d \n",a+b);
        System.out.print(a+b);
        System.out.println(a+b);
        scanner.close();
    }
}