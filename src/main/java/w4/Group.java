package w4;
public class Group {
    private Student student1;
    private Student student2;
    private char lab;
    public Group(Student student1, char lab) {
        this.student1 = student1;
        this.lab = lab;
        this.student2 = null;
    }
    public Group(Student student1, Student student2, char lab) {
        this.student1 = student1;
        this.student2 = student2;
        this.lab = lab;
    }
    //getters------------------------
    public Student getStudent1() {
        return student1;
    }
    public Student getStudent2() {
        return student2;
    }
    public char getLab() {
        return lab;
    }
    //setters------------------------
    public void setStudent1(Student student1) {
        this.student1 = student1;
    }
    public void setStudent2(Student student2) {
        this.student2 = student2;
    }
    public void setLab(char lab) {
        this.lab = lab;
    }
    

    public boolean checkSameLab()
    {
        if (student2==null)
        {
            return false;
        }
        else
        {
            return student1.getLab() == student2.getLab() && student1.getLab() == this.lab;
        }
            
    }
    public String toString()
    {
        if(student2==null)
        {
            return this.lab+"_"+student1.getStudentNumber()+"_null";
        }
        else
        {
            String s1=student1.getStudentNumber().compareTo(student2.getStudentNumber())<0?
                    student1.getStudentNumber():student2.getStudentNumber();
            String s2=student1.getStudentNumber().compareTo(student2.getStudentNumber())>0?
                    student1.getStudentNumber():student2.getStudentNumber();
            return this.lab+"_"+s1+"_"+s2;
        }
    }
    // public static void main(String[] args) {
    //     Student s1 = new Student("124001", 'A', 90);
    //     Student s2 = new Student("124002", 'A', 95);
    //     Student s3 = new Student("124003", 'B', 91);
    //     Group g1 = new Group(s2, s1, 'A');
    //     Group g2 = new Group(s3, 'B');
  
    //     System.out.println(g1);
    //     System.out.println(g2);
    // }
}
