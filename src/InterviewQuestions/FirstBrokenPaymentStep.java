import java.util.*;

public class FirstBrokenPaymentStep {
    public String firstBrokenPaymentStep(String[] completed) {
        String[] requiredSteps = {
            "CREATE_ORDER",
            "SCAN_QR",
            "PAYMENT_SENT",
            "PAYMENT_CONFIRMED",
            "INVOICE_CREATED"
        };

        Set<String> completedSet = new HashSet<>(Arrays.asList(completed));

        for (String step : requiredSteps) {
            if (!completedSet.contains(step)) {
                return step;
            }
        }

        return "COMPLETED";
    }
}