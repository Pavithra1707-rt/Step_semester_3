package Week_8.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

class StreamingPlan {
    LocalDate startDate;

    StreamingPlan(LocalDate startDate) {
        this.startDate = startDate;
    }

    LocalDate getRenewalDate() {
        return startDate;
    }
}

class BasicPlan extends StreamingPlan {

    BasicPlan(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends StreamingPlan {

    StandardPlan(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends StreamingPlan {

    PremiumPlan(LocalDate startDate) {
        super(startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            StreamingPlan plan;

            if (type.equals("BASIC")) {
                plan = new BasicPlan(startDate);
            }
            else if (type.equals("STANDARD")) {
                plan = new StandardPlan(startDate);
            }
            else {
                plan = new PremiumPlan(startDate);
            }

            System.out.println(plan.getRenewalDate());
        }

        sc.close();
    }
}