package Exercise_1;

public class ThiSinh {
	private int sbd;
	private String hoTen;
	private String diaChi;
	private byte mucUuTien;
	
	public int getSbd() {
		return sbd;
	}

	public String getHoTen() {
		return hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public byte getMucUuTien() {
		return mucUuTien;
	}

	public void setSbd(int sbd) {
		this.sbd = sbd;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public void setMucUuTien(byte mucUuTien) {
		this.mucUuTien = mucUuTien;
	}

	public ThiSinh(int sbd, String hoTen, String diaChi, byte mucUuTien) {
		super();
		this.sbd = sbd;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.mucUuTien = mucUuTien;
	}
	
	public void inThiSinh() {
		System.out.println("----------------------");
		System.out.println("SBD		: "+this.sbd);
		System.out.println("Họ tên		: "+ this.hoTen);
		System.out.println("Địa chỉ		: "+this.diaChi);
		System.out.println("Mức ưu tiên	: "+this.mucUuTien);
	}
}
