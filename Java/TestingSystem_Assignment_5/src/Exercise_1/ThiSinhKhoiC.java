package Exercise_1;

public class ThiSinhKhoiC extends ThiSinh implements ITuyenSinh {

	public ThiSinhKhoiC(int sbd, String hoTen, String diaChi, byte mucUuTien) {
		super(sbd, hoTen, diaChi, mucUuTien);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void thongTinKhoi() {
		System.out.println("Thí sinh thi khối C thi các môn: Văn, Sử, Địa");
	}
	
	public void inThiSinh() {
		super.inThiSinh();
		thongTinKhoi();
	}
}
