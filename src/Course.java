public class Course {




    private String name;
    private Lecturer lecturer;
    private Student[] studentsInTheCourse;
                //constructor
    public Course(String name, Lecturer lecturer, Student[] studentsInTheCourse) {
        this.name = name;
        this.lecturer = lecturer;
        this.studentsInTheCourse = studentsInTheCourse;
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
    public Lecturer getLecturer() {
        return this.lecturer;
    }
    public Student[] getStudentsInTheCourse() {
        return this.studentsInTheCourse;
    }
    public void setStudentsInTheCourse(Student[] studentsInTheCourse) {
        this.studentsInTheCourse = studentsInTheCourse;
    }




    public void addStudent(Student newStudent) {

        boolean nullAddress = this.studentsInTheCourse == null;

        if (nullAddress) {
            Student[] newListOfStudents = new Student[1];
            newListOfStudents[0] = newStudent;
            this.studentsInTheCourse = newListOfStudents;
        } else if (this.studentsInTheCourse[studentsInTheCourse.length - 1] != null) {
            Student[] newListOfStudents = new Student[this.studentsInTheCourse.length + 1];
            for (int i = 0; i < this.studentsInTheCourse.length; i++) {
                newListOfStudents[i] = studentsInTheCourse[i];
            }
            this.studentsInTheCourse = newListOfStudents;
            for (int i = 0; i < this.studentsInTheCourse.length; i++) {
                if (this.studentsInTheCourse[i] == null) {
                    studentsInTheCourse[i] = newStudent;
                    break;
                }
            }

        }
    }
    public void printLecturer() {
        lecturer.print();

    }
    public void printStudentsInCourse() {  //should print the list not return it .
        if (this.studentsInTheCourse == null) {
            System.out.println("Students have not yet been added to the course");
        }

        else {
            System.out.println("            {Students in the course} :");
            for (int i = 0; i < this.studentsInTheCourse.length; i++) {
                Student currentStudent = studentsInTheCourse[i];
                if (currentStudent != null) {
                    System.out.print("        ");
                    currentStudent.print();
                    System.out.println("------------------");
                    System.out.println();
                }
            }
        }
    }
    public void print() {


        System.out.println();
        System.out.println("                                    {Course Details}:");
        System.out.println("Course Name: " + this.name);
        System.out.println();
        if (this.lecturer == null ) {
            System.out.println("There is currently no lecturer for this course!!");
            System.out.println();
        }
        else{ lecturer.print();}

            printStudentsInCourse();


    }










}

