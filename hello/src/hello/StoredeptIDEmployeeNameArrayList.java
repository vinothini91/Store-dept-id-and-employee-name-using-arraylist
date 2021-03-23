package hello;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import static java.nio.file.StandardOpenOption.APPEND;

public class StoredeptIDEmployeeNameArrayList {

	public static void main(String[] args) {

		File file = new File("F:/vino--programs-2021/idname.txt");
		Path path = Paths.get(file.toString());
		try {
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
			BufferedReader reader = new BufferedReader(new FileReader(file));

			ArrayList<Department> department = new ArrayList<Department>();

			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] nameid = line.split(" ");

				String deptname = nameid[0];
				String empname = nameid[1];

				department.add(new Department(deptname, empname));

				Collections.sort(department, new DepartmentIdComparator());

			}

			System.out.println("ArrayList:" + department);
			OutputStream student_overwrite = new BufferedOutputStream(Files.newOutputStream(path)); // overwrite in existing file
																	
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			for (Department deptdetail : department) {
				writer.write(deptdetail.id);
				writer.write(" " + deptdetail.name);
				writer.write("\n");

			}

			writer.close();

			InputStream input = Files.newInputStream(path);
			BufferedReader student_read = new BufferedReader(new InputStreamReader(input));

			String student_line = null;
			System.out.println("READ NEW STUDENT RECORD:");
			while ((student_line = student_read.readLine()) != null) {
				System.out.println(student_line);

			}
			student_read.close();
		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}

}
