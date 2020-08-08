package backend;

import java.util.Stack;

public class Exercise1 {
	public void Queston2() {
		Stack<String> name = new Stack<>();
		
		name.push("Nguyễn Văn A");
		name.push("Trần Văn Nam");
		name.push("Nguyễn Văn Huyên");
		name.push("Nguyễn Văn Nam");
		
		System.out.println("Thứ tự tới của các học sinh theo thứ tự sớm nhất tới muộn nhất: ");
		int sum = name.size();
		for(int i=0; i < sum; i++) {
			System.out.println((i+1) + ". " + name.pop());
		}
	}
}
