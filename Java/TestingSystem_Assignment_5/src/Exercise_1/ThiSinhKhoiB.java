package Exercise_1;

public class ThiSinhKhoiB extends ThiSinh implements ITuyenSinh {

	public ThiSinhKhoiB(int sbd, String hoTen, String diaChi, byte mucUuTien) {
		super(sbd, hoTen, diaChi, mucUuTien);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void thongTinKhoi() {
		System.out.println("Thí sinh thi khối B thi các môn: Toán, Hoá, Sinh");
	}
	
	public void inThiSinh() {
		super.inThiSinh();
		thongTinKhoi();
	}
}
