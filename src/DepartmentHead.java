public class DepartmentHead extends Lecturer {
    private String specialty;
    private String degree;
    public DepartmentHead
    (String firstName, String lastName, int yearsOfExperience, String specialty, String degree) {
        super(firstName, lastName, yearsOfExperience);
        this.specialty = specialty;
        this.degree = degree;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    public String getSpecialty() {
        return this.specialty;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public String getDegree() {
        return this.degree;
    }

    public void print() {
        super.print();
        System.out.println("Specializes in: " + this.specialty);
        System.out.println("Degree: " + this.degree);
    }
}
