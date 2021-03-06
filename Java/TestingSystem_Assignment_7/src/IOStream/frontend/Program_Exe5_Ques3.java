package IOStream.frontend;

import IOStream.ScannerUtils;
import IOStream.utils.IOManager;

public class Program_Exe5_Ques3 {

	public static void main(String[] args) {
		IOManager iom = new IOManager();
		
		int chon;
		
		do {
			System.out.println("\n*******************************************");
			System.out.println("**         Hệ thống đánh lô đề           **");
			System.out.println("*******************************************");
			System.out.println("**                                       **");
			System.out.println("**     1. Đăng nhập tài khoản            **");
			System.out.println("**     2. Đăng ký làm con lô             **");
			System.out.println("**     0.Thoát chương trình              **");
			System.out.println("**                                       **");
			System.out.println("*******************************************");
			System.out.println("**     Nhập lựa chọn của bạn             **");
			chon = ScannerUtils.inputInt("Vui lòng nhập vào một số. Nhập lại!");
			switch(chon) {
			case 1:
				iom.dangNhapAcc();
				break;
			case 2:
				iom.dangKyAcc();
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
