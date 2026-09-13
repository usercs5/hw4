public class CourseDemo {
    public static void main(String[] args) {
        // 1. Create Instructor objects (including Nima Davarpanah and a second instructor)
        Instructor instructor1 = new Instructor("Nima", "Davarpanah", "3-2636");
        Instructor instructor2 = new Instructor("Sarah", "Connor", "4-1205");

        // 2. Create Textbook objects (including Clean Code and a second textbook)
        Textbook textbook1 = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
        Textbook textbook2 = new Textbook("Design Patterns", "Erich Gamma", "Addison-Wesley");

        // 3. Create Course object bundling the instructors and textbooks
        Course course = new Course("Software Engineering", instructor1, instructor2, textbook1, textbook2);

        // 4. Print all course information using the Course print function
        course.print();
    }
}

// Instructor Class
class Instructor {
    private String firstName;
    private String lastName;
    private String officeNumber;

    // Constructor
    public Instructor(String firstName, String lastName, String officeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
    }

    // Getters and Setters (Accessors and Mutators)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
}

// Textbook Class
class Textbook {
    private String title;
    private String author;
    private String publisher;

    // Constructor
    public Textbook(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    // Getters and Setters (Accessors and Mutators)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

// Course Class (Aggregates Instructors and Textbooks)
class Course {
    private String courseName;
    private Instructor instructor1;
    private Instructor instructor2;
    private Textbook textbook1;
    private Textbook textbook2;

    // Constructor
    public Course(String courseName, Instructor instructor1, Instructor instructor2, Textbook textbook1, Textbook textbook2) {
        this.courseName = courseName;
        this.instructor1 = instructor1;
        this.instructor2 = instructor2;
        this.textbook1 = textbook1;
        this.textbook2 = textbook2;
    }

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Instructor getInstructor1() {
        return instructor1;
    }

    public void setInstructor1(Instructor instructor1) {
        this.instructor1 = instructor1;
    }

    public Instructor getInstructor2() {
        return instructor2;
    }

    public void setInstructor2(Instructor instructor2) {
        this.instructor2 = instructor2;
    }

    public Textbook getTextbook1() {
        return textbook1;
    }

    public void setTextbook1(Textbook textbook1) {
        this.textbook1 = textbook1;
    }

    public Textbook getTextbook2() {
        return textbook2;
    }

    public void setTextbook2(Textbook textbook2) {
        this.textbook2 = textbook2;
    }


// Print Function
    public void print() {
        System.out.println("==================================================");
        System.out.println("Course Name: " + courseName);
        System.out.println("------------------------------------------------==");
        System.out.println("Instructors:");
        System.out.println("  * " + instructor1.getFirstName() + " " + instructor1.getLastName() + 
                           " (Office: " + instructor1.getOfficeNumber() + ")");
        System.out.println("  * " + instructor2.getFirstName() + " " + instructor2.getLastName() + 
                           " (Office: " + instructor2.getOfficeNumber() + ")");
        System.out.println("------------------------------------------------==");
        System.out.println("Textbooks:");
        System.out.println("  * \"" + textbook1.getTitle() + "\" by " + textbook1.getAuthor() + 
                           " [Publisher: " + textbook1.getPublisher() + "]");
        System.out.println("  * \"" + textbook2.getTitle() + "\" by " + textbook2.getAuthor() + 
                           " [Publisher: " + textbook2.getPublisher() + "]");
        System.out.println("==================================================");
    }
}