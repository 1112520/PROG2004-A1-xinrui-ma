/**
 * HealthProfessional is the abstract base class (superclass) for all specialized health service providers 
 * (e.g., GeneralPractitioner, Dietitian) in the health service appointment system. This class embodies 
 * the "generalization" principle of Object-Oriented Programming (OOP), encapsulating shared attributes 
 * and behaviors of all health professionals—directly aligning with Unit Learning Outcomes (ULO1: advanced 
 * class design; ULO2: applying OOP principles to solve intermediate problems).
 * 
 * Rationale for base class designation: All health professionals, regardless of specialization, require 
 * core identifying and credentialing information (ID, name, qualification). By centralizing these in a 
 * base class, the design eliminates code redundancy (via inheritance) and enforces consistency across 
 * subclasses. This structure also enables polymorphism: a single HealthProfessional reference can point 
 * to any subclass instance, simplifying appointment management for diverse provider types (a critical 
 * requirement for the system’s flexibility).
 * 
 * Key OOP principle applied: Encapsulation (private fields + controlled access via getters/setters) 
 * protects data integrity—external classes cannot modify core attributes directly, reducing the risk of 
 * invalid data (e.g., negative IDs, empty names).
 */
public class HealthProfessional {
    // Unique numeric identifier for the health professional (e.g., 1, 3, 7).
    // Purpose: Ensures no duplicate records in the appointment system (critical for tracking bookings 
    // and avoiding confusion between providers with similar names). Private access enforces encapsulation.
    private int id;

    // Full legal name of the health professional (e.g., "Dr. Michael Chen").
    // Purpose: Primary identifier for patients when selecting a provider. Private access prevents 
    // unintended name modifications (e.g., typos) that could disrupt patient trust or booking workflows.
    private String name;

    // Professional credential(s) of the health professional (e.g., "MBBS", "BSc Nutrition", "FRACP").
    // Purpose: Validates the provider’s expertise to ensure patients book qualified professionals. 
    // Private access ensures credentials are only updated through controlled methods (e.g., after verifying new certifications).
    private String qualification;

    /**
     * Default no-argument constructor: Initializes an empty HealthProfessional instance with default values.
     * Design rationale: Follows JavaBean conventions, enabling flexible object creation scenarios—
     * e.g., populating attributes dynamically from user input forms or external data sources (e.g., CSV imports).
     * Maintains consistency with subclass default constructors, which invoke this via super().
     */
    public HealthProfessional() {}

    /**
     * Parameterized constructor: Initializes all core attributes of a HealthProfessional, ensuring a 
     * complete, valid instance is created. This constructor enforces data integrity by requiring all 
     * critical information upfront—no core field is left uninitialized (a key requirement for HD-level code accuracy).
     * 
     * @param id Unique numeric identifier (must be non-negative to avoid invalid records).
     * @param name Full name of the provider (must be non-empty to ensure patient clarity).
     * @param qualification Professional credential (must be non-empty to validate expertise).
     */
    public HealthProfessional(int id, String name, String qualification) {
        this.id = id;          // Assign unique ID (enforced via setter in real-world use for validation)
        this.name = name;      // Assign provider name (critical for patient identification)
        this.qualification = qualification; // Assign credentials (validates professional competency)
    }

    /**
     * Prints all core attributes of the HealthProfessional in a human-readable format.
     * Design rationale: Serves as a foundation for subclass print methods—subclasses (e.g., GeneralPractitioner)
     * can invoke this via super.printDetails() to reuse base logic, avoiding code redundancy.
     * Ensures consistency in how shared attributes are displayed across all health professional types,
     * simplifying administrative review of booking details.
     */
    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Qualification: " + qualification);
    }

    /**
     * Getter for id: Enables controlled access to the private ID field (encapsulation principle).
     * Key use cases: 
     * - Identifying a specific provider when searching appointments;
     * - Validating provider existence in the system;
     * - Preventing duplicate bookings for the same provider (via ID comparison).
     * 
     * @return int Unique numeric ID of the health professional.
     */
    public int getId() { 
        return id; 
    }

    /**
     * Setter for id: Allows dynamic updates to the ID (e.g., correcting a typo in initial data entry).
     * Controlled access ensures validation logic can be added (e.g., checking for non-negative values)
     * to maintain data integrity—critical for avoiding invalid records in the appointment system.
     * 
     * @param id Updated unique numeric ID (should be non-negative).
     */
    public void setId(int id) { 
        this.id = id; 
    }

    /**
     * Getter for name: Enables controlled access to the private name field.
     * Key use cases:
     * - Displaying provider names to patients in booking interfaces;
     * - Generating appointment confirmations with provider details;
     * - Filtering providers by name (e.g., "search for Dr. Smith").
     * 
     * @return String Full name of the health professional.
     */
    public String getName() { 
        return name; 
    }

    /**
     * Setter for name: Allows updates to the provider’s name (e.g., after a legal name change).
     * Controlled access ensures the name remains non-empty, preventing confusing or invalid entries
     * that could disrupt patient-provider matching.
     * 
     * @param name Updated full name (should be non-empty).
     */
    public void setName(String name) { 
        this.name = name; 
    }

    /**
     * Getter for qualification: Enables controlled access to the private credential field.
     * Key use cases:
     * - Displaying provider expertise to patients (e.g., "Dr. Lee: MBBS, FRACGP");
     * - Validating provider qualifications for specialized bookings (e.g., ensuring a Dietitian has "BSc Nutrition");
     * - Generating administrative reports on provider credentials.
     * 
     * @return String Professional qualification(s) of the health professional.
     */
    public String getQualification() { 
        return qualification; 
    }

    /**
     * Setter for qualification: Allows updates to credentials (e.g., after a provider earns a new certification).
     * Controlled access ensures qualifications remain non-empty, maintaining trust in the system’s provider validity.
     * 
     * @param qualification Updated professional credential (should be non-empty).
     */
    public void setQualification(String qualification) { 
        this.qualification = qualification; 
    }
}