package code.w1;

import java.util.Scanner;
public class Main{
    public static double read(char c,int x)
    {
        if(c==)
    }
    public static void main(String[] args) {
        Scanner scanf=new Scanner(System.in);
        int l=scanf.nextInt(),r=scanf.nextInt();
        
    }
}
/* 
public class Main3
{
    public static boolean check(int x)
    {
        int sum=1;
        for(int i=2;i*i<=x;i++)
        {
            if(x%i==0)
            {
                sum+=i;
                if(i!=x/i)
                {
                    sum+=x/i;
                }
            }
            if(sum>x)
            {
                return false;
            }
        }
        return sum==x;
    }
    public static void main(String[] args) {
        Scanner scanf=new Scanner(System.in);
        int l=scanf.nextInt(),r=scanf.nextInt();
        int flag=0;
        for(int i=l>6?l:6;i<=r;i++)
        {
            if(check(i))
            {
                flag=1;
                System.out.printf("%d",i);
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("-1");
        }
         scanf.close();
    }
}
public class Main2 {

    public static void main(String[] args) {
        Scanner scanf=new Scanner(System.in);
        int n=scanf.nextInt(),m=scanf.nextInt();
        int[] f=new int[]{0,0,0,0,0,0,0,0,0,0,0};
        while(n>0)
        {
            f[n%10]+=1;
            n/=10;
        }
        // for(int i=0;i<10;i++)
        // {
        //     System.out.printf("%d",f[i]);
        // }
        if(m==0)
        {
            for(int i=9;i>=0;i--)
            {
                if(f[i]>0)
                {
                    for(int j=1;j<=f[i];j++)
                    {
                        System.out.printf("%d",i);
                    }
                }
            }
        }
        else if(m==1)
        {
            for(int i=0;i<10;i++)
            {
                if(f[i]>0)
                {
                    for(int j=1;j<=f[i];j++)
                    {
                        System.out.printf("%d",i);
                    }
                }
            }
        }
        scanf.close();
    }

}
public class Main1 {
    public static void main(String[] args) {
        Scanner scanf=new Scanner(System.in);
        int n=scanf.nextInt();
        while(n>0)
        {
            n-=1;
            int a=scanf.nextInt();
            System.out.printf("%d\n",a%10);
        }
    }
}
*/