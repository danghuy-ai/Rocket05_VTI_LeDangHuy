package IOStream.entity;

import java.io.Serializable;
import java.time.LocalDate;

import IOStream.ScannerUtils;

public class ThongTinLoDe implements Serializable {
	
	private static final long serialVersionUID = 3702717828943006526L;
	
	private String maLo;
	private LocalDate date;
	private boolean anGiai;
	
	public ThongTinLoDe() {
		this.maLo = inputMaLo();
		this.date = inputDate();
		this.anGiai = inputAnGiai();
	}
	
	public String getMaLo() {
		return maLo;
	}

	public void setMaLo(String maLo) {
		this.maLo = maLo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}	
	
	public boolean isAnGiai() {
		return anGiai;
	}

	public void setAnGiai(boolean anGiai) {
		this.anGiai = anGiai;
	}
	
	private String inputMaLo() {
		System.out.println("Nhập mã số lô: ");
		String name = ScannerUtils.inputString("Chưa nhập, nhập lại: ");
		return name;
	}
	
	private LocalDate inputDate() {
		System.out.println("Ngày giá trị của con lô (dd-MM-yyyy): ");
		LocalDate date = ScannerUtils.inputLocalDate();
		return date;
	}
	
	private boolean inputAnGiai() {
		boolean giai = false;
		boolean ktra = false;
		
		System.out.println("Nhập giải cho số lô (1-Trúng; 0-Xịt) : ");
		int chon = ScannerUtils.inputInt("Không có lựa chọn này, nhập lại!");
		
		while (ktra == false) {
			if(chon == 1) {
				giai = true;
				ktra = true;
			}
			else if (chon == 0) {
				ktra = true;
			}
			else {
				System.err.println("Không có lựa chọn này, nhập lại!");
				chon = ScannerUtils.inputInt("Không có lựa chọn này, nhập lại!");
			}
		}
		
		return giai;
	}
	
	public String toStringAdmin() {
		
		String str = "";
		if(this.anGiai) {
			str = " - ***Ăn giải rồi***";
		}
		else
			str = " - Chúc bạn may mắn lần sau!";
		
		return " - Ngày " + ScannerUtils.convertLocalDateToString(this.date) + " - Số lô: " + this.maLo + str;
	}
	
	public String toStringUser() {
		
		String str = "";
		String xuatStr = "";
		
		if(this.anGiai) {
			str = " - ***Ăn giải rồi***";
		}
		else
			str = " - Chúc bạn may mắn lần sau!";
		
		if (this.date.isEqual(LocalDate.now()) || this.date.isAfter(LocalDate.now()))
			xuatStr = " - Ngày " + ScannerUtils.convertLocalDateToString(this.date) + " - Số lô: " + this.maLo + " - Chưa công bố giải!";
		else
			xuatStr = " - Ngày " + ScannerUtils.convertLocalDateToString(this.date) + " - Số lô: " + this.maLo + str;
		
		return xuatStr;
	}
}
