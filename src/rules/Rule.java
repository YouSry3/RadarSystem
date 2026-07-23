package rules;

import model.Observation;
import model.Violation;

import java.util.Optional;

public interface Rule {

    Optional<Violation> check(Observation observation);

}