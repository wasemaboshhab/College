public class Lecturer extends Person {
    private int yearsOfExperience;
    private boolean isDepartmentHead ;

    public Lecturer(String firstName, String lastName, int yearsOfExperience) {
        super(firstName, lastName);
        this.yearsOfExperience = yearsOfExperience;
    }
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public int getYearsOfExperience() {
        if (this.yearsOfExperience == 0)
            System.out.println("Experience: unknown" );
        return this.yearsOfExperience;
    }
    public boolean isDepartmentHead() {
        return isDepartmentHead;
    }
    public void setDepartmentHead(boolean departmentHead) {
        isDepartmentHead = departmentHead;
    }
    private  void notDepartmentHead() {
        this.isDepartmentHead = false;
        System.out.println("Lecturer Details:");
    }

    public void print() {
        if (!(this.isDepartmentHead)) {
            notDepartmentHead();
            super.print();
            if (this.yearsOfExperience == 0) {
                System.out.println("Experience: unknown");
            } else {
                System.out.println("Experience: " + this.yearsOfExperience + " Years");
                System.out.println();
            }

        } else {
            super.print();
            if (this.yearsOfExperience == 0) {
                System.out.println("Experience: unknown");
            } else {
                System.out.println("Experience: " + this.yearsOfExperience + " Years");

            }
        }




    }





}
