package backend;

import java.util.LinkedList;
import java.util.Queue;

public class Exercise1 {
	public void Queston2() {
		Queue<String> name = new LinkedList<>();
		
		name.add("Nguyễn Văn Nam");
		name.add("Nguyễn Văn Huyên");
		name.add("Trần Văn Nam");
		name.add("Nguyễn Văn A");
		
		
		System.out.println("Thứ tự tới của các học sinh theo thứ tự sớm nhất tới muộn nhất: ");
		int sum = name.size();
		for(int i=0; i < sum; i++) {
			System.out.println((i+1) + ". " + name.poll());
		}
	}
}
