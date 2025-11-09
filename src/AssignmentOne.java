import java.util.ArrayList;

/**
 * Main class for AssignmentOne
 * Demonstrates:
 * Part 3 – Using classes and objects
 * Part 5 – Collection of appointments
 * + Appointment time conflict detection
 */
public class AssignmentOne {
    // Part 5 – Use ArrayList to manage all appointments
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        // ==========================
        // Part 3 – Using classes and objects
        // ==========================
        System.out.println("// Part 3 – Using classes and objects");

        // Create 3 General Practitioners (GPs) and 2 Dietitians
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. Alice", "MBBS", "Downtown Clinic");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Bob", "MBBS", "Green Valley Clinic");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Eve", "MBBS", "Westside Clinic");

        Dietitian d1 = new Dietitian(4, "Dr. Carol", "BSc Nutrition", 8);
        Dietitian d2 = new Dietitian(5, "Dr. Dan", "BSc Nutrition", 5);

        // Print all doctor information (demonstrating inheritance and polymorphism)
        gp1.printDetails();
        System.out.println();
        gp2.printDetails();
        System.out.println();
        gp3.printDetails();
        System.out.println();
        d1.printDetails();
        System.out.println();
        d2.printDetails();

        System.out.println("------------------------------");

        // ==========================
        // Part 5 – Collection of appointments
        // ==========================
        System.out.println("// Part 5 – Collection of appointments");

        // Create several appointments
        createAppointment("Emma", "0411222333", "08:00", gp1);
        createAppointment("Liam", "0411333444", "10:00", gp2);
        createAppointment("Olivia", "0411555666", "09:30", d1);
        createAppointment("Noah", "0411666777", "14:00", d2);

        // Attempt to create an appointment with a duplicate time slot (to test conflict detection)
        createAppointment("Mia", "0411888999", "09:30", gp3);

        // Print existing appointments
        printExistingAppointments();

        // Cancel an appointment (by mobile number)
        cancelBooking("0411333444");

        // Print again to verify cancellation was successful
        printExistingAppointments();

        System.out.println("------------------------------");
    }

    /**
     * Create a new appointment
     */
    public static void createAppointment(String patientName, String mobile, String timeSlot, HealthProfessional doctor) {
        if (patientName == null || patientName.isEmpty() ||
            mobile == null || mobile.isEmpty() ||
            timeSlot == null || timeSlot.isEmpty() ||
            doctor == null) {

            System.out.println("Invalid appointment. Please provide all details.");
            return;
        }

        // ===== Time slot conflict detection =====
        for (Appointment a : appointments) {
            if (a.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                System.out.println(" Time slot " + timeSlot + " is already booked. Please choose another time.");
                return; // Return directly, do not create new appointment
            }
        }

        Appointment appt = new Appointment(patientName, mobile, timeSlot, doctor);
        appointments.add(appt);
        System.out.println(" Appointment created successfully for " + patientName + " at " + timeSlot);
    }

    /**
     * Print all appointment information
     */
    public static void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
            return;
        }

        System.out.println("Existing Appointments:");
        for (Appointment a : appointments) {
            a.printDetails();
        }
    }

    /**
     * Cancel the appointment with the specified mobile number
     */
    public static void cancelBooking(String mobile) {
        boolean found = false;
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getMobile().equals(mobile)) {
                System.out.println("Cancelling appointment for " + appointments.get(i).getPatientName() + " (" + mobile + ")");
                appointments.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No appointment found for mobile: " + mobile);
        }
    }
}