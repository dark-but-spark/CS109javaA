package w3;

import java.util.Scanner;



class Main
{
    public static char[][] a;
    public static int[][] vis;
    public static int n,m,sum;
    public static String old_,new_;
    public static int dx[]={0,1,0,-1};
    public static int dy[]={1,0,-1,0};
    public static String exchange(String s)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==old_.charAt(0))
            {
                boolean flag=false;
                for(int j=0;j<old_.length();j++)
                {
                    if(i+j>=s.length()||s.charAt(i+j)!=old_.charAt(j))
                    {
                        flag=true;break;
                    }
                }
                if(flag==false)
                {
                    sb.append(new_);
                    i+=old_.length()-1;
                }
                else
                {
                    sb.append(s.charAt(i));
                }
            }
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();m=scan.nextInt();
        a=new char[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                a[i][j]=scan.next().charAt(0);
            }
        }
        old_=scan.next();
        new_=scan.next();
        vis=new int[n][m];
        StringBuilder sb=new StringBuilder();
        int x=0,y=0,direction=0;

        for(int i=0;i<n*m;i++)
        {
            sb.append(a[x][y]);
            vis[x][y]=1;
            int xx=x+dx[direction],yy=y+dy[direction];
            if(xx<0||xx>=n||yy<0||yy>=m||vis[xx][yy]==1)
            {
                direction=(direction+1)%4;
                xx=x+dx[direction];yy=y+dy[direction];
                if(xx<0||xx>=n||yy<0||yy>=m||vis[xx][yy]==1) break;
            }
            x=xx;y=yy;
        }
        String s=exchange(sb.toString());
        vis=new int[n][m];
        x=0;y=0;direction=0;
        for(int i=0;i<n*m;i++)
        {
            a[x][y]=s.charAt(i);
            vis[x][y]=1;
            int xx=x+dx[direction],yy=y+dy[direction];
            if(xx<0||xx>=n||yy<0||yy>=m||vis[xx][yy]==1)
            {
                direction=(direction+1)%4;
                xx=x+dx[direction];yy=y+dy[direction];
                if(xx<0||xx>=n||yy<0||yy>=m||vis[xx][yy]==1) break;
            }
            x=xx;y=yy;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.printf("%c ",a[i][j]);
            }
            System.out.printf("\n");
        }
        scan.close();

    }
}
/* 
class Matrix
{
    private int row;
    private int colunm;
    private int a[][];

    Matrix(int row,int colunm,int value[][])
    {
        this.row=row;
        this.colunm=colunm;
        this.a=value;
    }
    public String print()
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<colunm;j++)
            {
                sb.append(a[i][j]);
                if(j!=colunm-1) sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public Matrix multiply(Matrix that)
    {
        if(this.colunm!=that.row) return null;
        Matrix result=new Matrix(this.row,that.colunm,new int[this.row][that.colunm]);
        for(int i=0;i<this.row;i++)
        {
            for(int j=0;j<that.colunm;j++)
            {
                for(int o=0;o<this.colunm;o++)
                {
                    result.a[i][j]+=( (o+1)%w6.Main.k==0? -1:1)*this.a[i][o]*that.a[o][j];
                }
            }
        }
        return result;
    }
    public Matrix T()
    {
        Matrix result=new Matrix(this.colunm,this.row,new int[this.colunm][this.row]);
        for(int i=0;i<this.row;i++)
        {
            for(int j=0;j<this.colunm;j++)
            {
                result.a[j][i]=this.a[i][j];
            }
        }
        return result;
    }
}

class Main2
{
    public static Matrix A,B;
    public static int n,m,p,k;
    public static void main(String[] args)
    {
        int[][] a,b;
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();m=scan.nextInt();p=scan.nextInt();k=scan.nextInt();
        a=new int[n][m];
        b=new int[m][p];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                a[i][j]=scan.nextInt();
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<p;j++)
            {
                b[i][j]=scan.nextInt();
            }
        }
        A=new Matrix(n,m,a);
        B=new Matrix(m,p,b);
        System.out.printf("%s",A.multiply(B).T().print());
    }


}


class Main1 {
    public static boolean isDigit( char c)
    {
        return c>='0'&&c<='9';
    }
    public static boolean isLetter(char c)
    {
        return c>='a'&&c<='z'||c>='A'&&c<='Z';
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s=scan.nextLine();
        scan.close();
        int[] a=new int[10010];
        int top=0,ans=0;
        for(int i=0;i<s.length();i++)
        {
            if(isDigit(s.charAt(i)))
            {
                a[top]=s.charAt(i)-'0';
                top++;
                if(i==s.length()-1 ||isLetter(s.charAt(i+1)))
                {
                    int del_id=(top-1)/2,sum=0,l=top;
                    // System.out.printf("top=%d\n",top);
                    while(top>0)
                    {
                        top--;
                        if(top==del_id&&l%2==1) continue;
                        sum=sum*10+a[top];
                    }
                    // System.out.printf("sum=%d\n",sum);
                    ans+=sum;
                }
            }
            if(isLetter(s.charAt(i)))
            {
                a[top]=s.charAt(i);
                top++;
                if(i==s.length()-1 ||isDigit(s.charAt(i+1)))
                {
                    // System.out.printf("top=%d\n",top);
                    int del_id=(top-1)/2,sum=0,l=top;
                    while(top>0)
                    {
                        top--;
                        if(top==del_id&&l%2==1) continue;
                        sum+=a[top];
                    }
                    
                    // System.out.printf("sum=%d\n",sum);
                    ans+=sum;
                }
            }

        }
        System.out.printf("%d\n",ans);
    }
}
*/