import javafx.scene.layout.Priority;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Assignment {
    Random random = new Random();
    private Category category;
    private Course course;
    private Day day;
    private LocalDateTime localDateTime;
    private Priority priority;

    public Assignment(Category category, Course course, Day day, LocalDateTime localDateTime, Priority priority) {
        this.category = category;
        this.course = course;
        this.localDateTime = localDateTime;
        this.priority = priority;
        this.day = day;
    }

    private static ArrayList<Category> categoryEnumerated() {
        ArrayList<Category> categories = new ArrayList<>();
        Collections.addAll(categories, Category.values());
        return categories;
    }

    public enum Category {
        HOMEWORK, QUIZ, TEST, PRESENTATION, FINAL_EXAM
    }

    public enum Course {
        SPANISH, ENGLISH, MATH, ART, COMPUTER_SCIENCE
    }

    private static ArrayList<Course> courseEnumerated() {
        ArrayList<Course> courses = new ArrayList<>();
        Collections.addAll(courses, Course.values());
        return courses;
    }

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    private static ArrayList<Day> dayOfWeekEnumerated() {
        ArrayList<Day> daysOfWeek = new ArrayList<>();
        Collections.addAll(daysOfWeek, Day.values());
        return daysOfWeek;
    }


    public static Assignment generateAssignment() {
        LocalDateTime localDateTimeArrayList = LocalDateTime.now();
        ArrayList<Day> dayArrayList = dayOfWeekEnumerated();
        ArrayList<Category> categoryArrayList = categoryEnumerated();
        ArrayList<Course> courseArrayList = courseEnumerated();
        localDateTimeArrayList;
        return null;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return category + "\n" + course + "\n" + day + "\n" + localDateTime + "\n" + priority;
    }
}
