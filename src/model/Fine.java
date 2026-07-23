package model;

import java.util.ArrayList;
import java.util.List;

public class Fine {

    private final String plateNumber;
    private final List<Violation> violations = new ArrayList<>();

    public Fine(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void addViolation(Violation violation) {
        violations.add(violation);
    }

    public int getTotalAmount() {

        int total = 0;

        for (Violation violation : violations) {
            total += violation.getFee();
        }

        return total;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("Traffic for car ")
                .append(plateNumber)
                .append("\n");

        builder.append("Total amount: ")
                .append(getTotalAmount())
                .append(" EGP\n");

        builder.append("Violations:\n");

        for (Violation violation : violations) {
            builder.append("- ")
                    .append(violation.getDescription())
                    .append(" : ")
                    .append(violation.getFee())
                    .append(" EGP\n");
        }

        return builder.toString();
    }
}