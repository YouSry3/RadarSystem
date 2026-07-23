package radar;

import model.Fine;
import model.Observation;
import model.Violation;
import rules.Rule;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class QuRadar {

    private final List<Rule> rules;
    private final List<Fine> fines;

    public QuRadar() {
        rules = new ArrayList<>();
        fines = new ArrayList<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public Fine processObservation(Observation observation) {

        Fine fine = new Fine(observation.getPlateNumber());

        for (Rule rule : rules) {
            rule.check(observation).ifPresent(fine::addViolation);
        }

        if (!fine.getViolations().isEmpty()) {
            fines.add(fine);
        }

        return fine;
    }

    public Map<String, Integer> getRuleStatistics() {

        Map<String, Integer> statistics = new LinkedHashMap<>();

        for (Fine fine : fines) {
            for (Violation violation : fine.getViolations()) {
                statistics.put(
                        violation.getRuleName(),
                        statistics.getOrDefault(violation.getRuleName(), 0) + 1
                );
            }
        }

        return statistics;
    }

    public List<Fine> getFines() {
        return fines;
    }
}