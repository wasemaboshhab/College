public class Lecturer extends Person {
    private int yearsOfExperience;

    public Lecturer(String firstName, String lastName) {
        super(firstName, lastName);
    }

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

    public void print() {
        System.out.println("Lecturer Details:");
        super.print();
        if (this.yearsOfExperience == 0) {
            System.out.println("Experience: unknown" );
        }else {
            System.out.println("Experience: " + this.yearsOfExperience + " Years");
            System.out.println();
        }
    }





}
