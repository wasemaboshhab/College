import java.util.Scanner;

public class Main {
    public static final int FIRST_INDEX = 0;
    public static final int START_FROM_ONE = 1;
    public static final int PLACE_OF_NEW_COURSES = 2;
    public static final int MAX_COURSE_ACTIONS = 4;
    public static final int MAX_DEPARTMENT_ACTIONS = 6;
    public static void main(String[] args) {

        Course[] computerScienceCourses = new Course[START_FROM_ONE];
        Course[] nursingCourses = new Course[START_FROM_ONE];
        Lecturer[] computerScienceLecturers = new Lecturer[START_FROM_ONE];
        Lecturer[] nursingLecturers = new Lecturer[START_FROM_ONE];

        DepartmentHead departmentHead1 = new DepartmentHead
                ("shai", "Givate", (int) (Math.random() * 10) + 10, "Public Opinion Communications Government and Elections", "Master's degree in software engineering");
        DepartmentHead departmentHead2 = new DepartmentHead
                ("Ester", "David", (int) (Math.random() * 20) + 10, "History", "Powers and Cold War");


        int randomNumber = (int) (Math.random() * 100)*MAX_DEPARTMENT_ACTIONS;
        Department[] departments = {
                new Department(randomNumber, "Computer Science", computerScienceCourses, computerScienceLecturers, departmentHead1),
                new Department(randomNumber + MAX_COURSE_ACTIONS, "Nursing", nursingCourses, nursingLecturers, departmentHead2)
        };
        sayWelcome();


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
                        System.out.println("invalid Selection");
                }
                System.out.println();
                System.out.println("-’๑‘- ❂ ✡ ╮☆╰ ❋ ❊ ❉ ❈ ❇ ❆ ❅ ❄ ✼ ✻ ✺ ✹ ✸ ✷-’๑‘- ❂ ✡ ╮☆╰ ❋ ❊ ❉ ❈ ❇ ❆ ❅ ❄ ✼ ✻ ✺ ✹ ✸ ✷ ✶ ✵ ✴ ✳ ✲ ✱ ★ ✰ ✯ ✮ ✭ ✬ ✫ ✪ ✩ ✧ ✦ ✥ ✤ ✣ ✢ ⋆ ✶ ✵ ✴ ✳ ✲ ✱ ★ ✰ ✯ ✮ ✭ ✬ ✫ ✪ ✩ ✧ ✦ ✥ ✤ ✣ ✢ ⋆-’๑‘- ❂ ✡ ╮☆╰ ❋ ❊ ❉ ❈ ❇ ❆ ❅ ❄ ✼ ✻ ✺ ✹ ✸ ✷ ✶ ✵ ✴ ✳ ✲ ✱ ★ ✰ ✯ ✮ ✭ ✬ ✫ ✪ ✩ ✧ ✦ ✥ ✤ ✣ ✢ ⋆ ");
                System.out.println();
            }
        }
    }


    public static void sayWelcome() {
        System.out.println("        x╔╦╦╦═╦╗╔═╦═╦══╦═╗x\n" +
                "        x║║║║╩╣╚╣═╣║║║║║╩╣x\n" +
                "        x╚══╩═╩═╩═╩═╩╩╩╩═╝x\n");

    }
    public static int performingActionsOnCourse(int courseIndex, int optionNumber, Course[] currentCourses ) {
            Scanner scanner = new Scanner(System.in);
            switch (optionNumber) {
                case START_FROM_ONE:
                    currentCourses[courseIndex].print();
                    break;
                case PLACE_OF_NEW_COURSES:
                    System.out.println("rename course: ");
                    currentCourses[courseIndex].setName(scanner.nextLine());
                    break;
                case PLACE_OF_NEW_COURSES + START_FROM_ONE:
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
                case MAX_COURSE_ACTIONS:
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
            departments[userDepartment].addCourse();
            Course[] coursesList = departments[userDepartment].getCourses();
            switch (isLecturersMoreThanOne(departments[userDepartment])) {
                case START_FROM_ONE:
                    coursesList[coursesList.length-PLACE_OF_NEW_COURSES].setLecturer(departments[userDepartment ].getLecturers()[FIRST_INDEX]);
                    break;
                default:
                    Scanner scanner = new Scanner(System.in);
                    Lecturer[] currentLecturers = departments[userDepartment].getLecturers();
                    System.out.println("select a Lecturer to teach the course form " + START_FROM_ONE + '-' + (currentLecturers.length - START_FROM_ONE) + ": ");
                    departments[userDepartment].printListOfLecturers();
                    int lecturerIndex = checkUserSelections(scanner.nextInt(), currentLecturers.length - START_FROM_ONE);
                    coursesList[coursesList.length-PLACE_OF_NEW_COURSES].setLecturer(departments[userDepartment ].getLecturers()[lecturerIndex - START_FROM_ONE]);
            }
        }




    }
    public static int isLecturersMoreThanOne(Department department) {
        Lecturer[] LecturerList = department.getLecturers();
        int countLecturer = FIRST_INDEX;
        for (int i = 0; i < LecturerList.length; i++) {
            if (LecturerList[i] != null) {
                countLecturer++;
                if (i == PLACE_OF_NEW_COURSES) {
                    break;
                }
            }
        }
        return countLecturer;
    }
    public static void showDepartmentsNames(Department[] departments) {
        System.out.println();
        System.out.println("        choose a Department from " + START_FROM_ONE + '-' + departments.length + ": ");
        System.out.println();
        for (int i = 0; i < departments.length; i++) {
            Department currentDepartment = departments[i];
            System.out.print(i + START_FROM_ONE + ": ");
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
        System.out.println("        Actions to perform for the Department : {" + START_FROM_ONE + '-' + MAX_DEPARTMENT_ACTIONS + '}');
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















