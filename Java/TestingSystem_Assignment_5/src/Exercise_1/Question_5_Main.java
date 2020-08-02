package Exercise_1;

import java.util.Scanner;

public class Question_5_Main {

	public static void main(String[] args) {
		
		TuyenSinh thiSinh = new TuyenSinh();
		
		Scanner scan = new Scanner(System.in);
		int chon;
		do {
			System.out.println("\n*************************************");
			System.out.println("**       Quản lý tuyển sinh        **");
			System.out.println("*************************************");
			System.out.println("**     1.Thêm mới thí sinh         **");
			System.out.println("**     2.In danh sách thí sinh     **");
			System.out.println("**     3.Tìm kiếm thí sinh         **");
			System.out.println("**     0.Thoát chương trình        **");
			System.out.println("**                                 **");
			System.out.println("*************************************");
			System.out.println("**     Nhập lựa chọn của bạn       **");
			if(scan.hasNextInt()) {
				chon = scan.nextInt();
				switch(chon) {
				case 1:
					thiSinh.themTS();
					break;
				case 2:
					thiSinh.inThiSinh();
					break;
				case 3:
					thiSinh.timThiSinh();
					break;
				case 0:
					System.out.println("Đã thoát chương trình thành công!");
					break;
				default:
					System.out.println("Không có lựa chọn này. Nhập lại !");
					break;
				}
			}
			else {
				System.out.println("Vui lòng chỉ nhập số! Chạy lại");
				return;
			}

		}while(chon != 0);
	}

}
