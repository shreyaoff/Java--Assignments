class CourseEnrollmentManager {

    static void enrollStudent(String studentId, String courseId, EligibilityRule rule) {

        System.out.println("Attempting to enroll " + studentId + " in " + courseId + "...");

        try {
            boolean eligible = rule.isEligible(studentId, courseId);

            if (eligible) {
                System.out.println("Enrollment successful for " + studentId + " in " + courseId + "! Happy learning!");
            } else {
                System.out.println("Enrollment failed for " + studentId + ": Not eligible for this course.");
            }

        } catch (EnrollmentDeniedException e) {
            System.out.println("Enrollment failed for " + studentId + ": " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Lambda implementing EligibilityRule
        EligibilityRule rule = (studentId, courseId) -> {

            if (studentId.equals("SKILL999")) {
                throw new EnrollmentDeniedException(
                    "Student account suspended due to outstanding fees, Roshan!");
            }

            if (courseId.equals("JAVA101") && !studentId.startsWith("SKILL")) {
                throw new EnrollmentDeniedException(
                    "Invalid student ID format. Please use 'SKILL' prefix, Anisha!");
            }

            if (studentId.startsWith("SKILL") && courseId.equals("JAVA101")) {
                return true;
            }

            return false;
        };

        System.out.println("***** Skill Nepal Enrollment System *****\n");

        CourseEnrollmentManager.enrollStudent("SKILL123", "JAVA101", rule);
        System.out.println("------------------------------------------");

        CourseEnrollmentManager.enrollStudent("SKILL999", "JAVA101", rule);
        System.out.println("------------------------------------------");

        CourseEnrollmentManager.enrollStudent("STUDENT001", "JAVA101", rule);
        System.out.println("------------------------------------------");

        CourseEnrollmentManager.enrollStudent("SKILL456", "PYTHON202", rule);
        System.out.println("------------------------------------------");
    }
}
