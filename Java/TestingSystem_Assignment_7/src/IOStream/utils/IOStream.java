package IOStream.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOStream {
		public static void writeObject(Object object, String path) throws Exception {

			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			
			try {
				// nếu file chưa lưu object nào thì ghi bình thường
//				if (!hasObject(path)) {
					fos = new FileOutputStream(path);
					oos = new ObjectOutputStream(fos);
//				} else {
//					fos = new FileOutputStream(path, true);
//					oos = new ObjectOutputStream(fos) {
//						@Override
//						protected void writeStreamHeader() throws IOException {
//							reset();
//						}
//					};
//				}

				oos.writeObject(object);

			} finally {
				fos.close();
				oos.close();
			}
		}

		public static Object readObject(String path, String message) throws Exception {
			
			if (!new File(path).exists()) {
				throw new Exception(message);
			}
			
			if (!hasObject(path)) {
				System.err.println("File chưa có dữ liệu nào!");
			}
				
			FileInputStream fis = null;
			ObjectInputStream ois = null;

			try {
				fis = new FileInputStream(new File(path));
				ois = new ObjectInputStream(fis);

				return ois.readObject();

			} finally {
				fis.close();
				ois.close();
			}
		}
		
		private static boolean hasObject(String filePath) {
			FileInputStream fi;
			boolean check = true;
			try {
				fi = new FileInputStream(filePath);
				ObjectInputStream inStream = new ObjectInputStream(fi);
				if (inStream.readObject() == null) {
					check = false;
				}
				inStream.close();
			} catch (FileNotFoundException e) {
				check = false;
			} catch (IOException e) {
				check = false;
			} catch (ClassNotFoundException e) {
				check = false;
				e.printStackTrace();
			}
			return check;
		}
}
