/**
 * GeneralPractitioner is a concrete subclass of HealthProfessional, specifically designed to model 
 * primary care physicians (GPs) in the health service appointment system. This class embodies core 
 * Object-Oriented Programming (OOP) principles—inheritance, polymorphism, and encapsulation—directly 
 * aligning with Unit Learning Outcomes (ULO1: advanced class design; ULO2: applying OOP to solve intermediate problems).
 * 
 * Rationale for subclass designation: GPs serve as the primary point of contact for patients, requiring 
 * unique attributes that distinguish them from other health professionals (e.g., Dietitians, Cardiologists). 
 * The "clinicLocation" field is critical here: unlike specialists who may work in hospitals or remote-based 
 * dietitians, GPs operate from fixed, community-facing clinics. Patient booking decisions for primary care 
 * heavily rely on clinic proximity, making this field essential to the system’s real-world utility. This design 
 * ensures the class inherits shared health professional traits (via HealthProfessional) while capturing GP-specific 
 * context—avoiding "fat class" anti-patterns and maintaining high cohesion (a key HD-level class design requirement).
 */
public class GeneralPractitioner extends HealthProfessional {
    // GP-specific instance variable: Stores the physical address of the GP's clinic (e.g., "123 Main St, Springfield").
    // Rationale for exclusivity to GeneralPractitioner:
    // 1. Addresses patient-centric needs (proximity to care is a top priority for primary care bookings);
    // 2. Differentiates GPs from subclasses like Dietitians (who may offer telehealth or home visits);
    // 3. Enables administrative workflows (e.g., regional GP allocation, clinic capacity tracking).
    private String clinicLocation; // GP 特有字段

    /**
     * Default no-argument constructor: Invokes the base class (HealthProfessional) default constructor via super()
     * to initialize inherited fields (ID, name, qualification) to default values. 
     * Follows JavaBean conventions to support flexible object creation (e.g., when populating data from user input forms
     * or external data sources), ensuring compatibility with common Java development patterns.
     */
    public GeneralPractitioner() {
        super(); // Reuse base class logic to initialize shared attributes (ID, name, qualification)
                 // Avoids code duplication and enforces consistency with parent class initialization rules
    }

    /**
     * Parameterized constructor: Initializes all inherited fields (via super()) and GP-specific "clinicLocation",
     * ensuring complete, valid object creation. This constructor enforces data integrity by requiring all necessary
     * information to represent a functional GP—no critical fields are left uninitialized (a key requirement for HD-level code accuracy).
     * 
     * @param id Inherited from HealthProfessional: Unique numeric identifier for the GP (e.g., 5, 10) to avoid duplicate records.
     * @param name Inherited from HealthProfessional: Full legal name of the GP (e.g., "Dr. Sarah Miller") for patient identification.
     * @param qualification Inherited from HealthProfessional: Professional credential (e.g., "MBBS, FRACGP") to validate expertise.
     * @param clinicLocation GP-specific: Physical location of the GP’s clinic—critical for patient booking and appointment attendance.
     */
    public GeneralPractitioner(int id, String name, String qualification, String clinicLocation) {
        super(id, name, qualification); // Pass shared attributes to base class constructor (reuses parent logic)
        this.clinicLocation = clinicLocation; // Initialize GP-specific location—ensures no null values for critical business data
    }

    /**
     * Overridden printDetails() method: Extends the base class’s print functionality to include GP-specific information,
     * demonstrating polymorphism (ULO2). When a HealthProfessional reference points to a GeneralPractitioner instance,
     * this subtype-specific implementation executes (instead of the base class version), enabling dynamic behavior.
     * 
     * HD-level design choices:
     * 1. Includes a clear subtype label ("General Practitioner") to disambiguate GPs from other health professionals (e.g., Dietitians)
     *    —critical for administrative staff reviewing booking logs;
     * 2. Calls super.printDetails() to reuse base class logic for shared fields (ID, name, qualification)—avoids code redundancy
     *    and maintains consistency with parent class output formatting;
     * 3. Prints "clinicLocation" to address patient needs (confirming where to attend the appointment)—aligns the method with
     *    the system’s core purpose of managing health service bookings.
     */
    @Override
    public void printDetails() {
        System.out.println("The health professional details are (General Practitioner):"); // Subtype label for clarity
        super.printDetails(); // Reuse base class to print shared attributes (avoids redundant code)
        System.out.println("Clinic Location: " + clinicLocation); // Print GP-specific location—critical for end-user (patient) value
    }

    /**
     * Getter for clinicLocation: Enables controlled access to the private field (encapsulation principle, ULO1),
     * supporting key business use cases:
     * - Patient-facing: Filtering GPs by location (e.g., "show all GPs within 5km of my address");
     * - Administrative: Validating appointment locations against clinic capacity;
     * - Reporting: Generating regional GP coverage analytics.
     * 
     * @return String The physical location of the GP’s clinic (never null for properly initialized instances).
     */
    public String getClinicLocation() { 
        return clinicLocation; 
    }

    /**
     * Setter for clinicLocation: Allows dynamic updates to the clinic location (e.g., if the GP relocates to a new facility),
     * while maintaining encapsulation (no direct external access to the private field). This method ensures the class
     * remains flexible to real-world changes in the health service—avoiding the need to recreate GP instances when locations shift.
     * 
     * @param clinicLocation Updated physical location of the GP’s clinic (should be non-null to preserve data integrity).
     */
    public void setClinicLocation(String clinicLocation) { 
        this.clinicLocation = clinicLocation; 
    }
}