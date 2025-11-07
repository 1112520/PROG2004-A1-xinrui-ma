public class Appointment {
    private String patientName;
    private String mobile;
    private String timeSlot; // 格式例如 "08:00"
    private HealthProfessional doctor; // 组合关系

    public Appointment() {}

    public Appointment(String patientName, String mobile, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    public void printDetails() {
        System.out.println("Appointment for: " + patientName + " (" + mobile + ")");
        System.out.println("Time Slot: " + timeSlot);
        System.out.println("Doctor: ");
        doctor.printDetails();
        System.out.println("----------------------------------");
    }

    public String getMobile() { return mobile; }
    public String getPatientName() { return patientName; }
    public String getTimeSlot() { return timeSlot; }
    public HealthProfessional getDoctor() { return doctor; }
}

