public class Dietitian extends HealthProfessional {
    private int yearsOfExperience; // Dietitian 特有字段

    public Dietitian() {
        super();
    }

    public Dietitian(int id, String name, String qualification, int yearsOfExperience) {
        super(id, name, qualification);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void printDetails() {
        System.out.println("The health professional details are (Dietitian):");
        super.printDetails();
        System.out.println("Years of Experience: " + yearsOfExperience);
    }

    // getter/setter
    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }
}
