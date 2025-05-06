package w6;

public abstract class Vehicle {
    protected String plateNumber;
    protected boolean isInside;
    protected Time arriveTime;
    protected int previousMinute=0;
    protected Time ArriveTime;
    protected Time LeaveTime;

    public Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
        this.isInside = false;
        this.arriveTime = null;
        this.ArriveTime = null;
        this.LeaveTime = null;
    }
    public Vehicle(String plateNumber, Time arriveTime) {
        this.plateNumber = plateNumber;
        this.ArriveTime = new Time(arriveTime);
        this.LeaveTime = null;
    }
    public Vehicle(Vehicle vehicle,Time leaveTime){
        this.plateNumber = vehicle.getPlateNumber();
        this.ArriveTime = new Time(vehicle.getAArriveTime());
        this.LeaveTime = new Time(leaveTime);
    }
    @Override
    public String toString()
    {
        return getClass().getName()+" "+plateNumber+" "+isInside;
    }
    public abstract int calculateMoney(Time leaveTime);
    public abstract int calculate(int time);

    //getter
    public String getPlateNumber() {return plateNumber;}
    public boolean getIsInside() {return isInside;}
    public Time getArriveTime() {return arriveTime;}
    public Time getAArriveTime() {return ArriveTime;}
    public Time getLeaveTime() {return LeaveTime;}
    //setter
    public void setPlateNumber(String plateNumber) {this.plateNumber = plateNumber;}
    public void setIsInside(boolean isInside) {this.isInside = isInside;}
    public void setArriveTime(Time arriveTime) {
        this.arriveTime = new Time(arriveTime);this.isInside=true;
        this.ArriveTime = new Time(arriveTime);
    }
    public void setLeaveTime(Time leaveTime) {
        this.LeaveTime = new Time(leaveTime);
    }


}
