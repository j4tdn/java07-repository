package ultils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import beans.Customer;
import common.Extension;

public class FileUltils {
	private FileUltils() {

	}

	public static File createFile(String pathname) {
		File file = new File(pathname);
		// create new folder
		File parent = file.getParentFile();

		if (!parent.exists()) {
			parent.mkdirs();
		}

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	public static boolean createFiles(File parent, int n, Extension... extensions) throws IOException {
		boolean isValid = false;

		for (int i = 1; i <= n; i++) {
			String child = "" + i + "." + extensions[new Random().nextInt(extensions.length)].getValue();
			File file = new File(parent, child);
			file.createNewFile();
			if (!file.exists()) {
				isValid = file.createNewFile();
				if (!isValid) {
					return false;
				}
			}
		}

		return isValid;
	}

	public static void write(File file, List<Customer> customers){
		FileWriter fw =null;
		BufferedWriter bw =null;
		try {
			fw = new FileWriter(file,true);
			bw = new BufferedWriter(fw);
			for(Customer customer:customers) {
				bw.write(customer.toString());
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw!=null) bw.close();
				if(fw!=null) fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
