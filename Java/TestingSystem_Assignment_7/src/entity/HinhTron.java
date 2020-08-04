package entity;

public class HinhTron extends HinhHoc implements CongThucTinh {

	private float banKinh;
	private static float soPi = (float) Math.PI;
	
	public HinhTron(float banKinh) {
		super();
		this.banKinh = banKinh;
	}

	@Override
	public void tinhChuVi() {
		super.tinhChuVi();
		float chuVi = 2 * soPi * this.banKinh;
		System.out.printf("Chu vi hinh tron la: %.4f %n", chuVi);
	}

	@Override
	public void tinhDienTich() {
		super.tinhDienTich();
		float dienTich = soPi * this.banKinh * this.banKinh;
		System.out.printf("Dien tich hinh tron la: %.4f %n", dienTich);
	}

}
