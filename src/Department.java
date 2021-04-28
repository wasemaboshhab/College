import java.util.Scanner;

public class Department {

    private String departmentIdNumber;    // list to save the unique number
    private String name;
    private Course[] courses;
    private Lecturer[] lecturers;





                                /*// unique number*/
    public Department(String departmentIdNumber, String name, Course[] courses, Lecturer[] lecturers) {
        this.name = name;
        this.courses = courses;
        this.lecturers = lecturers;
        this.departmentIdNumber = departmentIdNumber;
        }



    public Course[] getCourses() {
        return courses;
    }
    public Lecturer[] getLecturers() {
        return lecturers;
    }
    public String getDepartmentIdNumber() {
        return departmentIdNumber;
    }
    public void setDepartmentIdNumber(String departmentIdNumber) {
        this.departmentIdNumber = departmentIdNumber;      /*//A unique number*/
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCourses(Course[] courses) {
        this.courses = courses;
    }
    public void setLecturers(Lecturer[] lecturers) {
        this.lecturers = lecturers;
    }



    public void printListOfCourses() { // change to void !
            System.out.println("            {Courses of the department}:");
            System.out.println();
            int counter = 1;
            for (int i = 0; i <courses.length ; i++) {
                Course currentCourse = courses[i];
                if (currentCourse != null) {
                    System.out.println( counter+ ": "+ courses[i].getName());
                    counter++;
                    System.out.println();
                }
            }


    }
    public void printListOfLecturers() {
        int counter = 1;
        System.out.println("            {Lecturers teachers in the department}:");
        System.out.println();
        for (int i = 0; i < lecturers.length; i++) {
            Lecturer currentLecturer = lecturers[i];
            if (currentLecturer != null) {
                System.out.print(counter +": ");
                this.lecturers[i].print();
                System.out.println("-----------------");
                System.out.println();
                counter++;
            }
        }
    }

    public void addCourse() {
        Scanner scanner = new Scanner(System.in);
        Course[] newListOfCourses = new Course[this.courses.length + 1];
        for (int i = 0; i < this.courses.length; i++) {
            newListOfCourses[i] = this.courses[i];
        }
        System.out.println("Course Name: ");
        for (int i = 0; i < newListOfCourses.length; i++) {
            if (newListOfCourses[i] == null) {
                newListOfCourses[i] =new Course(scanner.nextLine()) ;
                this.courses = newListOfCourses;
                break;
            }
        }





    }
    public void addLecture() {
        Scanner scanner = new Scanner(System.in);
        Lecturer[] newListOfLecturers = new Lecturer[lecturers.length + 1];
        for (int i = 0; i < this.lecturers.length; i++) {
            newListOfLecturers[i] = lecturers[i];
        }
        System.out.println();
        System.out.println("Enter Lecturer's Name: ");
        System.out.println("First Name:");
        String firstName = scanner.next();
        System.out.println("Last Name: ");
        String lastName = scanner.next();
        Lecturer newLecture = new Lecturer(firstName, lastName);
        for (int i = 0; i < newListOfLecturers.length; i++) {
            if (newListOfLecturers[i] == null) {
                newListOfLecturers[i] = newLecture;
                setLecturers(newListOfLecturers);
                break;
            }
        }
    }
    public void print() {
        System.out.println();
        System.out.println("                                                {Department details}");
        System.out.println();
        System.out.println("Department Name: "+this.name);
        System.out.println("Department ID number: " +this.departmentIdNumber);
        System.out.println();
        if (this.lecturers[0] == null) {
            System.out.println("Lecturers have not yet been added to this department");
        } else {
            System.out.println();
            printListOfLecturers();

        }
        if (this.courses[0] == null) {
            System.out.println("Courses have not yet been added to this class");
        } else {
            System.out.println("            Courses belong to the department:");
            for (int i = 0; i < courses.length; i++) {
                if (courses[i] != null) {
                    System.out.println();
                    courses[i].print();
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                    System.out.println();
                }
        }
        }


    }
}



