import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
System.out.println("Welcome to Student Management App");
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
while(true) {
	System.out.println("Press 1 to Add Student");
	System.out.println("Press 2 to Delete Student");
	System.out.println("Press 3 to Display Student");
	System.out.println("Press 4 to Exit App");
	int c = Integer.parseInt(br.readLine());
	
	if(c==1) {
		//Add Student
		System.out.println("Enter Student Name :");
		String name = br.readLine();
		
		System.out.println("Enter Student Phone :");
		String phone = br.readLine();
		
		System.out.println("Enter Student City :");
		String city = br.readLine();
		
		//Create Student Object to store student
		Student st = new Student(name, phone, city);
		boolean answer = StudentDao.insertStudentToDB(st);
		if(answer) {
			System.out.println("Student is Added Successfully.....");
		}
		else {
			System.out.println("Something Went Wrong !!");
		}
		System.out.println(st);
	}
	else if (c==2) {
		//Delete Student
		System.out.println("Enter Student Id to Delete");
		int userId = Integer.parseInt(br.readLine());
		boolean f = StudentDao.deleteStudent(userId);
		if(f) {
			System.out.println("Student is Deleted Successfully.....");
		}else {
			System.out.println("Something went Wrong !!!");
		}
		
	}
else if (c==3) {
		//Display Student
	StudentDao.showAllStudent();
	}
else if (c==4) {
	//Exit App
	break;
}
else{
	
}
	
}
System.out.println("Thank you for using my application");
	}

}
