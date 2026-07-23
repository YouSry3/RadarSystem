import enums.CarType;
import model.Fine;
import model.Observation;
import radar.QuRadar;
import rules.PrivateSpeedRule;
import rules.SeatbeltRule;
import rules.TruckSpeedRule;

import java.time.LocalDate;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        QuRadar radar = new QuRadar();
        radar.addRule(new SeatbeltRule());
        radar.addRule(new PrivateSpeedRule());
        radar.addRule(new TruckSpeedRule());

        Observation car1 = new Observation(
                "ABC1234", LocalDate.now(), CarType.PRIVATE, 94, false);
        Observation car2 = new Observation(
                "XYZ5678", LocalDate.now(), CarType.TRUCK, 70, true);
        Observation car3 = new Observation(
                "AAA1111", LocalDate.now(), CarType.PRIVATE, 70, true);
        Observation car4 = new Observation(
                "BBB2222", LocalDate.now(), CarType.PRIVATE, 80, true);


        printIfHasViolations(radar.processObservation(car1));
        printIfHasViolations(radar.processObservation(car2));
        printIfHasViolations(radar.processObservation(car3));
        printIfHasViolations(radar.processObservation(car4));

        printAllFines(radar);
        printRuleStatistics(radar);
    }

    private static void printIfHasViolations(Fine fine) {
        if (!fine.getViolations().isEmpty()) {
            System.out.println(fine);
        }
    }

    private static void printAllFines(QuRadar radar) {
        System.out.println("===== All Fines =====");
        for (Fine fine : radar.getFines()) {
            System.out.println(fine.getPlateNumber() + " -> " + fine.getTotalAmount() + " EGP");
        }
    }

    private static void printRuleStatistics(QuRadar radar) {
        System.out.println("\n===== Rule Statistics =====");
        Map<String, Integer> statistics = radar.getRuleStatistics();
        for (Map.Entry<String, Integer> entry : statistics.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}