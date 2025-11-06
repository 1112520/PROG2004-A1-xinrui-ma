/**
 * HealthProfessional 基类
 * 包含所有健康专业人员的共通信息
 */
public class HealthProfessional {
    private int id;                 // 仅数字 ID
    private String name;            // 名字
    private String qualification;   // 额外通用信息：资质或专业级别

    // 默认构造器
    public HealthProfessional() {}

    // 全字段构造器
    public HealthProfessional(int id, String name, String qualification) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
    }

    // 打印方法（展示所有实例变量）
    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Qualification: " + qualification);
    }

    // getters and setters（封装示例）
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }
}
