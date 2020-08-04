package entity;

public class HinhChuNhat extends HinhHoc implements CongThucTinh {

	private float chieuDai;
	private float chieuRong;
	
	
	public HinhChuNhat(float chieuDai, float chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	@Override
	public void tinhChuVi() {
		super.tinhChuVi();
		float chuVi = 2 * this.chieuDai + 2 * this.chieuRong;
		System.out.printf("Chu vi hinh chu nhat la: %.4f %n", chuVi);
	}

	@Override
	public void tinhDienTich() {
		super.tinhDienTich();
		float dienTich = this.chieuDai * this.chieuRong;
		System.out.printf("Dien tich hinh chu nhat la: %.4f %n", dienTich);
	}

}
