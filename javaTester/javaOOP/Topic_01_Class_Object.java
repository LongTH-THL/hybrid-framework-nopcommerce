package javaOOP;

public class Topic_01_Class_Object {
    private int studentID;
    private String studentName;
    private float knowledgePoint;
    private float practicePoint;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public float getKnowledgePoint() {
        return knowledgePoint;
    }

    public void setKnowledgePoint(float knowledgePoint) {
        this.knowledgePoint = knowledgePoint;
    }

    public float getPracticePoint() {
        return practicePoint;
    }

    public void setPracticePoint(float practicePoint) {
        this.practicePoint = practicePoint;
    }

    public float getAveragePoint() {
        return (this.knowledgePoint + this.practicePoint*2)/3;
    }

    private void showStudentInfo(){
        System.out.println("*************************************************");
        System.out.println("Student ID = " + getStudentID());
        System.out.println("Student Name = " + getStudentName());
        System.out.println("Student Knowleage Point = " + getKnowledgePoint());
        System.out.println("Student Practice Point = " + getPracticePoint());
        System.out.println("Student Average Point = " + getAveragePoint());
        System.out.println("*************************************************");
    }

    public static void main(String[] args){
        Topic_01_Class_Object firstStudent = new Topic_01_Class_Object();
        firstStudent.setStudentID(20052006);
        firstStudent.setStudentName("Nguyen Van A");
        firstStudent.setKnowledgePoint(8.0f);
        firstStudent.setPracticePoint(9.0f);
        firstStudent.showStudentInfo();
    }
}
