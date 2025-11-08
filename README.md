# PROG2004-A1-xinrui-ma
# PROG2004 A1 健康服务预约系统
学生ID：1112520  
项目名称：健康服务预约系统  

## 项目结构
- `src/AssignmentOne.java`：主类，包含 main 方法和预约管理功能  
- `src/HealthProfessional.java`：基类，封装健康专业人员的共性属性  
- `src/GeneralPractitioner.java`：子类，继承基类，添加诊所位置属性  
- `src/Dietitian.java`：子类，继承基类，添加从业年限属性  
- `src/Appointment.java`：预约类，关联患者、时间和医生信息  

## 运行方法
1. 编译：在终端进入 src 目录，执行 `javac *.java`  
2. 运行：执行 `java AssignmentOne`  

## 开发说明
本项目通过继承和多态实现健康服务人员的差异化管理，支持预约的创建、打印和取消功能。