/**
 * Dietitian class is a concrete subclass of HealthProfessional, designed to model nutrition specialists in the health service system.
 * It extends the base class to add dietitian-specific attributes, demonstrating OOP inheritance (ULO1) and polymorphism (ULO2).
 * Rationale for being a subclass: Dietitians are specialized health professionals who require unique attributes not shared by all base-class members—
 * "yearsOfExperience" is critical here because it reflects a dietitian’s expertise depth (e.g., guiding patient meal plans, managing chronic conditions),
 * which directly impacts patient booking choices and service quality.
 * This class adheres to encapsulation (private fields + controlled access via getters/setters) and overrides base-class methods to enable subtype-specific behavior.
 */
public class Dietitian extends HealthProfessional {
    // Unique attribute for Dietitian: Reflects the number of years the dietitian has practiced nutrition.
    // Unlike base-class attributes (ID, name, qualification), this field differentiates dietitians by expertise level—
    // a key factor for patients seeking specialized nutrition advice (e.g., a 10-year dietitian vs. a 2-year one).
    private int yearsOfExperience;

    /**
     * Default no-arg constructor: Invokes the base class (HealthProfessional) default constructor via super()
     * to initialize inherited fields (ID, name, qualification) to default values.
     * Follows JavaBean conventions to support flexible object creation (e.g., when populating data dynamically).
     */
    public Dietitian() {
        super(); // Inherit default initialization logic from HealthProfessional (encapsulates base-class setup)
    }

    /**
     * Parameterized constructor: Initializes all inherited fields (via super()) and dietitian-specific field,
     * ensuring complete and consistent object creation.
     * This constructor enforces data integrity by requiring all necessary information to create a valid Dietitian instance.
     * 
     * @param id Inherited from HealthProfessional: Unique numeric identifier for the dietitian (e.g., 4)
     * @param name Inherited from HealthProfessional: Full name of the dietitian (e.g., "Dr. Carol")
     * @param qualification Inherited from HealthProfessional: Professional credential (e.g., "BSc Nutrition")
     * @param yearsOfExperience Dietitian-specific: Number of years the dietitian has practiced (e.g., 8)
     */
    public Dietitian(int id, String name, String qualification, int yearsOfExperience) {
        super(id, name, qualification); // Pass inherited fields to base-class constructor (reuses base logic)
        this.yearsOfExperience = yearsOfExperience; // Initialize subtype-specific attribute
    }

    /**
     * Overridden printDetails() method: Extends base-class behavior to include dietitian-specific information,
     * demonstrating polymorphism (ULO2). When called on a HealthProfessional reference pointing to a Dietitian,
     * this subtype-specific implementation runs (instead of the base-class version).
     * Output includes a clear type label ("Dietitian") to distinguish this specialist from other health professionals (e.g., GeneralPractitioner),
     * improving readability for administrative workflows.
     */
    @Override
    public void printDetails() {
        System.out.println("The health professional details are (Dietitian):"); // Type label for clarity
        super.printDetails(); // Reuse base-class logic to print inherited fields (avoids code duplication)
        System.out.println("Years of Experience: " + yearsOfExperience); // Print subtype-specific attribute
    }

    /**
     * Getter for yearsOfExperience: Enables controlled access to the private field (encapsulation principle),
     * supporting use cases like filtering dietitians by experience (e.g., "show dietitians with >5 years experience" in the appointment system).
     * 
     * @return int The number of years the dietitian has practiced
     */
    public int getYearsOfExperience() { 
        return yearsOfExperience; 
    }

    /**
     * Setter for yearsOfExperience: Allows dynamic updates to the experience count (e.g., annual experience increments),
     * while maintaining encapsulation (no direct field access from outside the class).
     * 
     * @param yearsOfExperience Updated number of years the dietitian has practiced
     */
    public void setYearsOfExperience(int yearsOfExperience) { 
        this.yearsOfExperience = yearsOfExperience; 
    }
}