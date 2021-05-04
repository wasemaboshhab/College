import java.util.Scanner;

public class Main {
    public static final int FIRST_INDEX = 0;
    public static final int START_FROM_ONE = 1;
    public static final int MAX_COURSE_ACTIONS = 4;
    public static final int MAX_DEPARTMENT_ACTIONS = 6;
    public static void main(String[] args) {

        Course[] ComputerSinceCourses = new Course[START_FROM_ONE];
        Course[] nursingCourses = new Course[START_FROM_ONE];
        Lecturer[] ComputerSinceLecturers = new Lecturer[START_FROM_ONE];
        Lecturer[] nursingLecturers = new Lecturer[START_FROM_ONE];

        DepartmentHead departmentHead1 = new DepartmentHead
        ("shai", "Givate", 23, "Public Opinion Communications Government and Elections", "Master's degree in software engineering");
        DepartmentHead departmentHead2 = new DepartmentHead
        ("Oren", "alizr", 1, "History", "Powers and Cold War");


        Department[] departments = {
                new Department("098765", "Computer Science", ComputerSinceCourses, ComputerSinceLecturers,departmentHead1),
                new Department("173765", "Nursing", nursingCourses, nursingLecturers,departmentHead2)
        };



        while (true) {
            Scanner scanner = new Scanner(System.in);
            showDepartmentsNames(departments);
            int userDepartment = scanner.nextInt();
            userDepartment = checkUserSelections(userDepartment, departments.length);
            userDepartment -= START_FROM_ONE;
            boolean displayADepartmentActions = true;
            while (displayADepartmentActions) {
            printActionsOnDepartment();
            int actionsToPerformForA_department = scanner.nextInt();
                switch (actionsToPerformForA_department) {
                    case 1:
                        departments[userDepartment].print();
                        break;
                    case 2:
                        renameDepartmentAndShowListWithChange(userDepartment, departments);
                        break;
                    case 3:
                        departments[userDepartment].addLecture();
                        break;
                    case 4:
                        casesForAddingCourse(userDepartment, departments);
                        break;
                    case 5:
                            Course[] currentCourses = departments[userDepartment].getCourses();
                            if (currentCourses[FIRST_INDEX]!= null) {
                                System.out.println("select Course: ");
                                departments[userDepartment].printListOfCourses();
                                int size = departments[userDepartment].getCourses().length - START_FROM_ONE ;
                                int chosenCourse = checkUserSelections( scanner.nextInt(),size);
                                chosenCourse -= START_FROM_ONE;
                                while (true) {
                                printActionsOnCourse();
                                    int  selectedOption = checkUserSelections(scanner.nextInt(), MAX_COURSE_ACTIONS);
                                int optionNumber = performingActionsOnCourse(chosenCourse, selectedOption,currentCourses);
                                    if (optionNumber == MAX_COURSE_ACTIONS)
                                        break;
                                }
                            } else
                                System.out.println("No courses were added for this Department");

                            break;
                    case 6:
                        displayADepartmentActions = false;
                        break;
                    default:
                        checkUserSelections(actionsToPerformForA_department, MAX_DEPARTMENT_ACTIONS );
                }
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            }
        }
    }




