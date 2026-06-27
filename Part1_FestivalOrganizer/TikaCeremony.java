import java.util.*;

class InvalidGuestCountException extends FestivalPlanningException {
    public InvalidGuestCountException(String message) {
        super(message);
    }
}

class BudgetExceededException extends FestivalPlanningException {
    public BudgetExceededException(String message) {
        super(message);
    }
}

class TikaCeremony extends FestivalActivity {

    int expectedGuests;
    String mainFamilyElder;

    public TikaCeremony(double estimatedCost, int expectedGuests, String mainFamilyElder) {
        super("Tika Ceremony", estimatedCost);
        this.expectedGuests = expectedGuests;
        this.mainFamilyElder = mainFamilyElder;
    }

    @Override
    void planActivity() throws FestivalPlanningException, InvalidGuestCountException, BudgetExceededException {

        if (expectedGuests < 5) {
            throw new InvalidGuestCountException(
                "Not enough guests for a lively Tika! Is everyone on vacation?");
        }

        if (estimatedCost > 50000) {
            throw new BudgetExceededException(
                "Tika budget too high! Is this for the whole village?");
        }

        System.out.println("Tika ceremony with " + mainFamilyElder +
                " planned successfully for " + expectedGuests + " guests!");
    }

    public static void main(String[] args) {

        List<TikaCeremony> testCeremonies = new ArrayList<>();
        testCeremonies.add(new TikaCeremony(20000, 15, "Grandfather Hari"));
        testCeremonies.add(new TikaCeremony(15000, 2, "Grandmother Sita"));
        testCeremonies.add(new TikaCeremony(60000, 10, "Uncle Bijay"));

        for (TikaCeremony ceremony : testCeremonies) {
            ceremony.displayOverview();

            try {
                ceremony.planActivity();
            } catch (InvalidGuestCountException e) {
                System.out.println("Guest Count Problem: " + e.getMessage());
            } catch (BudgetExceededException e) {
                System.out.println("Budget Problem: " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("General Planning Problem: " + e.getMessage());
            }

            System.out.println("------------------------------------------");
        }
    }
}
