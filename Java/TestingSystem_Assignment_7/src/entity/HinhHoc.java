package entity;

public class HinhHoc implements CongThucTinh{
	private static int soLuongHinh;
	
	HinhHoc(){
		soLuongHinh++;
		if (this.soLuongHinh > 5) {
			throw new HinhHocException("So luong hinh toi da la: " + Configs.getSO_LUONG_HINH_TOI_DA());
		}
	}

	public static int getSoLuongHinh() {
		return soLuongHinh;
	}

	public static void setSoLuongHinh(int soLuongHinh) {
		HinhHoc.soLuongHinh = soLuongHinh;
	}

	@Override
	public void tinhChuVi() {
		
	}

	@Override
	public void tinhDienTich() {
		
	}
	
	
}
