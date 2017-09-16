import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		//@SuppressWarnings("deprecation")
		Student st=new Student(557,"sreekari",new Date(1996,10,15),77.75);
		Student stud=new Student(444,"chandana",new Date(1996,2,23),44.26);
		StudentGroup sg=new StudentGroup(2);
		sg.setStudent(st, 0);
		sg.setStudent(stud, 1);
		//System.out.println(sg.getStudent(0).getFullName());
		//System.out.println(sg.getStudent(1).getFullName());
		Student[] dup=sg.getStudents();
		System.out.println(dup[0].getFullName());
		System.out.println(dup[1].getFullName());
		
		
	}

}
