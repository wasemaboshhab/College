import java.util.Scanner;

public class Department {
    private String name;
    private int departmentIdNumber;
    private DepartmentHead departmentHead;
    private Course[] courses;
    private Lecturer[] lecturers;

    public Department(int departmentIdNumber, String name, Course[] courses, Lecturer[] lecturers, DepartmentHead departmentHead) {
        this.departmentHead = departmentHead;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLecturers(Lecturer[] lecturers) {
        this.lecturers = lecturers;
    }
    public DepartmentHead getDepartmentHead() {
        return departmentHead;
    }
    public void setDepartmentHead(DepartmentHead departmentHead) {
        this.departmentHead = departmentHead;
    }
    public void setCourses(Course[] courses) {
        this.courses = courses;
    }
    public int getDepartmentIdNumber() {
        return departmentIdNumber;
    }
    public void setDepartmentIdNumber(int departmentIdNumber) {
        this.departmentIdNumber = departmentIdNumber;
    }


    public void printListOfCourses() {
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
        System.out.println("            [Lecturers in the department]");
        System.out.println();
        for (int i = 0; i < lecturers.length; i++) {
            Lecturer currentLecturer = lecturers[i];
            if (currentLecturer != null) {
                System.out.print("    "+counter +": ");
                this.lecturers[i].print();
                System.out.println("????????? ??? ???????????? ??? ???????????? ??? ???????????? ??? ???");

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
        System.out.println("Lecturer information: ");
        System.out.println("First Name:");
        String firstName = scanner.next();
        System.out.println("Last Name: ");
        String lastName = scanner.next();
        System.out.println("Experience: ");
        int experience = scanner.nextInt();
        Lecturer newLecture = new Lecturer(firstName, lastName,experience);
        for (int i = 0; i < newListOfLecturers.length; i++) {
            if (newListOfLecturers[i] == null) {
                newListOfLecturers[i] = newLecture;
                this.lecturers = newListOfLecturers;
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
        departmentHead.print();    //
        if (this.lecturers[0] == null) {
            System.out.println("Lecturers have not yet been added to this Department");
        } else {

            printListOfLecturers();

        }
        if (this.courses[0] == null) {
            System.out.println("Courses have not yet been added to this Department");
        } else {
            System.out.println("            [Courses belong to the department]");
            for (int i = 0; i < courses.length; i++) {
                if (courses[i] != null) {
                    System.out.println();
                    courses[i].print();
                    System.out.println();
                    System.out.println("????????? ??? ???????????? ??? ???????????? ??? ???????????? ??? ???");
                    System.out.println();
                }
        }
        }


    }
}



