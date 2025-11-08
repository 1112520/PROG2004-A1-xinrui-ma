import java.util.ArrayList;

/**
 * AssignmentOne 主类
 * 展示：
 * Part 3 – Using classes and objects
 * Part 5 – Collection of appointments
 * + HD 加分项：预约时间冲突检测
 */
public class AssignmentOne {
    // Part 5 – 使用 ArrayList 管理所有预约
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        // ==========================
        // Part 3 – Using classes and objects
        // ==========================
        System.out.println("// Part 3 – Using classes and objects");

        // 创建 3 个全科医生（GP）与 2 个营养师（Dietitian）
        GeneralPractitioner gp1 = new GeneralPractitioner(1, "Dr. Alice", "MBBS", "Downtown Clinic");
        GeneralPractitioner gp2 = new GeneralPractitioner(2, "Dr. Bob", "MBBS", "Green Valley Clinic");
        GeneralPractitioner gp3 = new GeneralPractitioner(3, "Dr. Eve", "MBBS", "Westside Clinic");

        Dietitian d1 = new Dietitian(4, "Dr. Carol", "BSc Nutrition", 8);
        Dietitian d2 = new Dietitian(5, "Dr. Dan", "BSc Nutrition", 5);

        // 打印所有医生信息（演示继承与多态）
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

        // 创建若干预约
        createAppointment("Emma", "0411222333", "08:00", gp1);
        createAppointment("Liam", "0411333444", "10:00", gp2);
        createAppointment("Olivia", "0411555666", "09:30", d1);
        createAppointment("Noah", "0411666777", "14:00", d2);

        // 尝试创建重复时间段的预约（测试冲突检测）
        createAppointment("Mia", "0411888999", "09:30", gp3);

        // 打印现有预约
        printExistingAppointments();

        // 取消一个预约（按手机号）
        cancelBooking("0411333444");

        // 再次打印，验证取消成功
        printExistingAppointments();

        System.out.println("------------------------------");
    }

    /**
     * 创建新预约
     */
    public static void createAppointment(String patientName, String mobile, String timeSlot, HealthProfessional doctor) {
        if (patientName == null || patientName.isEmpty() ||
            mobile == null || mobile.isEmpty() ||
            timeSlot == null || timeSlot.isEmpty() ||
            doctor == null) {

            System.out.println("Invalid appointment. Please provide all details.");
            return;
        }

        // ===== 时间冲突检测（HD 加分项） =====
        for (Appointment a : appointments) {
            if (a.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                System.out.println("⚠️ Time slot " + timeSlot + " is already booked. Please choose another time.");
                return; // 直接返回，不创建新预约
            }
        }

        Appointment appt = new Appointment(patientName, mobile, timeSlot, doctor);
        appointments.add(appt);
        System.out.println("✅ Appointment created successfully for " + patientName + " at " + timeSlot);
    }

    /**
     * 打印所有预约信息
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
     * 取消指定手机号的预约
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
