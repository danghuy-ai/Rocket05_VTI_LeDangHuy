package Exercise_1;

public class ThiSinhKhoiA extends ThiSinh implements ITuyenSinh {

	public ThiSinhKhoiA(int sbd, String hoTen, String diaChi, byte mucUuTien) {
		super(sbd, hoTen, diaChi, mucUuTien);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void thongTinKhoi() {
		System.out.println("Thí sinh thi khối A thi các môn: Toán, Lý, Hoá");
	}
	
	public void inThiSinh() {
		super.inThiSinh();
		thongTinKhoi();
	}
}
