package code.w1;

import java.util.Scanner;
public class Main{
    public static double abs(double __)
    {
        return __>0 ? __:-__;
    }
    public static double read(String __)
    {
        int ___=0,flag=0;
        for(int i=0;i<__.length();i++)
        {
            if(__.charAt(i)=='-')
            {
                flag=1;
            }
            if(__.charAt(i)>='0' && __.charAt(i)<='9')
            {
                ___=___*10+__.charAt(i)-'0';
            }
        }
        if(flag==1) ___=-___;
        if(__.charAt(0)=='C')
        {
            return ___*1.0;
        }
        else if (__.charAt(0)=='F')
        {
            return (___-32.0)*5.0/9.0;
        }
        else if(__.charAt(0)=='K')
        {
            return ___-273.15;
        }
        return -1111.0;
    }
    public static void main(String[] args) {
        Scanner scanf=new Scanner(System.in);
        double mn=1e9+7,now;
        now=read(scanf.nextLine());
        int n=Integer.parseInt(scanf.nextLine()),mnid=0;
        for(int i=1;i<=n;i++)
        {
            double door=read(scanf.nextLine());
            // System.out.printf("%f\n",door);
            if(mn>abs(door-now))
            {
                mn=abs(door-now);
                mnid=i;
            } 
        }
        System.out.printf("%d",mnid);
        scanf.close();
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