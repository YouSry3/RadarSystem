package rules;

import enums.CarType;
import model.Observation;
import model.Violation;

import java.util.Optional;

public abstract class SpeedRule implements Rule {

    private final CarType carType;
    private final int maxSpeed;
    private final int fee;
    private final String ruleName;

    protected SpeedRule(CarType carType, int maxSpeed, int fee, String ruleName) {
        this.carType = carType;
        this.maxSpeed = maxSpeed;
        this.fee = fee;
        this.ruleName = ruleName;
    }

    @Override
    public Optional<Violation> check(Observation observation) {

        if (observation.getCarType() == carType && observation.getSpeed() > maxSpeed) {

            return Optional.of(new Violation(
                    ruleName,
                    "speed of " + observation.getSpeed() + " exceeded max allowed " + maxSpeed,
                    fee
            ));
        }

        return Optional.empty();
    }
}