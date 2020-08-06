package IOStream.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import IOStream.ScannerUtils;
import IOStream.entity.Account;
import IOStream.entity.Student;
import IOStream.entity.ThongTinLoDe;
import IOStream.entity.TypeAccount;

public class IOManager {
		//Exercise 5
	//Question 1
	private ArrayList<Student> students;
	private ArrayList<Account> accounts;
	private ArrayList<ThongTinLoDe> loDes;
	
	public IOManager(){
		students = new ArrayList<Student>();
		accounts = new ArrayList<Account>();
		loDes = new ArrayList<ThongTinLoDe>();
		nhapDSAccount();
		nhapDSLoDe();
	}
	
	public void inputStudent() {
		System.out.println("Nhập vào số lượng học sinh muốn khởi tạo");
		int n = ScannerUtils.inputInt("Vui lòng nhập vào 1 số. Nhập lại!");
		
		for (int i=0; i<n; i++) {
			students.add(new Student());
		}
	}
	
	public void hienThiStudent() {
		for (int i=0; i<students.size(); i++) {
			System.out.println("--Student "+(i+1)+"--");
			System.out.println(students.get(i).toString());
		}
	}
	
	public void xuatDSStudent() {
		try {
			IOStream.writeObject(students, "StudentInformation.txt");
			System.out.println("Xuất file danh sách học sinh thành công!");
		} catch (Exception e) {
			System.err.println("Xuất file có lỗi. Thử lại!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void nhapDSStudent() {
		try {
			students = (ArrayList<Student>) IOStream.readObject("StudentInformation.txt","Không tồn tại file chứa DS Student");
			System.out.println("Nhập file danh sách học sinh thành công!");
			hienThiStudent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xuatDSAccount() {
		try {
			IOStream.writeObject(accounts, "AccountsInformation.txt");
			System.out.println("Đã cập nhật vào danh sách tài khoản!");
		} catch (Exception e) {
			System.err.println("Xuất file có lỗi. Thử lại!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void nhapDSAccount() {
		try {
			accounts = (ArrayList<Account>) IOStream.readObject("AccountsInformation.txt","Chưa tồn tại danh sách tài khoản!");
			System.out.println("Nhập file danh sách tài khoản thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xuatDSLoDe() {
		try {
			IOStream.writeObject(loDes, "LoDesInformation.txt");
			System.out.println("Đã cập nhật vào danh sách các số lô!");
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println("Xuất file có lỗi. Thử lại!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void nhapDSLoDe() {
		try {
			loDes = (ArrayList<ThongTinLoDe>) IOStream.readObject("LoDesInformation.txt","Chưa tồn tại danh sách số lô đề!");
			System.out.println("Nhập file danh sách số lô đề thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dangKyAcc() {
		boolean ktra = false;
		System.out.println("Nhập thông tin tạo tài khoản mới:");
		
		while(!ktra) {
			boolean userDeplicate = false;
			Account acc = new Account();
			for (int i=0; i<accounts.size(); i++) {
				if(accounts.get(i).getUserName().equals(acc.getUserName())) {
					userDeplicate = true;
				}
			}
			if(userDeplicate) {
				System.err.println("Tên đăng nhập này đã được sử dụng. Chọn tên đăng nhập khác!");
			}
			else {
				accounts.add(acc);
				System.out.println("Đăng ký tài khoản thành công!");
				ktra = true;
			}
		}
		
		xuatDSAccount();
	}
	
	public void dangNhapAcc() {
		System.out.println("-- Đăng nhập tài khoản --");
		System.out.println("Tên đăng nhập: ");
		String tenDN = ScannerUtils.inputString("Chưa nhập, nhập lại!");
		System.out.println("Mật khẩu: ");
		String matKhau = ScannerUtils.inputString("Chưa nhập, nhập lại!");
		
		checkDangNhap(tenDN, matKhau);
	}
	
	private void checkDangNhap(String ten, String pass) {
		boolean check = false;
		Account acc = null;
		for (int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getUserName().equals(ten) && accounts.get(i).getPassWord().equals(pass)) {
				check = true;
				acc = accounts.get(i);
			}
		}
		if(!check) {
			System.err.println("Tên đăng nhập hoặc mật khẩu nhâp sai. Nhâp lại!\n");
			dangNhapAcc();
		}
		else {
			System.out.println("Đăng nhập thành công!");
			menu(acc);
		}
	}
	
	private void napTienTK(Account acc) {
		System.out.println("Nhập số tiền nạp vào tài khoản: ");
		float tien = ScannerUtils.inputFloat("Số tiền không hợp lệ. Kiểm tra lại!");
		acc.setTien(tien);
		xuatDSAccount();
		System.out.println("Nạp tiền thành công. Kiểm tra lại số dư mới!");
	}
	
	private void themSoLo() {
		System.out.println("Nhập vào số lượng lô đề muốn tạo");
		int n = ScannerUtils.inputInt("Vui lòng nhập vào 1 số. Nhập lại!");
		
		for (int i=0; i<n; i++) {
			loDes.add(new ThongTinLoDe());
		}
		
		//Sắp xếp danh sách theo ngày tăng dần
        Collections.sort(loDes, new Comparator<ThongTinLoDe>() {
            @Override
            public int compare(ThongTinLoDe ld1, ThongTinLoDe ld2) {
                if (ld1.getDate().isAfter(ld2.getDate())) {
                    return 1;
                } else {
                    if (ld1.getDate().isEqual(ld2.getDate())) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            }
        });
		
		xuatDSLoDe();
	}
	
	private void checkSoLoTrongNgay(Account acc) {
		ArrayList<ThongTinLoDe> loDeNgay = new ArrayList<ThongTinLoDe>();
		System.out.println("Nhập vào ngày muốn check (dd-MM-yyyy): ");
		LocalDate date = ScannerUtils.inputLocalDate();
		
		for (int i=0; i<loDes.size(); i++) {
			if(loDes.get(i).getDate().isEqual(date)) {
				loDeNgay.add(loDes.get(i));
			}
		}
		if(loDeNgay.size() == 0) {
			System.out.println("Không có số lô nào trong ngày " + ScannerUtils.convertLocalDateToString(date));
		}
		else {
			System.out.println("Có " + loDeNgay.size() + " số lô trong ngày " + ScannerUtils.convertLocalDateToString(date));
			if (acc.getTypeAcc() == TypeAccount.ADMIN) {
				for (int i=0; i<loDeNgay.size(); i++) {
					System.out.println(loDeNgay.get(i).toStringAdmin());
				}
			}
			else {
				for (int i=0; i<loDeNgay.size(); i++) {
					System.out.println(loDeNgay.get(i).toStringUser());
				}
			}
		}
	}
	
	private void checkSoLoTuNgayDenNgay(Account acc) {
		ArrayList<ThongTinLoDe> loDeNgay = new ArrayList<ThongTinLoDe>();
		System.out.println("Nhập vào ngày bắt đầu (dd-MM-yyyy): ");
		LocalDate fromDate = ScannerUtils.inputLocalDate();
		System.out.println("Nhập vào ngày đến (dd-MM-yyyy): ");
		LocalDate toDate = ScannerUtils.inputLocalDate();
		
		for (int i=0; i<loDes.size(); i++) {
			if((loDes.get(i).getDate().isAfter(fromDate) && loDes.get(i).getDate().isBefore(toDate)) || loDes.get(i).getDate().isEqual(toDate) || loDes.get(i).getDate().isEqual(fromDate)) {
				loDeNgay.add(loDes.get(i));
			}
		}
		
		if(loDeNgay.size() == 0) {
			System.out.println("Không có số lô nào trong khoảng từ ngày " + ScannerUtils.convertLocalDateToString(fromDate) + " đến ngày " + ScannerUtils.convertLocalDateToString(toDate));
		}
		else {
			System.out.println("Có " + loDeNgay.size() + " số lô trong khoảng từ ngày " + ScannerUtils.convertLocalDateToString(fromDate) + " đến ngày " + ScannerUtils.convertLocalDateToString(toDate));
			if (acc.getTypeAcc() == TypeAccount.ADMIN) {
				for (int i=0; i<loDeNgay.size(); i++) {
					System.out.println(loDeNgay.get(i).toStringAdmin());
				}
			}
			else {
				for (int i=0; i<loDeNgay.size(); i++) {
					System.out.println(loDeNgay.get(i).toStringUser());
				}
			}
		}
	}
	
	private void choiLoDe(Account acc) {
		
		ArrayList<ThongTinLoDe> loDeNgay = new ArrayList<ThongTinLoDe>();
		
		for (int i=0; i<loDes.size(); i++) {
			if(loDes.get(i).getDate().isEqual(LocalDate.now())) {
				loDeNgay.add(loDes.get(i));
			}
		}
		
		System.out.println("-- Những con lô may rủi đổi đời ngày hôm nay " + LocalDate.now() + " --");
		if(loDeNgay.size() == 0) {
			System.out.println(" Nhà cái chưa phát số cho ngày hôm nay. Quay lại sau nhé người anh em :v");
		}
		else {
			for (int i=0; i<loDeNgay.size(); i++) {
				System.out.print("Con lô số " + (i+1) + " : ");
				System.out.println(loDeNgay.get(i).getMaLo());
			}
		}
		
		boolean ktra = false;
		System.out.print("Nhập con lô bạn muốn đánh: ");
		int chon = ScannerUtils.inputInt("Không có con lô số này, nhập lại!");
		
		while (ktra == false) {
			if(chon>0 && chon<=loDeNgay.size()) {
				acc.setLoDe(loDeNgay.get(chon-1));
				for(int i=0; i<accounts.size(); i++) {
					if (accounts.get(i).getUserName() == acc.getUserName()) {
						accounts.set(i, acc);
					}
				}
				ktra = true;
			}
			else {
				System.err.println("Không có con lô số này, nhập lại!");
				chon = ScannerUtils.inputInt("Không có con lô số này, nhập lại!");
			}
		}
		System.out.println("Chọn thành công! Mã con lô bạn vừa chọn là: " + loDeNgay.get(chon-1).getMaLo());
		xuatDSAccount();
		
	}
	
	private void menu(Account acc) {
		if(acc.getTypeAcc() == TypeAccount.ADMIN) {
			menuAdmin(acc);
		}
		else {
			menuUser(acc);
		}
	}
	
	private void menuAdmin(Account acc) {
		int chon;
		
		do {
			System.out.println("\n***********************************************");
			System.out.println("**           Quản lý anh em đánh đề          **");
			System.out.println("***********************************************");
			acc.inThongTinMenu();
			System.out.println("**                                           **");
			System.out.println("**        1. Thêm các số lô                  **");
			System.out.println("**        2. Check số lô theo ngày           **");
			System.out.println("**        3. Thông tin các tài khoản         **");
			System.out.println("**        0. Đăng xuất tài khoản             **");
			System.out.println("**                                           **");
			System.out.println("***********************************************");
			System.out.println("**       Nhập lựa chọn của bạn               **");
			chon = ScannerUtils.inputInt("Vui lòng nhập vào một số. Nhập lại!");
			switch(chon) {
			case 1:
				themSoLo();
				break;
			case 2:
				menuCheckLoTheoNgay(acc);
				break;
			case 3:
				for (int i=0; i<accounts.size(); i++) {
					System.out.println("\n-- Account "+(i+1)+" --");
					accounts.get(i).inThongTinAcc();
				}
				break;
			case 0:
				System.out.println("Đăng xuất tài khoản thành công!");
				break;
			default:
				System.err.println("Không có lựa chọn này. Nhập lại !");
				break;
			}
		} while(chon != 0);
	}
	
	private void menuUser(Account acc) {
		int chon;
		
		do {
			System.out.println("\n***********************************************");
			System.out.println("**        Tuyển tập 1001 cách làm giàu       **");
			System.out.println("***********************************************");
			acc.inThongTinMenu();
			System.out.println("**                                           **");
			System.out.println("**        1. Làm con lô nào!!                **");
			System.out.println("**        2. Check số lô theo ngày           **");
			System.out.println("**        3. Nạp tiền vào tài khoản          **");
			System.out.println("**        0. Đăng xuất tài khoản             **");
			System.out.println("**                                           **");
			System.out.println("***********************************************");
			System.out.println("**       Nhập lựa chọn của bạn               **");
			chon = ScannerUtils.inputInt("Vui lòng nhập vào một số. Nhập lại!");
			switch(chon) {
			case 1:
				choiLoDe(acc);
				break;
			case 2:
				menuCheckLoTheoNgay(acc);
				break;
			case 3:
				napTienTK(acc);
				break;
			case 0:
				System.out.println("Đăng xuất tài khoản thành công!");
				break;
			default:
				System.err.println("Không có lựa chọn này. Nhập lại !");
				break;
			}
		} while(chon != 0);
	}
	
	private void menuCheckLoTheoNgay(Account acc) {
		int chon;
		
		do {
			System.out.println("\n***********************************************");
			System.out.println("**          Tìm kiếm số lô hấp dẫn           **");
			System.out.println("***********************************************");
			System.out.println("**                                           **");
			System.out.println("**        1. Tìm kiếm trong ngày             **");
			System.out.println("**        2. Tìm kiếm từ ngày đên ngày       **");
			System.out.println("**        0. Quay lại                        **");
			System.out.println("**                                           **");
			System.out.println("***********************************************");
			System.out.println("**       Nhập lựa chọn của bạn               **");
			chon = ScannerUtils.inputInt("Vui lòng nhập vào một số. Nhập lại!");
			switch(chon) {
			case 1:
				checkSoLoTrongNgay(acc);
				break;
			case 2:
				checkSoLoTuNgayDenNgay(acc);
				break;
			case 0:
				System.out.println("	Quay lại");
				break;
			default:
				System.err.println("Không có lựa chọn này. Nhập lại !");
				break;
			}
		} while(chon != 0);
	}
	
}
