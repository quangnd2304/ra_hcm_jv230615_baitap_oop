package ra;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private float htmlScore;
    private float cssScore;
    private float javascriptScore;
    private float avgScore;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, boolean sex, float htmlScore, float cssScore, float javascriptScore, float avgScore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.htmlScore = htmlScore;
        this.cssScore = cssScore;
        this.javascriptScore = javascriptScore;
        this.avgScore = avgScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getHtmlScore() {
        return htmlScore;
    }

    public void setHtmlScore(float htmlScore) {
        this.htmlScore = htmlScore;
    }

    public float getCssScore() {
        return cssScore;
    }

    public void setCssScore(float cssScore) {
        this.cssScore = cssScore;
    }

    public float getJavascriptScore() {
        return javascriptScore;
    }

    public void setJavascriptScore(float javascriptScore) {
        this.javascriptScore = javascriptScore;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    /**
     * @param scanner output: void
     *                function: input data for student object
     *                author: Nguyễn Duy Quang
     *                created: 2023-09-19
     */
    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào mã sinh viên:");
        this.studentId = scanner.nextLine();
        //Tên sinh viên phải có độ dài từ 6-30 ký tự - Cho nhập vô hạn đến khi nào thỏa mãn điều kiện
        System.out.println("Nhập vào tên sinh viên:");
        boolean isExist = true;
        do {
            this.studentName = scanner.nextLine();
            if (this.studentName.length() >= 6 && this.studentName.length() <= 30) {
                break;
            } else {
                System.err.println("Tên sinh viên phải gồm 6-30 ký tự, vui lòng nhập lại");
            }
        } while (isExist);
        System.out.println("Nhập vào tuổi sinh viên:");
        this.age = Integer.parseInt(scanner.nextLine());
        //Người dùng bắt buộc phải nhập giá trị true/false
        System.out.println("Nhập vào giới tính sinh viên:");
        do {
            String sexString = scanner.nextLine();
            if (sexString.equals("true") || sexString.equals("false")) {
                this.sex = Boolean.parseBoolean(sexString);
                break;
            } else {
                System.err.println("Vui lòng nhập true hoặc false:");
            }
        } while (isExist);
        //Điểm html phải có giá trị trong khoảng 0-10
        System.out.println("Nhập vào điểm html:");
        do {
            this.htmlScore = Float.parseFloat(scanner.nextLine());
            if (htmlScore >= 0 && htmlScore <= 10) {
                break;
            } else {
                System.err.println("Điểm html trong khoảng 0-10, vui lòng nhập lại");
            }
        } while (isExist);
        System.out.println("Nhập vào điểm css:");
        this.cssScore = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào điểm javascript:");
        this.javascriptScore = Float.parseFloat(scanner.nextLine());
    }

    public void displayData() {
        System.out.printf("Mã SV: %s - Tên SV: %s - Tuổi: %d\n", this.studentId, this.studentName, this.age);
        System.out.printf("HTML: %f - CSS: %f - Javascript: %f - AvgScore: %f\n", this.htmlScore, this.cssScore, this.javascriptScore, this.avgScore);
    }

    public void calAvgScore() {
        this.avgScore = (this.htmlScore + this.cssScore + this.javascriptScore) / 3;
    }
}
