package Exercise_2;

public class Phone implements Weapons{
	
	public void nghe() {
		System.out.println("Nghe");
	}
	
	public void goi() {
		System.out.println("Goi");
	}
	
	public void guiTinNhan() {
		System.out.println("Gui Tin Nhan");
	}
	
	public void nhanTinNhan() {
		System.out.println("Nhan Tin Nhan");
	}
	
	@Override
	public void KillEnemy() {
		System.out.println();
	}
}
