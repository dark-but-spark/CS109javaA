package w6;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Class<?> clzVehicle = Vehicle.class;
        String[] expectFieldsVehicle = {
                "protected java.lang.String w6.Vehicle.plateNumber",
                "protected boolean w6.Vehicle.isInside",
                "protected w6.Time w6.Vehicle.arriveTime"
        };
        ArrayList<String> fieldsVehicle = new ArrayList<>();
        for(Field field: clzVehicle.getDeclaredFields()) {
            fieldsVehicle.add(field.toString());
            System.out.println(field.toString());
        }
    }
}
