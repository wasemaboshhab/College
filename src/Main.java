import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Student[] listOfStudentsInTheCourse = {
                new Student("Wasim", "Shhab", 11111),
                new Student("Shirley", "cohen", 22222),
                new Student("David", "Achorbshko", 3333),
                new Student("Yossi", "Swisa", 4444)
        };

        Lecturer[] lecturers = {
                new Lecturer("Shai", "Givate", 15),
                new Lecturer("Azra", "Levi", 25),
                new Lecturer("Oren", "aleizr", 1)
        };


        Course[] courses = {
                new Course("Computer since", lecturers[0], listOfStudentsInTheCourse),
                new Course("History", lecturers[2], listOfStudentsInTheCourse),
                new Course("Linear Algebra", lecturers[1], listOfStudentsInTheCourse)
        };


        Course[] ComputerSinceCourses = new Course[1];
        Course[] nursingCourses = new Course[1];
        Lecturer[] ComputerSinceLecturers = new Lecturer[1];
        Lecturer[] nursingLecturers = new Lecturer[1];

        Department[] departments = {
                new Department("*1*", "Computer since", ComputerSinceCourses, ComputerSinceLecturers),
                new Department("*2*", "Nursing", nursingCourses, nursingLecturers)
        };




        int[] possibility = {1, 2, 3, 4, 5, 6};

        while (true) {
            Scanner scanner = new Scanner(System.in);
            showDepartment(departments);
            int userDepartment = scanner.nextInt();
            userDepartment = isDepartmentExist(departments.length, userDepartment);
            showPossibility(possibility);
            System.out.println(">");
            int actionsToPerformForA_class = scanner.nextInt();
            while (true) {
                Scanner input = new Scanner(System.in);

                switch (actionsToPerformForA_class) {
                    case 1:
                        departments[userDepartment - 1].print();
                        break;
                    case 2:
                        System.out.println("change Department's Name: ");
                        String name = input.nextLine();
                        departments[userDepartment - 1].setName(name);
                        break;
                    case 3:
                        departments[userDepartment - 1].addLecture();
                        break;
                    case 4:
                        isAllowToAddCourse(userDepartment, departments);
                        break;
                    case 5:
                        while (true) {
                            Course[] currentCourses = departments[userDepartment - 1].getCourses();
                            if (areThereCourses(currentCourses)) {
                                System.out.println("select Course: ");
                                departments[userDepartment - 1].printListOfCourses();
                                int chosenCourse = isCourseExisted(userDepartment, departments);
                                chosenCourse -= 1;
                                printOptions();
                                int selectedOption = input.nextInt();
                                selectedOption = CheckCorrectnessOfChoice(selectedOption );
                                PerformingActionsOnCourse(chosenCourse, selectedOption,currentCourses);
                                if (selectedOption == 4) {
                                    break;
                                }

                            }

                            else {
                                System.out.println("No courses were added for this Department");
                            }
                            break;
                        }
                    case 6:
                        break;
                    default:
                        int optionNumber;
                        do {
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println("ERROR!! invalid action");
                            System.out.println("Actions to perform for the Department chosen: {" + possibility[0] + '-' + possibility[possibility.length - 1] + '}');
                            optionNumber = scanner.nextInt();
                            System.out.println(">");


                        } while (optionNumber < possibility[0] || optionNumber > possibility[possibility.length - 1]);
                }
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;

            }


        }

    }

    public static void PerformingActionsOnCourse(int courseIndex, int optionNumber, Course[] currentCourses ) {
            Scanner scanner = new Scanner(System.in);
            switch (optionNumber) {
                case 1:
                    currentCourses[courseIndex].print();
                    break;
                case 2:
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

                default:
                    CheckCorrectnessOfChoice(optionNumber);
                    break;
            }


    }






    public static int isCourseExisted(int userDepartment, Department[] departments) {
        Scanner scanner = new Scanner(System.in);
        Course[] currentCourses = departments[userDepartment - 1].getCourses();
        int chosenCourse = scanner.nextInt();
        boolean invalidSelection = chosenCourse < 1 || chosenCourse > currentCourses.length;
        if (invalidSelection) {
            do {
                System.out.println("invalid Selection: ");
                chosenCourse = scanner.nextInt();
                invalidSelection = chosenCourse < 1 || chosenCourse > currentCourses.length-1;
            } while (invalidSelection);
        }
        return chosenCourse;
    }

    public static void printOptions() {
        System.out.println("options: ");
        System.out.println("[1]" + "Printing course information");
        System.out.println("[2]" + "Renaming the course");
        System.out.println("[3]" + "Add a student to the course");
        System.out.println("[4]" + "Back to the previous menu");
    }

    public static boolean areThereCourses(Course[] listOfCourses) {
        if (listOfCourses[0] != null) {
            return true;
        }
        return false;

    }

    public static int CheckCorrectnessOfChoice(int userSelection) {
        Scanner scanner = new Scanner(System.in);
        boolean invalidSelect = userSelection < 1 || userSelection > 4;
        if ((invalidSelect)) {
            do {
                System.out.println("invalid Selection");
                userSelection = scanner.nextInt();
                invalidSelect = userSelection < 1 || userSelection > 4;
            } while (invalidSelect);
        }
        return userSelection;
    }

    public static void isAllowToAddCourse(int userDepartment, Department[] departments) {
        Scanner scanner = new Scanner(System.in);

        if (1 < (oneLecturer(userDepartment, departments))) {

            Lecturer[] currentLecturers = departments[userDepartment - 1].getLecturers();
            System.out.println("select a Lecturer to teach the course form 1 - " + currentLecturers.length + ": ");
            departments[userDepartment - 1].printListOfLecturers();
            int lecturerIndex = scanner.nextInt();
            boolean invalidSelect = lecturerIndex < 1 || lecturerIndex > currentLecturers.length;
            if (invalidSelect) {
                do {
                    System.out.println("Invalid selection!!!");
                    System.out.println("select a Lecturer to teach the course form 1 - " + currentLecturers.length + ": ");
                    departments[userDepartment - 1].printListOfLecturers();
                    System.out.println("> ");
                    lecturerIndex = scanner.nextInt();
                    invalidSelect = lecturerIndex < 1 || lecturerIndex > currentLecturers.length;
                } while (invalidSelect);
            }
            departments[userDepartment - 1].addCourse();
            Course[] coursesList = departments[userDepartment - 1].getCourses();
            for (int i = 0; i < coursesList.length; i++) {
                if (coursesList[i] == null) {
                    if (i == 0) {
                        coursesList[i].setLecturer(departments[userDepartment - 1].getLecturers()[lecturerIndex - 1]);
                    } else {
                        coursesList[i - 1].setLecturer(departments[userDepartment - 1].getLecturers()[lecturerIndex - 1]);
                    }
                }
            }
        } else if (1 == oneLecturer(userDepartment, departments)) {

            departments[userDepartment - 1].addCourse();
            Course[] coursesList = departments[userDepartment - 1].getCourses();
            for (int i = 0; i < coursesList.length; i++) {
                if (coursesList[i] == null) {
                    coursesList[i - 1].setLecturer(departments[userDepartment - 1].getLecturers()[0]);
                }
            }
        } else {
            System.out.println("No lecturers to teach a course");
        }

    }

    public static int oneLecturer(int userDepartment, Department[] departments) {
        Lecturer[] list = departments[userDepartment - 1].getLecturers();
        int countLecturer = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                countLecturer++;
            }
        }
        return countLecturer;
    }


    public static void showDepartment(Department[] departments) {
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

    public static void showPossibility(int[] possibility) {
        System.out.println("        Actions to perform for the Department chosen: {" + possibility[0] + '-' + possibility[possibility.length - 1] + '}');
        System.out.println("[" + possibility[0] + "]Department information.");
        System.out.println("[" + possibility[1] + "]change Department's name.");
        System.out.println("[" + possibility[2] + "]add a Lecturer to the Department .");
        System.out.println("[" + possibility[3] + "]add a Course to the Department .");
        System.out.println("[" + possibility[4] + "]Select an existing course to perform additional actions.");
        System.out.println("[" + possibility[5] + "]Back to the Departments list.");
    }

    public static int isDepartmentExist(int size, int userDepartment) {
        Scanner scanner = new Scanner(System.in);
        boolean notExisted = userDepartment < 1 || userDepartment > size;
        if (notExisted) {
            do {
                System.out.println("Error!");
                System.out.println("        choose a Department from 1-" + size + ": ");
                userDepartment = scanner.nextInt();
                System.out.println(">");
                notExisted = userDepartment < 1 || userDepartment > size;

            } while (notExisted);
        }

        return userDepartment;
    }


}















