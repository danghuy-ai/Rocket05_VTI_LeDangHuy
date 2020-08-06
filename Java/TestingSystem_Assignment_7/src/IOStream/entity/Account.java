package IOStream.entity;

import java.io.Serializable;
import java.time.LocalDate;

import IOStream.ScannerUtils;

public class Account implements Serializable {
	
	private static final long serialVersionUID = -7904772897854032431L;
	
	private String userName;
	private String passWord;
	private TypeAccount typeAcc;
	private float tien;
	private ThongTinLoDe[] loDe = { };
	
	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public TypeAccount getTypeAcc() {
		return typeAcc;
	}
	
	public float getTien() {
		return tien;
	}

	public void setTien(float tien) {
		this.tien += tien;
	}

	public ThongTinLoDe[] getLoDe() {
		return loDe;
	}

	public void setLoDe(ThongTinLoDe loDe) {
		this.loDe = insert(this.loDe, loDe);
	}

	public Account() {
		this.userName = inputName();
		this.passWord = inputPass();
		this.typeAcc = inputTypeAcc();
	}
	
	private static ThongTinLoDe[] insert(ThongTinLoDe[] loDeOfAccount, ThongTinLoDe conLoDep) {
		int arrIndex = loDeOfAccount.length - 1;
        int tempIndex = loDeOfAccount.length;
        ThongTinLoDe [] tempArr = new ThongTinLoDe [tempIndex + 1];
         
        for (int i = tempIndex; i >= 0; i--) {
            if (arrIndex > -1) {
                tempArr[i] = loDeOfAccount[arrIndex--];
            } 
            else {
                tempArr[i] = conLoDep;
            }
        }
        return tempArr;
	}
	
	private String inputName() {
		System.out.println("Nhập tên tài khoản: ");
		String name = ScannerUtils.inputString("Chưa nhập, nhập lại: ");
		return name;
	}

	private String inputPass() {
		System.out.println("Nhập mật khẩu: ");
		String pass = ScannerUtils.inputString("Chưa nhập, nhập lại: ");
		return pass;
	}
	
	private TypeAccount inputTypeAcc() {
		TypeAccount typeAcc = null;
		boolean ktra = false;
		
		System.out.println("Nhập loại tài khoản (1-Admin; 0-User) : ");
		int chon = ScannerUtils.inputInt("Không có lựa chọn này, nhập lại: ");
		
		while (ktra == false) {
			
			if(chon == 1) {
				typeAcc = TypeAccount.ADMIN;
				ktra = true;
			}
			else if (chon == 0) {
				typeAcc = TypeAccount.USER;
				ktra = true;
			}
			else {
				System.err.println("Không có lựa chọn này, nhập lại!");
				chon = ScannerUtils.inputInt("Không có lựa chọn này, nhập lại: ");
			}
		}
		return typeAcc;
	}
	
	public void inThongTinAcc() {
		System.out.println("Tên đăng nhập: " + this.userName);
		System.out.println("Loại tài khoản: " +this.typeAcc);
		System.out.println("Số dư tiền: " +this.tien+" VNĐ");
		System.out.print("Thông tin các lô đề đã chơi: ");
		if(this.loDe.length > 0) {
			for (ThongTinLoDe lo : this.loDe) {
				System.out.print(ScannerUtils.convertLocalDateToString(lo.getDate()) + " *" +lo.getMaLo()  +  "; ");
			}
			System.out.println("");
		}
		else
			System.out.println("Chưa có đánh con lô nào:((");
	}
	
	public void inThongTinMenu() {
		if(this.getTypeAcc() == TypeAccount.ADMIN) {
			System.out.println("	Tên đăng nhập: " + this.userName);
			System.out.println("	Loại tài khoản: " +this.typeAcc);
		}
		else {
			System.out.println("	Tên đăng nhập: " + this.userName);
			System.out.println("	Loại tài khoản: " +this.typeAcc);
			System.out.println("	Số dư tiền: " +this.tien+" VNĐ");
			System.out.println("	Các con lô đánh hôm nay: ");
			System.out.print("		");
			
			try {
				for (ThongTinLoDe lo : this.loDe) {
					if (lo.getDate().isEqual(LocalDate.now())) {
						System.out.print(lo.getMaLo() + " - ");
					}
				}
				System.out.println("");
				
			} catch (NullPointerException e) {
				System.err.println("	Hôm nay đồng chí chưa chơi con nào!");
			}
		}
	}
}
