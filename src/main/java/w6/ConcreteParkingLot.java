package w6;

import java.util.ArrayList;
import java.util.List;

public class ConcreteParkingLot implements ParkingLot {
    private List<Vehicle> vehicles;
    private List<Vehicle> vehiclesHistory;
    private Time currentTime;
    private int totalIncome;
    private int cntCar;
    private final int CAR_CAPACITY;
    private int cntBus;
    private final int BUS_CAPACITY;
    public ConcreteParkingLot(int carCapacity, int busCapacity)
    {
        this.CAR_CAPACITY = carCapacity;
        this.BUS_CAPACITY = busCapacity;
        this.vehicles = new ArrayList<>();
        this.vehiclesHistory = new ArrayList<>();

        this.currentTime = new Time(0, 0);
        this.totalIncome = 0;
        this.cntCar = 0;
        this.cntBus = 0;
    }

    //getter
    public Time getTime() {return currentTime;}
    public int getCarCapacity() {return CAR_CAPACITY;}
    public int getBusCapacity() {return BUS_CAPACITY;}
    public List<Vehicle> getVehicles() {return vehicles;}

    public void minutesPassed(int minutes){
        currentTime.addMinutes(minutes);
    }
    public String parkingLotStatus()
    {
//        cntCar=0;cntBus=0;
//        for(w6.Vehicle vehicle: vehicles)
//        {
//            if(vehicle instanceof w6.Car && vehicle.getIsInside())
//            {
//                cntCar++;
//            }
//            else if (vehicle instanceof w6.Bus && vehicle.getIsInside())
//            {
//                cntBus++;
//            }
//        }
        return "car:"+cntCar+"/"+CAR_CAPACITY
                +" bus:"+cntBus+"/"+BUS_CAPACITY;

    }
    public int currentIncome()
    {
        return totalIncome;
    }
    public boolean checkInside(String plateNumber)
    {
        boolean inSide=false;
        for(Vehicle vehicle: vehicles)
        {
            if(vehicle.getPlateNumber().equals(plateNumber))
            {
                inSide|=vehicle.getIsInside();
            }
        }
        return inSide;
    }
    public void driveInto(int type, String... plateNumber)
    {
        int cnt=0;
        if(type==0)
        {
            for(String plate: plateNumber)
            {
                if(cntCar<CAR_CAPACITY)
                {
                    Car c=new Car(plate);
                    int fl=0;
                    for(Vehicle vehicle: vehicles)
                    {
                        if(vehicle.getClass()==c.getClass()&&vehicle.getPlateNumber().equals(plate))
                        {
                            fl=1;
                            if(vehicle.getIsInside())
                            {
                                break;
                            }
                            vehiclesHistory.add(new Car(plate,currentTime));
                            vehicle.setIsInside(true);
                            vehicle.setArriveTime(currentTime);
                            cntCar++;
                            break;
                        }
                    }
                    if(fl==0)
                    {
                        vehiclesHistory.add(new Car(plate,currentTime));
                        c.setArriveTime(currentTime);
                        vehicles.add(c);
                        cntCar++;
                    }
                }
                else
                {
                    break;
                }
                minutesPassed(1);
                cnt++;
            }
        }
        else if(type==1)
        {
            for(String plate: plateNumber)
            {
                if(cntBus<BUS_CAPACITY)
                {
                    Bus c=new Bus(plate);
                    int fl=0;
                    for(Vehicle vehicle: vehicles)
                    {
                        if(vehicle.getClass()==c.getClass()&&vehicle.getPlateNumber().equals(plate))
                        {
                            fl=1;
                            if(vehicle.getIsInside())
                            {
                                break;
                            }
                            vehiclesHistory.add(new Bus(plate,currentTime));
                            vehicle.setIsInside(true);
                            vehicle.setArriveTime(currentTime);
                            cntBus++;
                            break;
                        }
                    }
                    if(fl==0)
                    {
                        c.setArriveTime(currentTime);
                        vehicles.add(c);
                        vehiclesHistory.add(new Bus(plate,currentTime));
                        cntBus++;
                    }
                }
                else
                {
                    break;
                }
                minutesPassed(1);
                cnt++;
            }
        }
        else
        {
            System.out.println("What f**king type are you?");
        }
        if(cnt!=0)
        {
            minutesPassed(-1);
        }
//        minutesPassed(-1*cnt);
    }
    public void driveOut(String plateNumber)
    {
        for(Vehicle vehicle: vehicles)
        {
            if(vehicle.getIsInside()&&vehicle.getPlateNumber().equals(plateNumber))
            {
                for(Vehicle vehicleHistory: vehiclesHistory)
                {
                    if(vehicleHistory.getPlateNumber().equals(plateNumber)&&
                    vehicleHistory.getAArriveTime().toString().compareTo(vehicle.getAArriveTime().toString())==0&&
                    vehicleHistory.getLeaveTime()==null)
                    {
                        vehicleHistory.setLeaveTime(currentTime);
                    }
                }
                totalIncome+=vehicle.calculateMoney(currentTime);
                vehicle.setIsInside(false);
                if(vehicle instanceof Car)
                {
                    cntCar--;
                }
                else if(vehicle instanceof Bus)
                {
                    cntBus--;
                }
                break;
            }

        }
//        minutesPassed(1);
    }
    public void driveOut(String... plateNumber)
    {
        for(String plate: plateNumber)
        {
            driveOut(plate);
        }
//        minutesPassed(-1*plateNumber.length);
    }
    public Vehicle getVehicleByPlateNumber(String plateNumber)
    {
        for(Vehicle vehicle: vehicles)
        {
            if(vehicle.getPlateNumber().equals(plateNumber))
            {
                return vehicle;
            }
        }
        return null;
    }
    public List<Vehicle> getVehiclesByNumber()
    {
        List<Vehicle> a = new ArrayList<>();
        for(Vehicle vehicle: vehicles)
        {
             a.add(vehicle);
        }
        for(int i=0;i<a.size();i++)
        {
            for(int j=i+1;j<a.size();j++)
            {
                if(a.get(i).getPlateNumber().compareTo(a.get(j).getPlateNumber())>0)
                {
                    Vehicle temp=a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
            }
        }
        return a;
    }
    public List<String> getParkingRecordByArriveTime(Time start, Time end)
    {
        List<Vehicle> a = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for(Vehicle vehicle: vehiclesHistory)
        {
            if(vehicle.getAArriveTime().toString().compareTo(start.toString())>=0&&vehicle.getAArriveTime().toString().compareTo(end.toString())<=0)
            {
                if(vehicle.getLeaveTime()==null ||vehicle.getLeaveTime().toString().compareTo(end.toString())>0)
                {
                    if(vehicle instanceof Car) {
                        a.add(new Car(vehicle));
                    }
                    else if(vehicle instanceof Bus) {
                        a.add(new Bus(vehicle));
                    }
                }
                else
                {
                    if(vehicle instanceof Car) {
                        a.add(new Car(vehicle, vehicle.getLeaveTime()));
                    }
                    else if(vehicle instanceof Bus) {
                        a.add(new Bus(vehicle, vehicle.getLeaveTime()));
                    }
                }
            }
        }
        for(int i=0;i<a.size();i++)
            for(int j=i+1;j<a.size();j++)
            {
                if(a.get(i).getAArriveTime().toString().compareTo(a.get(j).getAArriveTime().toString())>0)
                {
                    Vehicle temp=a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
            }

        for(Vehicle vehicle: a)
        {
            ans.add(vehicle.getClassName()+" "+
                    vehicle.getPlateNumber()+" "+
                    vehicle.getAArriveTime().toString()+" "+
                    (vehicle.getLeaveTime()==null? "null":vehicle.getLeaveTime().toString()));
        }
        return ans;
    }


}
