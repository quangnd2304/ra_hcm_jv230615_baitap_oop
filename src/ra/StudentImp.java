package ra;

import java.util.Scanner;

public class StudentImp {
    public static void main(String[] args) {
        Student[] arrStudent = new Student[100];
        //Chỉ số lớn nhất của mảng đã lưu trữ sinh viên
        int currentIndex = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*******************MENU***************************");
            System.out.println("1. Nhập vào thông tin các sinh viên");
            System.out.println("2. Tính điểm trung bình sinh viên");
            System.out.println("3. Hiển thị thông tin sinh viên");
            System.out.println("4. Sắp xếp sinh viên theo điểm trung bình giảm dần");
            System.out.println("5. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.print("Sự lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào số sinh viên cần nhập dữ liệu:");
                    int cntStudent = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < cntStudent; i++) {
                        //Nhập thông tin cho sinh viên thứ i
                        System.out.printf("**************NHẬP THÔNG TIN SINH VIÊN %d:*************\n", (i + 1));
                        //Khởi tạo phần tử arrStudent[i] là đối tuợng sinh viên
                        arrStudent[currentIndex] = new Student();
                        //Nhập dữ liệu cho sinh viên i
                        arrStudent[currentIndex].inputData(scanner);
                        currentIndex++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < currentIndex; i++) {
                        arrStudent[i].calAvgScore();
                    }
                    break;
                case 3:
                    System.out.println("************THÔNG TIN CÁC SINH VIÊN*************");
                    for (int i = 0; i < currentIndex; i++) {
                        arrStudent[i].displayData();
                    }
                    break;
                case 4:
                    for (int i = 0; i < currentIndex-1; i++) {
                        for (int j = i+1; j < currentIndex; j++) {
                            if (arrStudent[i].getAvgScore()<arrStudent[j].getAvgScore()){
                                //Đổi chỗ phần tử i và j
                                Student temp = arrStudent[i];
                                arrStudent[i] = arrStudent[j];
                                arrStudent[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp sinh viên theo điểm trung bình giảm dần");
                    break;
                case 5:
                    System.out.println("Nhập vào tên sinh viên cần tìm kiếm:");
                    String studentNameSearch = scanner.nextLine();
                    int cntStudentSearch = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (arrStudent[i].getStudentName().toLowerCase().contains(studentNameSearch.toLowerCase())){
                            arrStudent[i].displayData();
                            cntStudentSearch++;
                        }
                    }
                    if (cntStudentSearch==0){
                        System.out.println("Không tìm thấy sinh viên nào có chứa tên như vậy");
                    }else{
                        System.out.println("Tìm thấy "+cntStudentSearch+" sinh viên");
                    }
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-6");
            }
        } while (true);
    }
}
