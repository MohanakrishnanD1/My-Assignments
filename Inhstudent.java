package week3.day2;

public class Inhstudent  extends inhdepartment {

	public void studentname() {
		System.out.println("name : MOHAN");
	}
	public void studentdep() {
		System.out.println("dep : EEE");
	}
	public void studentid() {
		System.out.println("1141010");
	}
	public static void main(String[] args) {
		Inhstudent details=new Inhstudent ();
		details.collegename();
		details.collegecode();
		details.departmentname();
		details.studentname();
		details.studentdep();
		details.studentid();
		
	}
	
}