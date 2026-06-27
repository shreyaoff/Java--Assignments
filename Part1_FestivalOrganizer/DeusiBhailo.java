import java.util.*;

class NoRouteException extends FestivalPlanningException {
    public NoRouteException(String message) {
        super(message);
    }
}

class DeusiBhailo extends FestivalActivity {

    List<String> plannedRoutes;
    int numberOfPerformers;

    public DeusiBhailo(double estimatedCost, List<String> plannedRoutes, int numberOfPerformers) {
        super("Deusi Bhailo Program", estimatedCost);
        this.plannedRoutes = plannedRoutes;
        this.numberOfPerformers = numberOfPerformers;
    }

    @Override
    void planActivity() throws FestivalPlanningException, NoRouteException {

        if (plannedRoutes.isEmpty()) {
            throw new NoRouteException(
                "No routes planned for Deusi Bhailo! Are we just singing in the living room?");
        }

        if (numberOfPerformers < 3) {
            throw new FestivalPlanningException(
                "Need at least 3 performers for a proper Deusi Bhailo!");
        }

        System.out.println("Deusi Bhailo program with " + numberOfPerformers +
                " performers planned for " + plannedRoutes.size() + " routes!");
    }

    public static void main(String[] args) {

        List<String> routes1 = new ArrayList<>();
        routes1.add("Baneshwor Route");
        routes1.add("Koteshwor Route");
        DeusiBhailo valid = new DeusiBhailo(8000, routes1, 5);

        DeusiBhailo noRoutes = new DeusiBhailo(5000, new ArrayList<>(), 4);

        List<String> routes2 = new ArrayList<>();
        routes2.add("Patan Route");
        DeusiBhailo notEnoughPerformers = new DeusiBhailo(6000, routes2, 2);

        List<DeusiBhailo> testPrograms = new ArrayList<>();
        testPrograms.add(valid);
        testPrograms.add(noRoutes);
        testPrograms.add(notEnoughPerformers);

        for (DeusiBhailo program : testPrograms) {
            program.displayOverview();

            try {
                program.planActivity();
            } catch (NoRouteException e) {
                System.out.println("Route Problem: " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("General Planning Problem: " + e.getMessage());
            }

            System.out.println("------------------------------------------");
        }
    }
}
