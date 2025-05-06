package w6;

public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour=hour;
        this.minute=minute;
        if(hour<0 || hour>23 || minute<0 || minute>59) {
            System.out.println("What fuck is this?");
        }
    }

    public Time(Time t){
        this.hour=t.getHour();
        this.minute=t.getMinute();
        if(hour<0 || hour>23 || minute<0 || minute>59) {
            System.out.println("What fuck is this?");
        }
    }

    public void addMinutes(int minutes) {
        this.minute+=minutes;
        this.hour+=this.minute/60;
        this.minute%=60;
        this.hour%=24;
    }
    @Override
    public String toString() {
        String hourStr = String.format("%02d", hour);
        String minuteStr = String.format("%02d", minute);
        return hourStr + ":" + minuteStr;
    }
    //getter
    public int getHour() {return hour;}
    public int getMinute() {return minute;}



    public static void main(String[] args) {
        Time t1 = new Time(1, 20);
        t1.addMinutes(50);
        System.out.println(t1);
        System.out.println(new Time(12, 5));
        System.out.println(new Time(4, 11));

    }

}
