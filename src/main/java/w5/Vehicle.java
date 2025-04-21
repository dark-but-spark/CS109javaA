package w5;

public abstract class Vehicle {
    protected String plateNumber;
    protected boolean isInside;
    protected Time arriveTime;
    protected int previousMinute=0;

    public Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
        this.isInside = false;
        this.arriveTime = null;
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

    //setter
    public void setPlateNumber(String plateNumber) {this.plateNumber = plateNumber;}
    public void setIsInside(boolean isInside) {this.isInside = isInside;}
    public void setArriveTime(Time arriveTime) {this.arriveTime = arriveTime;this.isInside=true;}
}
