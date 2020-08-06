package IOStream.frontend;

import IOStream.ScannerUtils;
import IOStream.utils.IOManager;

public class Program {

	public static void main(String[] args) {
			//Exercise 5
		//Question 1
		IOManager iom = new IOManager();
		int chon;
		
		do {
			System.out.println("\n*******************************************");
			System.out.println("**          Quản lý học sinh             **");
			System.out.println("*******************************************");
			System.out.println("**     1.Thêm mới học sinh               **");
			System.out.println("**     2.Hiển thị danh sách học sinh     **");
			System.out.println("**     3.Xuất danh sách học sinh         **");
			System.out.println("**     4.Nhập danh sách học sinh         **");
			System.out.println("**     0.Thoát chương trình              **");
			System.out.println("**                                       **");
			System.out.println("*******************************************");
			System.out.println("**     Nhập lựa chọn của bạn             **");
			chon = ScannerUtils.inputInt("Vui lòng nhập vào một số. Nhập lại!");
			switch(chon) {
			case 1:
				iom.inputStudent();
				break;
			case 2:
				iom.hienThiStudent();
				break;
			case 3:
				iom.xuatDSStudent();
				break;
			case 4:
				iom.nhapDSStudent();
				break;
			case 0:
				System.out.println("Đã thoát chương trình thành công!");
				break;
			default:
				System.err.println("Không có lựa chọn này. Nhập lại !");
				break;
			}
		} while(chon != 0);
	}

}
