package rules;

import model.Observation;
import model.Violation;

import java.util.Optional;

public class SeatbeltRule implements Rule {

    @Override
    public Optional<Violation> check(Observation observation) {

        if (!observation.isSeatbeltFastened()) {

            return Optional.of(new Violation(
                    "Seatbelt Rule",
                    "Seatbelt not fastened",
                    100
            ));
        }

        return Optional.empty(); // CHANGED: was "return null;"
    }
}