    public static int performingActionsOnCourse(int courseIndex, int optionNumber, Course[] currentCourses ) {
            Scanner scanner = new Scanner(System.in);
            switch (optionNumber) {
                case 1:
                    currentCourses[courseIndex].print();
                    break;
                case 2:
                    System.out.println("rename course: ");
                    currentCourses[courseIndex].setName(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("student Information: ");
                    System.out.println("First Name: ");
                    String firstName = scanner.next();
                    System.out.println("Last Name: ");
                    String lastName = scanner.next();
                    System.out.println("cardNumber: ");
                    int carNumber = scanner.nextInt();
                    Student newStudent = new Student(firstName, lastName, carNumber);
                    currentCourses[courseIndex].addStudent(newStudent);
                    break;
                case 4:
                    break;

            }

        return optionNumber;
    }
    public static void renameDepartmentAndShowListWithChange(int userDepartment, Department[] departments) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rename Department: ");
        String oldName = departments[userDepartment ].getName();
        departments[userDepartment].setName( scanner.nextLine());
        System.out.println("The new list with the change:");
        System.out.println();
        for (int i = 0; i < departments.length; i++) {
            String departmentsName = departments[i].getName();
            if (i == userDepartment) {
                System.out.println("* " + departmentsName + "\t/Previous Name: " + oldName);

            } else {
                System.out.println(departmentsName);

            }

        }
    }
    public static void casesForAddingCourse(int userDepartment, Department[] departments) {

        if (isLecturersMoreThanOne(departments[userDepartment]) == FIRST_INDEX) {
            System.out.println("No lecturers to teach the course");
        } else {
            departments[userDepartment ].addCourse();
            Course[] coursesList = departments[userDepartment].getCourses();
            switch (isLecturersMoreThanOne(departments[userDepartment])) {
                case 1:
                    coursesList[coursesList.length-2].setLecturer(departments[userDepartment ].getLecturers()[0]);
                    break;
                default:
                    Scanner scanner = new Scanner(System.in);
                    Lecturer[] currentLecturers = departments[userDepartment].getLecturers();
                    System.out.println("select a Lecturer to teach the course form 1 - " + (currentLecturers.length-1) + ": ");
                    departments[userDepartment ].printListOfLecturers();
                    int lecturerIndex = scanner.nextInt();
                    lecturerIndex = checkUserSelections(lecturerIndex, currentLecturers.length - 1);
                    coursesList[coursesList.length-2].setLecturer(departments[userDepartment ].getLecturers()[lecturerIndex - 1]);
            }
        }




    }
    public static int isLecturersMoreThanOne(Department department) {
        Lecturer[] LecturerList = department.getLecturers();
        int countLecturer = FIRST_INDEX;
        for (int i = 0; i < LecturerList.length; i++) {
            if (LecturerList[i] != null) {
                countLecturer++;
                if (i == 2) {
                    break;
                }
            }
        }
        return countLecturer;
    }
    public static void showDepartmentsNames(Department[] departments) {
        System.out.println();
        System.out.println("        choose a Department from 1-" + departments.length + ": ");
        System.out.println();
        for (int i = 0; i < departments.length; i++) {
            Department currentDepartment = departments[i];
            System.out.print(i + 1 + ": ");
            System.out.println(currentDepartment.getName());
        }
        System.out.println();
        System.out.println(">");
    }
    public static int checkUserSelections(int selectedNumber, int limit) {
        Scanner scanner = new Scanner(System.in);
        int selection = selectedNumber;
        boolean invalid = selection < START_FROM_ONE || selection > limit;
        if (invalid)
            do {
                System.out.println("invalid Selection");
                System.out.println(">");
                selection = scanner.nextInt();
                invalid = selection < START_FROM_ONE || selection > limit;
            } while (invalid);

        return selection;
    }
    public static void printActionsOnDepartment( ) {
        System.out.println("        Actions to perform for the Department : {" + 1 + '-' + MAX_DEPARTMENT_ACTIONS + '}');
        System.out.println("[1]Department information.");
        System.out.println("[2]change Department's name.");
        System.out.println("[3]add a Lecturer to the Department .");
        System.out.println("[4]add a Course to the Department .");
        System.out.println("[5]Select an existing course to perform additional actions.");
        System.out.println("[6]Back to the Departments list.");
        System.out.println(">");
    }
    public static void printActionsOnCourse() {
        System.out.println();
        System.out.println("options: ");
        System.out.println("[1]" + "Printing course information");
        System.out.println("[2]" + "Renaming the course");
        System.out.println("[3]" + "Add a student to the course");
        System.out.println("[4]" + "Back to the previous menu");
    }

}















