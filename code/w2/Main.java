package code.w2;
import java.util.Scanner;
class Main{
    static int n,m;
    static int[][] f,vis;
    static double[][] a;
    public static double dp(int x,int y)
    {
        // System.out.printf("%d %d\n",x,y);
        if(vis[x][y]==1)
        {
            return 0;
        }
        vis[x][y]=1;
        if(f[x][y]==0)
        {
            vis[x][y]=0;
            return a[x][y];
        }
        if(f[x][y]==1)
        {
            if(f[x+1][y]+f[x-1][y]+f[x][y+1]+f[x][y-1]>=3)
            {
                // dp(x+1,y);
                // dp(x-1,y);
                // dp(x,y+1);
                // dp(x,y-1);
                // if(f[x+1][y]+f[x-1][y]+f[x][y+1]+f[x][y-1]>=3)
                // {
                //     System.out.println("DATA CANNOT BE REPAIRED");
                //     System.exit(0);
                // }
                return -1;
            }
            if(f[x+1][y]+f[x-1][y]+f[x][y+1]+f[x][y-1]==2)
            {
                if(f[x][y+1]==1&&f[x][y-1]==1)
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x+1,y)/2+dp(x-1,y)/2;
                }
                else if(f[x+1][y]==1&&f[x-1][y]==1)
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x,y+1)*3/5+dp(x,y-1)*2/5;
                }
                else 
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=(f[x+1][y]==0? dp(x+1,y):dp(x-1,y))*2/5+(f[x][y+1]==0? dp(x,y+1):dp(x,y-1))*3/5;
                }
            }
            else if(f[x+1][y]+f[x-1][y]+f[x][y+1]+f[x][y-1]==1)
            {
                if(f[x+1][y]==1)
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x-1,y)/5+dp(x,y+1)*2/5+dp(x,y-1)*2/5;
                }
                else if(f[x-1][y]==1)
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x+1,y)/5+dp(x,y+1)*2/5+dp(x,y-1)*2/5;
                }
                else if(f[x][y+1]==1)
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x+1,y)*7/20+dp(x-1,y)*7/20+dp(x,y-1)*3/10;
                }
                else
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x+1,y)*7/20+dp(x-1,y)*7/20+dp(x,y+1)*3/10;
                }
            }
            else
            {
                f[x][y]=0;
                vis[x][y]=0;
                return a[x][y]=dp(x+1,y)/5+dp(x-1,y)/5+dp(x,y+1)*3/10+dp(x,y-1)*3/10;
            }

        }
        return -1;
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        a=new double[n+10][m+10];
        f=new int[n+10][m+10];
        vis=new int[n+10][m+10];
        for(int i=0;i<=n+1;i++)
        {
            f[i][0]=f[i][m+1]=1;
        }
        for(int i=0;i<=m+1;i++)
        {
            f[0][i]=f[n+1][i]=1;
        }
        for(int i=1;i<=n;i++) for(int j=1;j<=m;j++)
        {
            a[i][j]=scan.nextInt();
            f[i][j]=(a[i][j]==-1?1:0);
        }
        int x=scan.nextInt();
        int y=scan.nextInt();
        double ans=dp(x,y);
        if(ans==-1)
        {
            System.out.println("DATA CANNOT BE REPAIRED");
        }
        else
        {
            System.out.printf("%d",(int)ans);
        }
    }
}
/*
class Main3{
    static int n,m;
    static int[][] f,vis;
    static double[][] a;
    public static double dp(int x,int y)
    {
        // System.out.printf("%d %d\n",x,y);
        if(vis[x][y]==1)
        {
            return 0;
        }
        vis[x][y]=1;
        if(f[x][y]==0)
        {
            vis[x][y]=0;
            return a[x][y];
        }
        if(f[x][y]==1)
        {
            if(f[x+1][y]+f[x-1][y]+f[x][y+1]+f[x][y-1]>=3)
            {
                // dp(x+1,y);
                // dp(x-1,y);
                // dp(x,y+1);
                // dp(x,y-1);
                // if(f[x+1][y]+f[x-1][y]+f[x][y+1]+f[x][y-1]>=3)
                // {
                //     System.out.println("DATA CANNOT BE REPAIRED");
                //     System.exit(0);
                // }
                return -1;
            }
            if(f[x+1][y]+f[x-1][y]+f[x][y+1]+f[x][y-1]==2)
            {
                if(f[x][y+1]==1&&f[x][y-1]==1)
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x+1,y)/2+dp(x-1,y)/2;
                }
                else if(f[x+1][y]==1&&f[x-1][y]==1)
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x,y+1)*3/5+dp(x,y-1)*2/5;
                }
                else 
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=(f[x+1][y]==0? dp(x+1,y):dp(x-1,y))*2/5+(f[x][y+1]==0? dp(x,y+1):dp(x,y-1))*3/5;
                }
            }
            else if(f[x+1][y]+f[x-1][y]+f[x][y+1]+f[x][y-1]==1)
            {
                if(f[x+1][y]==1)
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x-1,y)/5+dp(x,y+1)*2/5+dp(x,y-1)*2/5;
                }
                else if(f[x-1][y]==1)
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x+1,y)/5+dp(x,y+1)*2/5+dp(x,y-1)*2/5;
                }
                else if(f[x][y+1]==1)
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x+1,y)*7/20+dp(x-1,y)*7/20+dp(x,y-1)*3/10;
                }
                else
                {
                    f[x][y]=0;
                    vis[x][y]=0;
                    return a[x][y]=dp(x+1,y)*7/20+dp(x-1,y)*7/20+dp(x,y+1)*3/10;
                }
            }
            else
            {
                f[x][y]=0;
                vis[x][y]=0;
                return a[x][y]=dp(x+1,y)/5+dp(x-1,y)/5+dp(x,y+1)*3/10+dp(x,y-1)*3/10;
            }

        }
        return -1;
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        m=scan.nextInt();
        a=new double[n+10][m+10];
        f=new int[n+10][m+10];
        vis=new int[n+10][m+10];
        for(int i=0;i<=n+1;i++)
        {
            f[i][0]=f[i][m+1]=1;
        }
        for(int i=0;i<=m+1;i++)
        {
            f[0][i]=f[n+1][i]=1;
        }
        for(int i=1;i<=n;i++) for(int j=1;j<=m;j++)
        {
            a[i][j]=scan.nextInt();
            f[i][j]=(a[i][j]==-1?1:0);
        }
        int x=scan.nextInt();
        int y=scan.nextInt();
        double ans=dp(x,y);
        if(ans==-1)
        {
            System.out.println("DATA CANNOT BE REPAIRED");
        }
        else
        {
            System.out.printf("%d",(int)ans);
        }
    }
}
class Main2{
    static int n;
    static int[] cat,catf,dog,dogf; //0有数据,1无数据,2必死
    public static int Cat(int x)
    {
        if(catf[x]==0)
        {
            return cat[x];
        }
        if(catf[x]==1&&x==1)
        {
            catf[x]=0;
            return cat[x]=Cat(x+1)*4/5;
        }
        if(catf[x]==1&&x==n)
        {
            catf[x]=0;
            return cat[x]=Cat(x-1)*4/5;
        }
        if(catf[x]==1)
        {
            catf[x]=0;
            return cat[x]=Cat(x-1)*2/5+Cat(x+1)*3/5;
        }
        return -1;
    }
    public static int Dog(int x)
    {
        if(dogf[x]==0)
        {
            return dog[x];
        }
        if(dogf[x]==1&&x==1)
        {
            dogf[x]=0;
            return dog[x]=Dog(x+1)*4/5;
        }
        if(dogf[x]==1&&x==n)
        {
            dogf[x]=0;
            return dog[x]=Dog(x-1)*4/5;
        }
        if(dogf[x]==1)
        {
            dogf[x]=0;
            return dog[x]=Dog(x-1)*2/5+Dog(x+1)*3/5;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        cat=new int[n+10];
        catf=new int[n+10]; 
        dog=new int[n+10];
        dogf=new int[n+10];
        for(int i=1;i<=n;i++)
        {
            cat[i]=scan.nextInt();
            catf[i]=(cat[i]==-1?1:0);
            if(catf[i]==1&&(catf[i-1]==1 || catf[i-1]==2))
            {
                catf[i]=2;
                catf[i-1]=2;
            }
        }
        for(int i=1;i<=n;i++)
        {
            dog[i]=scan.nextInt();
            dogf[i]=(dog[i]==-1?1:0);
            if(dogf[i]==1&&(dogf[i-1]==1 || dogf[i-1]==2))
            {
                dogf[i]=2;
                dogf[i-1]=2;
            }
        }
        int m=scan.nextInt();
        // for(int i=1;i<=n;i++)
        // {
        //     System.out.printf("%d %d %d %d\n",cat[i],catf[i],dog[i],dogf[i]);
        // }
        if(catf[m]==2 && dogf[m]==2)
        {
            System.out.println("ALL DATA LOST");
        }
        else if (catf[m]==2)
        {
            System.out.println("CAT DATA LOST");
        }
        else if (dogf[m]==2)
        {
            System.out.println("DOG DATA LOST");
        }
        else
        {
            System.out.printf("%d",Cat(m)+Dog(m));
        }
        scan.close();
    }
}
class Main1{
    public static void main(String[] args) 
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int f[]=new int[n+10];
        for(int i=1;i<=n;i++)
        {
            int a=scan.nextInt();
            f[i]+=(a==-1?1:0);
        }
        for(int i=1;i<=n;i++)
        {
            int a=scan.nextInt();
            f[i]+=(a==-1?1:0);
        }
        int m=scan.nextInt();
        System.out.printf("%d\n",f[m]);

        scan.close();
    }
}
*/