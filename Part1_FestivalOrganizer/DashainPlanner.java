import java.util.*;

class DashainFestivalPlanner {

    static void executeFestivalPlan(List<FestivalActivity> activities) {

        for (FestivalActivity activity : activities) {

            activity.displayOverview();

            try {
                activity.planActivity();

            } catch (InvalidGuestCountException e) {
                System.out.println("Planning Warning (Guests): " + e.getMessage());

            } catch (BudgetExceededException e) {
                System.out.println("Planning Warning (Budget): " + e.getMessage());

            } catch (NoRouteException e) {
                System.out.println("Planning Warning (Routes): " + e.getMessage());

            } catch (FestivalPlanningException e) {
                System.out.println("General Planning Error: " + e.getMessage());

            } finally {
                System.out.println("Activity planning attempt for " + activity.activityName + " completed.");
            }

            System.out.println("============================================");
        }
    }

    public static void main(String[] args) {

        List<FestivalActivity> activities = new ArrayList<>();

        activities.add(new TikaCeremony(25000, 12, "Grandfather Hari"));
        activities.add(new TikaCeremony(10000, 3, "Grandmother Maya"));
        activities.add(new TikaCeremony(70000, 20, "Uncle Bijay"));

        List<String> goodRoutes = new ArrayList<>();
        goodRoutes.add("Baneshwor Route");
        goodRoutes.add("New Road Route");
        activities.add(new DeusiBhailo(9000, goodRoutes, 6));

        activities.add(new DeusiBhailo(4000, new ArrayList<>(), 5));

        List<String> oneRoute = new ArrayList<>();
        oneRoute.add("Thamel Route");
        activities.add(new DeusiBhailo(5000, oneRoute, 2));

        System.out.println("***** Starting Dashain Festival Planning *****\n");
        DashainFestivalPlanner.executeFestivalPlan(activities);
        System.out.println("***** Dashain Festival Planning Finished *****");
    }
}
