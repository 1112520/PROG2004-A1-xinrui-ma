import java.util.ArrayList;

public class AssignmentOne {
    // Part 5 – Collection of appointments
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        // Part 3 – Using classes and objects
        System.out.println("// Part 3 – Using classes and objects");

        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. Alice", "MBBS", "Downtown Clinic");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Bob", "MBBS", "Green Valley Clinic");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Eve", "MBBS", "Westside Clinic");

        Dietitian d1 = new Dietitian(4, "Dr. Carol", "BSc Nutrition", 8);
        Dietitian d2 = new Dietitian(5, "Dr. Dan", "BSc Nutrition", 5);

        // 使用方法打印所有专业人员信息（包括基类信息）
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

        // Part 5 – Collection of appointments
        System.out.println("// Part 5 – Collection of appointments");

        // 创建预约（2 个 GP，2 个 Dietitian）
        createAppointment("Emma", "0411222333", "08:00", gp1);
        createAppointment("Liam", "0411333444", "10:00", gp2);
        createAppointment("Olivia", "0411555666", "09:30", d1);
        createAppointment("Noah", "0411666777", "14:00", d2);

        // 打印现有预约
        printExistingAppointments();

        // 取消一个预约（用手机号）
        cancelBooking("0411333444"); // 取消 Liam 的预约

        // 再次打印现有预约，展示更新后的集合
        printExistingAppointments();

        System.out.println("------------------------------");
    }

    // createAppointment 方法：若信息不完整则拒绝创建
    public static void createAppointment(String patientName, String mobile, String timeSlot, HealthProfessional doctor) {
        if (patientName == null || patientName.isEmpty() ||
            mobile == null || mobile.isEmpty() ||
            timeSlot == null || timeSlot.isEmpty() ||
            doctor == null) {

            System.out.println("Invalid appointment. Please provide all details.");
            return;
        }

        Appointment appt = new Appointment(patientName, mobile, timeSlot, doctor);
        appointments.add(appt);
        System.out.println("Appointment created successfully for " + patientName + " at " + timeSlot);
    }

    // printExistingAppointments 方法
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

    // cancelBooking 方法：按手机号取消
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
