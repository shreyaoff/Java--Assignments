// Question 13: Online Course Portal
// Class Course with fields title, duration, instructor and method getCourseInfo().
// Subclasses:
//   LiveCourse: add scheduleTime.
//   RecordedCourse: add videoCount.
// Use encapsulation and method overriding.

class Course {
    private String title;
    private int duration;
    private String instructor;

    public Course(String title, int duration, String instructor) {
        this.title = title;
        this.duration = duration;
        this.instructor = instructor;
    }

    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public String getInstructor() { return instructor; }

    public void getCourseInfo() {
        System.out.println("Course: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Duration: " + duration + " hours");
    }
}

class LiveCourse extends Course {
    private String scheduleTime;

    public LiveCourse(String title, int duration, String instructor, String scheduleTime) {
        super(title, duration, instructor);
        this.scheduleTime = scheduleTime;
    }

    public String getScheduleTime() { return scheduleTime; }

    @Override
    public void getCourseInfo() {
        System.out.println("[LIVE COURSE]");
        super.getCourseInfo();
        System.out.println("Schedule: " + scheduleTime);
    }
}

class RecordedCourse extends Course {
    private int videoCount;

    public RecordedCourse(String title, int duration, String instructor, int videoCount) {
        super(title, duration, instructor);
        this.videoCount = videoCount;
    }

    public int getVideoCount() { return videoCount; }

    @Override
    public void getCourseInfo() {
        System.out.println("[RECORDED COURSE]");
        super.getCourseInfo();
        System.out.println("Total Videos: " + videoCount);
    }
}

public class CoursePortal {
    public static void main(String[] args) {
        LiveCourse liveCourse = new LiveCourse("Java Programming", 40, "Dr. Patel", "Mon/Wed 6:00 PM - 8:00 PM");
        RecordedCourse recordedCourse = new RecordedCourse("Web Development Bootcamp", 60, "Sarah Johnson", 120);

        System.out.println("===== Course Portal =====");
        System.out.println("-------------------------");
        liveCourse.getCourseInfo();

        System.out.println("-------------------------");
        recordedCourse.getCourseInfo();
    }
}
