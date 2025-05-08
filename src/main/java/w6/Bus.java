package w6;

public class Bus extends Vehicle {
    public Bus(String plateNumber) {
        super(plateNumber);
    }
    public Bus(String plateNumber, Time leaveTime) {
        super(plateNumber, leaveTime);
    }
    public Bus(Vehicle vehicle, Time leaveTime) {
        super(vehicle, leaveTime);
    }
    public Bus(Vehicle vehicle){super(vehicle);}

    @Override
    public String getClassName()
    {
        return "w6.Bus";
    }

    @Override
    public int calculateMoney(Time leaveTime) {
        if (arriveTime == null) {
            return 0;
        }
        int totalMinutes = (leaveTime.getHour() - arriveTime.getHour()) * 60 +
                (leaveTime.getMinute() - arriveTime.getMinute());
        int ans1=calculate(totalMinutes+previousMinute),ans2=calculate(previousMinute);
        if(totalMinutes<30) { ans1=ans2=0;}
        else previousMinute+=totalMinutes;
        arriveTime = null;
        isInside = false;
        LeaveTime = new Time(leaveTime);
        return ans1-ans2;
    }
    @Override
    public int calculate(int time)
    {
        int ans=0;
        if (time<30) {
            ans=0;
        } else if (time<60) {
            ans=15;
        } else if (time<120) {
            ans=15+15*(time/60);
        } else {
            ans=15+15*(time/60)<100? 15+15*(time/60):100;
        }
        return ans;
    }

}
