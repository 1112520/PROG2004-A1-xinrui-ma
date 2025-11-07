public class GeneralPractitioner extends HealthProfessional {
    private String clinicLocation; // GP 特有字段

    public GeneralPractitioner() {
        super();
    }

    public GeneralPractitioner(int id, String name, String qualification, String clinicLocation) {
        super(id, name, qualification);
        this.clinicLocation = clinicLocation;
    }

    @Override
    public void printDetails() {
        System.out.println("The health professional details are (General Practitioner):");
        super.printDetails();
        System.out.println("Clinic Location: " + clinicLocation);
    }

    public String getClinicLocation() { return clinicLocation; }
    public void setClinicLocation(String clinicLocation) { this.clinicLocation = clinicLocation; }
}
