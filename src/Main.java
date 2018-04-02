import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    // Override an Assignment.equals() method.
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("\n\nHello, AssignmentsApp!\n");

        //Output the current date-time.
        LocalDateTime today = LocalDateTime.now();
        System.out.println("\nThe current date-time is " + today);

        //Output tomorrow's date using a formatter.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        String formatDateTime = today.format(formatter);
        System.out.println("Tomorrow's formatted date is " + formatDateTime);

        //Add 5 weeks to today's LocalDateTime.
        LocalDateTime fiveWeeksLater = today.plusWeeks(5);
        System.out.println("The five weeks, the date will be " + fiveWeeksLater);

        //Initialize a LocalDateTime object to your birthdate and the time 12:35 PM.
        LocalDateTime birthDate = LocalDateTime.of(1999, 2, 7, 12, 35);
        System.out.println("Your birthdate is " + birthDate);

        //Output the day of the week (Sunday-Saturday) that you were born.
        System.out.println("The day of the week of your birthdate was " + birthDate.getDayOfWeek());

        //Output the number of days you've been alive.
        System.out.println("The number of days you have been alive is " + ChronoUnit.DAYS.between(birthDate, today) + " days.");

        //Output the number of days between two dates.
        LocalDateTime obamaInauguration = LocalDateTime.of(2009, 2, 20, 12, 0);
        System.out.println("The number of days between your birthdate and Obama's inauguration is " + ChronoUnit.DAYS.between(birthDate, obamaInauguration) + " days.");

        //Given two dates, output the earlier.
        System.out.println("The earlier date is " + FindEarlierDate(today, obamaInauguration));

        //Create a file with 100 random "month/day/year  hour:minutes" (in that format) on each line.
        ArrayList<LocalDateTime> hundredRandomDates = randomDateArray(100);
        hundredRandomDates.forEach(d -> System.out.println("Date is " + d));

        //Output the number of stored dates in the year [Y].
        System.out.print("\nWhat is the year you want to find the dates of? ");
        ArrayList<LocalDateTime> datesOfUserYear = searchByYear(hundredRandomDates, sc.nextInt());
        System.out.println("The number of dates with that year is " + datesOfUserYear.size());

        //Count the number of stored dates in the current year.
        ArrayList<LocalDateTime> datesOfCurrentYear = searchByYear(hundredRandomDates, today.getYear());
        System.out.println("\nThe number of dates in the current year is " + datesOfCurrentYear.size());

        //Count the number of duplicates.
        ArrayList<LocalDateTime> duplicatedDates = seekDuplicates(hundredRandomDates);
        System.out.println("\nThere are " + duplicatedDates.size() + " duplicated dates.");

        // Sort the dates in chronological order.
        Collections.sort(hundredRandomDates);
        System.out.println("\nThe sorted dates are as followed: ");
        hundredRandomDates.forEach(d -> System.out.println(d));

        //Count the number of duplicates in a sorted list without using a Java Set.
        System.out.println("\nWithout using a Set, the number of duplicated dates are " + countDuplicates(hundredRandomDates));

        //Count the number of evening (after 6pm) dates.
        ArrayList<LocalDateTime> eveningDates = searchDatesInTimeframe(hundredRandomDates, 18, 24);
        System.out.println("\nThe number of evening dates are " + eveningDates.size());

        //Count the number of dates in each of the individual 12 months without using a Java Map.
        System.out.print("\nWhat is the number of the month you are searching the dates for? ");
        int month = sc.nextInt();
        if (month > 12 || month < 1) System.out.println("That month value is not valid.");
        else {
            ArrayList<LocalDateTime> datesOfMonth = searchByMonth(hundredRandomDates, month);
            System.out.println("The number of dates in month " + month + " is " + datesOfMonth.size());
        }

        //Count the number of dates in each of the individual 12 months using a Java Map.
        if (month >= 1 && month <= 12) {
            System.out.println("Using a Java Map, the number of dates in month " + month + " is " + mapByMonthSearch(hundredRandomDates, month));
        }

        //Determine the index of the latest LocalDateTime.
        System.out.println("\nThe index of the latest LocalDateTime is " + indexLatestDate(hundredRandomDates));

        //Determine the indexes of the elements that have the earliest starting time, regardless of date.
        System.out.println("\nThe index of the date with the earliest starting time is " + indexEarliestTime(hundredRandomDates));

        //Output a date in the format "January 1st, 2018".
        System.out.print("\nWhat is the index of the date you want to be outputted in the format \"January 1st, 2018\"? ");
        System.out.println("The formatted date is " + formattedDate(hundredRandomDates.get(sc.nextInt())));
        //I had completely forgotten to submit the previous story, so if it looks like I completed this story incredibly quickly, it's because I temporarily removed this code so I could post the for the previous story.

        // Define and use a DayOfWeek enumerated type.
        dayOfWeekEnumerated();
        // Define and use a Course enumerated type.
        courseEnumerated();
        // Define and use a Category enumerated type.
        categoryEnumerated();

        // In the driver, generate 2 random assignments named assignment1 and assignment2.
        Assignment assignment1 = new Assignment();  // the instance variables are set by the programmer in the default constructor
        System.out.println("Assignment 1: " + assignment1);
        Assignment assignment2 = new Assignment(Category.HOMEWORK, Course.SPANISH, Day.SUNDAY, LocalDateTime.now(), 1); // the instance variables are set in the driver by the user.
        System.out.println("Assignment 2: " + assignment2);

        // Copy assignment1 to assign3.
        Assignment assignment3 = copyAssign1ToAssign3(assignment1);
        System.out.println("Assignment 3: " + assignment3);

        // Override .compareTo() method
        String assignCompared = assignmentComparison(assignment1, assignment2);
        System.out.println("Assignment One: " + assignment1 + " Compared To Two: " + assignment2 +
                "\n Assignments Compared: " + assignCompared);

        // Which of assignment1, assignment2, or assign3 is the earliest?
        System.out.print(whichAssignmentIsEarliest(assignment1, assignment2, assignment3));


        System.out.println("Enter Amount of Assignment(s) to Generate: ");
        int userInputNum = sc.nextInt();
        // Write  [X] randomly generated assignments to the file 'input.dat'.
        writeRandomAssignments(userInputNum);

    }

    private static void writeRandomAssignments(int userInput) throws IOException {

        //creates a PrintWriter instance which is connected to a FileWriter.
        PrintWriter printWriter = new PrintWriter("input.dat");
        for (int i = 0; i < userInput; i++) {
            //5 = bounds
            int randomNum = rand.nextInt(5);
            //generate random assignment
            Assignment assignment = new Assignment(LocalDateTime.now(), randomNum);
            //writes a nullable object to the PrintWriter
            printWriter.print(assignment);
        }

        /**
         * PrintWriter is closed
         * When you are finished writing characters to the Java PrintWriter you should remember to close it.
         * Closing a PrintWriter will also close the Writer instance to which the PrintWriter is writing.
         **/
        printWriter.close();
    }

    private static String whichAssignmentIsEarliest(Assignment assign1, Assignment assign2, Assignment assign3) {
        String earliest;
        if (assign1.getDay().isBefore(assign2.getDay()) && assign1.getDay().isBefore(assign3.getDay())) {
            earliest = "Assignment 1 is Earliest: " + assign1;
        } else if (assign2.getDay().isBefore(assign1.getDay()) && assign2.getDay().isBefore(assign3.getDay())) {
            earliest = "Assignment 2 is Earliest: " + assign2;

        } else {
            earliest = "Assignment 3 is Earliest: " + assign2;
        }
        return earliest;
    }

    // Override an Assignment.compareTo() method then use it to output BEFORE, EQUALS, or AFTER based on the LocalDateTime.
    public static String assignmentComparison(Assignment assign1, Assignment assign2) {
        int value = assign1.compareTo(assign2);
        if (value < 0) {
            return "BEFORE";
        } else if (value > 0) {
            return "AFTER";
        } else {
            return "EQUALS";
        }
    }

    public static Assignment copyAssign1ToAssign3(Assignment assign1) {
        //creates a new local Assignment object and assigns each individual instance variable to that local variable.
        Assignment assign3 = new Assignment();
        //copy assign1 >>>> .equals()
        assign3.equals(assign1);
        return assign3;
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
        THURSDAY, FRIDAY, SATURDAY;

        private boolean before;

        public boolean isBefore() {
            return before;
        }

        public boolean isBefore(Day day) {
            return false;
        }
    }

    private static ArrayList<Day> dayOfWeekEnumerated() {
        ArrayList<Day> daysOfWeek = new ArrayList<>();
        Collections.addAll(daysOfWeek, Day.values());
        return daysOfWeek;
    }

    private static String formattedDate(LocalDateTime date) {
        String newDate = "";
        newDate += date.format(DateTimeFormatter.ofPattern("MMMM "));
        newDate += intToOrdinal(date.getDayOfMonth());
        newDate += date.format(DateTimeFormatter.ofPattern(", yyyy"));
        return newDate;
    }

    private static String intToOrdinal(int num) {
        String[] suffixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        //I probably should have made this into a switch/case.
        if (num % 100 == 11 || num % 100 == 12 || num % 100 == 13) {
            return num + "th";
        } else {
            return num + suffixes[num % 10];
        }
    }

    private static Integer indexEarliestTime(ArrayList<LocalDateTime> dateList) {
        LocalDateTime earliestDateTime = dateList.get(0);
        for (LocalDateTime date : dateList) {
            if (earliestDateTime.toLocalTime().isAfter(date.toLocalTime())) earliestDateTime = date;
        }
        return dateList.indexOf(earliestDateTime);
    }

    private static Integer indexLatestDate(ArrayList<LocalDateTime> dateList) {
        return dateList.indexOf(Collections.max(dateList));
    }

    private static Integer mapByMonthSearch(ArrayList<LocalDateTime> dateList, int month) {
        return mapByMonth(dateList).get(month);
    }

    private static Map<Integer, Integer> mapByMonth(ArrayList<LocalDateTime> dateList) {
        Map<Integer, Integer> returnMap = new HashMap<>();
        for (LocalDateTime date : dateList) {
            Integer count = returnMap.get(date.getMonthValue());
            returnMap.put(date.getMonthValue(), (count == null) ? 1 : count + 1);
        }
        return returnMap;
    }

    private static ArrayList<LocalDateTime> searchByMonth(ArrayList<LocalDateTime> dateList, int month) {
        return (ArrayList) dateList.stream()
                .filter(date -> date.getMonthValue() == month)
                .collect(Collectors.toList());
    }

    private static ArrayList searchDatesInTimeframe(ArrayList<LocalDateTime> dateList, int startHour, int endHour) {
        return (ArrayList) dateList.stream()
                .filter(date -> date.getHour() >= startHour && date.getHour() < endHour)
                .collect(Collectors.toList());
    }

    private static int countDuplicates(ArrayList<LocalDateTime> hundredRandomDates) {
        int count = 0;
        for (LocalDateTime date : hundredRandomDates) {
            if (Collections.frequency(hundredRandomDates, date) >= 2) count++;
        }
        return count;
    }

    private static ArrayList<LocalDateTime> seekDuplicates(ArrayList<LocalDateTime> userList) {
        ArrayList<LocalDateTime> returnArray = new ArrayList<>();
        Set<LocalDateTime> dateSet = new HashSet<>();
        for (LocalDateTime date : userList) {
            if (dateSet.contains(date)) returnArray.add(date);
            dateSet.add(date);
        }
        return returnArray;
    }

    private static ArrayList<LocalDateTime> searchByYear(ArrayList<LocalDateTime> listOfLocalDateTimes, int year) {
        return (ArrayList) listOfLocalDateTimes.stream()
                .filter(date -> date.getYear() == year)
                .collect(Collectors.toList());
    }

    private static ArrayList<LocalDateTime> randomDateArray(int NumElements) {
        ArrayList<LocalDateTime> returnArray = new ArrayList<>();
        for (int i = 0; i < NumElements; i++) {
            returnArray.add(randomDateGenerator());
        }
        return returnArray;
    }

    private static LocalDateTime randomDateGenerator() {
        long startOfTime = ChronoUnit.MINUTES.between(LocalDateTime.of(0, 1, 1, 0, 0), LocalDateTime.now());
        long minutes = rand.nextInt((int) startOfTime);
        return LocalDateTime.now().minusMinutes(minutes);
    }

    private static LocalDateTime FindEarlierDate(LocalDateTime date1, LocalDateTime date2) {
        LocalDateTime earlyDate = date1;
        if (date2.isBefore(date1)) {
            earlyDate = date2;
        }
        return earlyDate;
    }
}
