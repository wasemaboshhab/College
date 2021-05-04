public class Course {
    private String name;
    private Lecturer lecturer;
    private Student[] studentsInTheCourse;
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
            newListOfStudents[this.studentsInTheCourse.length] = newStudent;
            this.studentsInTheCourse = newListOfStudents;

        }
    }
    private void printStudentsInCourse() {
        if (this.studentsInTheCourse == null) {
            System.out.println("Students have not yet been added to the course");
        } else {
            System.out.println("            {Students in the course}");
            System.out.println();
            int counter = 1;
            for (int i = 0; i < this.studentsInTheCourse.length; i++) {
                Student currentStudent = studentsInTheCourse[i];
                if (currentStudent != null) {
                    System.out.println("        " + counter);
                    System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                    currentStudent.print();
                    System.out.println();
                    System.out.println();
                    counter++;
                }
            }
        }
    }
    public void print() {
        System.out.println();
        System.out.println("            Course Details:");
        System.out.println("Course Name: " + this.name);
        System.out.println();
         lecturer.print();
            printStudentsInCourse();


    }










}

