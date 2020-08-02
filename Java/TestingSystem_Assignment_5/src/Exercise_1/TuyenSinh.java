package Exercise_1;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh {
	private ArrayList<ThiSinh> thiSinh;
	
	public TuyenSinh() {
		thiSinh = new ArrayList<ThiSinh>();
	}
	
	public void themTS() {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		System.out.println("Nhập số lượng thí sinh muốn thêm mới: ");
		n = scanner.nextInt();
		
		String khoi = "";
		for(int i = 0; i < n; i++) {
			System.out.println("Lựa chọn khối thi thí sinh thứ "+(i+1)+" ( A - B - C ): ");
			khoi = scanner.next();
			
			int sbd;
			String name, diaChi;
			byte mut;
			
			switch(khoi) {
			case "A":
				System.out.println("Nhập SBD: ");
				sbd = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Nhập tên thí sinh: ");
				name = scanner.nextLine();
				System.out.println("Nhập địa chỉ: ");
				diaChi = scanner.nextLine();
				System.out.println("Nhập mức ưu tiên: ");
				mut = scanner.nextByte();
				thiSinh.add(new ThiSinhKhoiA(sbd, name, diaChi, mut));
				break;
			case "B":
				System.out.println("Nhập SBD: ");
				sbd = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Nhập tên thí sinh: ");
				name = scanner.nextLine();
				System.out.println("Nhập địa chỉ: ");
				diaChi = scanner.nextLine();
				System.out.println("Nhập mức ưu tiên: ");
				mut = scanner.nextByte();
				thiSinh.add(new ThiSinhKhoiB(sbd, name, diaChi, mut));
				break;
			case "C":
				System.out.println("Nhập SBD: ");
				sbd = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Nhập tên thí sinh: ");
				name = scanner.nextLine();
				System.out.println("Nhập địa chỉ: ");
				diaChi = scanner.nextLine();
				System.out.println("Nhập mức ưu tiên: ");
				mut = scanner.nextByte();
				thiSinh.add(new ThiSinhKhoiC(sbd, name, diaChi, mut));
				break;
			default:
				System.out.println("Nhập sai. Lựa chọn lại khối thi có sẵn!!");
				i--;
				break;
			}
		}
		
	}
	
	public void inThiSinh() {
		System.out.println("\n--Danh sách thông tin các thí sinh--");
		for(int i=0; i<thiSinh.size(); i++) {
			thiSinh.get(i).inThiSinh();
		}
	}
	
	public void timThiSinh() {
		Scanner scanner = new Scanner(System.in);
		int sbd;
		int dem=0;
		boolean ktra = false;
		
		System.out.println("Nhập số báo danh thí sinh muốn tìm kiếm: ");
		if (scanner.hasNextInt()) {
			sbd = scanner.nextInt();
		}
		else {
			System.out.println("Vui lòng nhập số. Nhập lại!");
			return;
		}
		
		for(int i=0; i<thiSinh.size(); i++) {
			if (thiSinh.get(i).getSbd()==sbd) {
				thiSinh.get(i).inThiSinh();
				ktra = true;
				dem++;
			}
		}
		if(!ktra) {
			System.out.println("Không có thí sinh ứng với số báo danh - "+sbd);
		}
		System.out.println(" -- "+dem+" kết quả tìm kiếm!");
	}
}
