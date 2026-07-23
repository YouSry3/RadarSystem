package rules;

import enums.CarType;

public class PrivateSpeedRule extends SpeedRule {
    public PrivateSpeedRule() {
        super(CarType.PRIVATE, 80, 300, "Private Speed Rule");
    }
}