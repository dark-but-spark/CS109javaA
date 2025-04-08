package w4;
public class GroupSystem {
    private static int[] fa,size,vis;
    private static int n;

    private static int find(int x)
    {
        return fa[x]= fa[x]==x? x:find(fa[x]);
    }

    public static Student[] check(Student[] students, Group[] groups)
    {
        n=students.length;
        fa=new int[n+10];
        size=new int[n+10];
        vis=new int[n+10];
        for(int i=0;i<n;i++)
        {
            fa[i]=i;
            size[i]=1;
            vis[i]=0;
        }
        for(Group group:groups)
        {
            int x=0,y=0;
            Student student1=group.getStudent1();
            for(int i=0;i<n;i++)
            {
                if(students[i].getStudentNumber().equals(student1.getStudentNumber()))
                {
                    x=i;
                    break;
                }

            }
            Student student2=group.getStudent2();
            if(student2==null)
            {
                vis[x]=1;
                size[x]=999;
                continue;
            }
            for(int i=0;i<n;i++)
            {
                if(students[i].getStudentNumber().equals(student2.getStudentNumber()))
                {
                    y=i;
                    break;
                }

            }
            x=find(x);
            y=find(y);
            if(x!=y)
            {
                fa[x]=y;
                size[y]+=size[x];
            }
            if(vis[x]==1 ||vis[y]==1)
            {
                size[y]=999;
            }
            vis[x]=vis[y]=1;
            if(!group.checkSameLab())
            {
                size[y]=999;
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                cnt++;
            }
            int ii=find(i);
            if(size[ii]>2)
            {
                cnt++;
            }
        }
        Student[] ans=new Student[cnt];
        cnt=0;

        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                ans[cnt]=students[i];
                cnt++;
            }
            int ii=find(i);
            if(size[ii]>2)
            {
                ans[cnt]=students[i];
                cnt++;
            }
        }
        if(cnt==0)
        {
            return null;
        }
        else
        {
            return ans;
        }
    }
    public static Group[] group(Student[] students)
    {
        int n=students.length;
        vis=new int[n+10];
        Group[] ans=new Group[n+10];
        int top=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(students[j-1].getGrade()<students[j].getGrade() )
                {
                    Student temp=students[j-1];
                    students[j-1]=students[j];
                    students[j]=temp;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                int mx=0,mxid=-1;
                for(int j=i+1;j<n;j++)
                {
                    if(students[i].getLab()==students[j].getLab() && vis[j]==0)
                    {
                        if(students[j].getGrade()>mx)
                        {
                            mx=students[j].getGrade();
                            mxid=j;
                        }
                    }
                    
                }
                if(mxid!=-1)
                {
                    ans[top]=new Group(students[i],students[mxid],students[i].getLab());
                    vis[i]=1;
                    vis[mxid]=1;
                    top++;
                }
                else
                {
                    ans[top]=new Group(students[i],students[i].getLab());
                    vis[i]=1;
                    top++;
                }
            }
        }
        Group[] ans2=new Group[top];
        for(int i=0;i<top;i++)
        {
            ans2[i]=ans[i];
        }
        ans=null;
        return ans2;

    }
//    public static void main(String[] args) {
//        Student[]  students= new Student[4];
//        students[0] = new Student("12410101",'A',85);
//        students[1] = new Student("12410102",'A',90);
//        students[2] = new Student("12410104",'A',75);
//        students[3] = new Student("12410103",'A',80);
//
//
//        Group[] groups = GroupSystem.group(students);
//        for(Group g: groups){
//            System.out.println(g);
//        }
//    }
}
