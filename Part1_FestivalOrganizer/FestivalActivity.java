import java.util.*;

class FestivalPlanningException extends Exception {
    public FestivalPlanningException(String message) {
        super(message);
    }
}

// Abstract class - blueprint for all festival activities
abstract class FestivalActivity {

    String activityName;
    double estimatedCost;

    public FestivalActivity(String activityName, double estimatedCost) {
        this.activityName = activityName;
        this.estimatedCost = estimatedCost;
    }

    abstract void planActivity() throws FestivalPlanningException;

    void displayOverview() {
        System.out.println("Activity: " + activityName + " | Estimated Cost: Rs. " + estimatedCost);
    }
}
