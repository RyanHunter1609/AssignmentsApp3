
import java.time.LocalDateTime;
import java.util.Random;

public class Assignment {
    Random rand = new Random();
    private Main.Category category;
    private Main.Course course;
    private Main.Day day;
    private LocalDateTime localDateTime;
    private int priority;

    public Assignment() {
        //a default constructor that creates an object called assign1
        category = Main.Category.HOMEWORK;
        course = Main.Course.SPANISH;
        day = Main.Day.SUNDAY;
        localDateTime = LocalDateTime.now();
        priority = rand.nextInt(4);
    }

    public Assignment(Main.Category category, Main.Course course, Main.Day day, LocalDateTime localDateTime, int priority) {
        this.category = category;
        this.course = course;
        this.day = day;
        this.localDateTime = localDateTime;
        this.priority = priority;
    }

    public Assignment(LocalDateTime localDateTime, int priority) {
        this.localDateTime = localDateTime;
        this.priority = priority;
    }

    public Main.Category getCategory() {
        return category;
    }

    public void setCategory(Main.Category category) {
        this.category = category;
    }

    public Main.Course getCourse() {
        return course;
    }

    public void setCourse(Main.Course course) {
        this.course = course;
    }

    public Main.Day getDay() {
        return day;
    }

    public void setDay(Main.Day day) {
        this.day = day;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return category + "\t" + course + "\t" + day + "\t" + localDateTime + "\t" + priority + "\n";
    }


    public int compareTo(Assignment assign2) {
        return 0;
    }
}
