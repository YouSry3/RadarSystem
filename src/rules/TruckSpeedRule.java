package rules;

import enums.CarType;

public class TruckSpeedRule extends SpeedRule {
    public TruckSpeedRule() {
        super(CarType.TRUCK, 60, 300, "Truck Speed Rule");
    }
}