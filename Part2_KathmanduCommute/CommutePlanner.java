class CommutePlanner {

    static void planMyCommute(String origin, String destination, RouteValidator validator, NavigationService navigator) {

        System.out.println("Planning your commute from " + origin + " to " + destination + "...");

        try {
            navigator.navigate(origin, destination, validator);

        } catch (NavigationFailedException e) {

            Throwable cause = e.getCause();

            if (cause instanceof InvalidRouteException) {
                System.out.println("Cannot plan: Invalid route details - " + cause.getMessage());

            } else if (cause == null) {
                System.out.println("Cannot plan: GPS issue - " + e.getMessage());

            } else {
                System.out.println("Cannot plan: " + e.getMessage());
            }

        } finally {
            System.out.println("Commute planning for " + origin + " to " + destination + " completed.");
        }
    }

    public static void main(String[] args) {

        RouteValidator validator = new KathmanduTrafficValidator();
        NavigationService navigator = new GPSNavigationModule();

        System.out.println("***** Kathmandu Commute Planner *****\n");

        CommutePlanner.planMyCommute("Baneshwor", "Baneshwor", validator, navigator);
        System.out.println("============================================");

        CommutePlanner.planMyCommute("Thamel", "Patan", validator, navigator);
        System.out.println("============================================");

        CommutePlanner.planMyCommute("Kalanki", "Balaju", validator, navigator);
        System.out.println("============================================");
    }
}
