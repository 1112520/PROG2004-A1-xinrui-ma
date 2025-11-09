/**
 * Appointment class implements the composition design pattern (has-a relationship) with HealthProfessional.
 * It encapsulates patient booking details, preferred time slot, and the associated health professional.
 * This class supports polymorphism by accepting any subclass of HealthProfessional (e.g., GeneralPractitioner, Dietitian)
 * as the attending doctor, enabling flexible appointment management for diverse health service types.
 * Aligns with ULO1 (advanced class design) and ULO2 (OOP principles application) by demonstrating composition, encapsulation, and polymorphism.
 */
public class Appointment {
    // Patient's full name for identification in the booking
    private String patientName;
    
    // Patient's mobile phone number (unique identifier for booking cancellation and verification)
    private String mobile;
    
    // Preferred time slot for the appointment (format: "HH:MM" e.g., "08:00", "14:30")
    private String timeSlot;
    
    // Composition: Appointment is dependent on a HealthProfessional (or its subclasses)
    // Uses base class reference to enable polymorphism - supports any HealthProfessional subtype
    private HealthProfessional doctor;

    /**
     * Default constructor (no-arg) - initializes empty Appointment object
     * Follows JavaBean convention for flexibility in object creation
     */
    public Appointment() {}

    /**
     * Parameterized constructor - initializes all instance variables with valid input data
     * Ensures complete and consistent object creation with required booking details
     * 
     * @param patientName Full name of the patient making the appointment
     * @param mobile Patient's mobile number (used for booking cancellation)
     * @param timeSlot Preferred appointment time (follows "HH:MM" format)
     * @param doctor HealthProfessional (or subclass) attending the appointment (enables polymorphism)
     */
    public Appointment(String patientName, String mobile, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    /**
     * Prints all appointment details in a readable format, including nested HealthProfessional information.
     * Demonstrates polymorphism by calling the overridden printDetails() method of the specific HealthProfessional subclass.
     * Ensures transparency of booking information for both patients and administrative staff.
     */
    public void printDetails() {
        System.out.println("Appointment for: " + patientName + " (" + mobile + ")");
        System.out.println("Time Slot: " + timeSlot);
        System.out.println("Doctor: ");
        doctor.printDetails(); // Polymorphic call - behavior adapts to doctor's actual subclass type
        System.out.println("----------------------------------");
    }

    /**
     * Getter for patient's mobile number - supports cancellation functionality (by mobile lookup)
     * Follows encapsulation principle by providing controlled access to private field
     * 
     * @return String Patient's mobile phone number
     */
    public String getMobile() { 
        return mobile; 
    }

    /**
     * Getter for patient's name - enables verification of booking details
     * 
     * @return String Patient's full name
     */
    public String getPatientName() { 
        return patientName; 
    }

    /**
     * Getter for appointment time slot - supports time conflict detection (HD enhancement)
     * 
     * @return String Appointment time in "HH:MM" format
     */
    public String getTimeSlot() { 
        return timeSlot; 
    }

    /**
     * Getter for attending doctor - enables access to HealthProfessional details for administrative checks
     * Maintains polymorphism by returning base class reference (compatible with all subclasses)
     * 
     * @return HealthProfessional The doctor assigned to the appointment (could be GP, Dietitian, etc.)
     */
    public HealthProfessional getDoctor() { 
        return doctor; 
    }
}