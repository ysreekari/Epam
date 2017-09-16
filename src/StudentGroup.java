import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {
	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		try {
			return students;
		}catch(IllegalArgumentException e)
		{
			e.printStackTrace();
			
		}
		return null;

	}

	@Override
	public void setStudents(Student[] students) {
		try {
			this.students=students;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudent(int index)
	{
	try {
		return students[index];	
	}
	catch(IllegalArgumentException e)
	{
		e.printStackTrace();
	}
	return null;
	}

	@Override
	public void setStudent(Student student, int index)
	{
		try {
			students[index]=student;
		}
		catch(IllegalArgumentException e)
		{
		e.printStackTrace();	
		}
	}

	@Override
	public void addFirst(Student student)
	{
		try {
			students[0]=student;
		}
		catch(IllegalArgumentException e)
		{
			
		}
	}

	@Override
	public void addLast(Student student) {
		try {
			students[students.length-1]=student;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void add(Student student, int index) {
		try {
			students[index]=student;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void remove(int index) {
		try {
			ArrayList<Student> list=new ArrayList<Student>(Arrays.asList(students));
			list.remove(index);
			students=(Student[])list.toArray();
		}catch(IllegalArgumentException e)
		{
			System.out.println("Student not exist");
		}
		
	}
	@Override
	public void remove(Student student) {
		try {
			ArrayList<Student> list=new ArrayList<Student>(Arrays.asList(students));
			list.remove(student);
			students=(Student[])list.toArray();
		}catch(IllegalArgumentException e)
		{
			System.out.println("Student not exist");
		}
		
	}

	@Override
	public void removeFromIndex(int index) {
		try {
			ArrayList<Student> list=new ArrayList<Student>(Arrays.asList(students));
			for(int i=index-1;i<students.length-1;i++)
			{
				list.remove(i);
			}
			students=(Student[])list.toArray();
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removeFromElement(Student student) {
		try {
			int pos=0;
			ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
			for(int i=0;i<students.length-1;i++)
			{
				if(student.equals(students[i]))
				{
					pos=i;
				}
			}
			for(int i=pos;i<students.length-1;i++)
			{
				a.remove(students[i]);
			}
			students=(Student[])a.toArray();
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removeToIndex(int index) {
		try {
			ArrayList<Student> arr=new ArrayList<Student>(Arrays.asList(students));
			for(int i=0;i<index;i++)
			{
				arr.remove(i);
			}
			students=(Student[])arr.toArray();
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removeToElement(Student student) {
		try {
			ArrayList<Student> list=new ArrayList<Student>(Arrays.asList(students));
		for(int i=0;i<students.length-1;i++)
		{
			if(students[i].equals(student))
			{
				break;
			}
			else
			{
				list.remove(i);
			}
		}
		students=(Student[])list.toArray();
	}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void bubbleSort() {
		Student temp1;
		for(int i=0;i<students.length-1;i++)
		{
			for(int j=0;j<students.length-1;j++)
			{
				if(students[i].getAvgMark()>=students[j].getAvgMark())
				{
					temp1=students[i];
					students[i]=students[j];
					students[j]=temp1;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		try {
			int j=0;
			Student ResultofStudents[]=new Student[students.length];
			for(int i=0;i<students.length-1;i++)
			{
				if(students[i].getBirthDate().equals(date))
				{
					ResultofStudents[j++]=students[i];
				}
			}
			return ResultofStudents;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		try {
			int j=0;
			Student ResultedStudents[]=new Student[students.length];
			for(int i=0;i<students.length-1;i++)
			{
				if(students[i].getBirthDate().after(firstDate)&&students[i].getBirthDate().before(lastDate))
				{
					ResultedStudents[j++]=students[i];
				}
			}
			return ResultedStudents;
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		try{
			Student ResultedStudents[]=new Student[students.length];	
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.set(date.getYear(),date.getMonth(),date.getDate());
			c.add(Calendar.DATE, days);
			Date dup=c.getTime();
			int j=0;
			for(int i=0;i<students.length-1;i++)
			{
				if(students[i].getBirthDate().getYear()==dup.getYear()||students[i].getBirthDate().getMonth()==dup.getMonth()&&students[i].getBirthDate().getDate()==dup.getDate())
				{
					ResultedStudents[j++]=students[i];
				}
			}
			
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		@SuppressWarnings("deprecation")
		int year=students[indexOfStudent].getBirthDate().getYear();
		@SuppressWarnings("deprecation")
		int cyear=new Date(2017,9,16).getYear();
		return cyear-year;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Student[] getStudentsByAge(int age) {
		try{
			int j=0;
		Student ResultedStudents[]=new Student[students.length];
		for(int i=0;i<students.length-1;i++)
		{
			if(students[i].getBirthDate().getYear()-new Date(2017,9,16).getYear()==age)
			{
				ResultedStudents[j]=students[i];
			}
		}
		return ResultedStudents;
		}catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		try{
			double max=0;
			for(int i=0;i<students.length-1;i++)
			{
				if(students[i].getAvgMark()>=max)
				{
					max=students[i].getAvgMark();
				}
			}
			for(int i=0;i<students.length-1;i++)
			{
				
			}
		}catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
       try {
    	   int position1=0;
			for(int k=0;k<students.length-1;k++)
			{
				if(students[k].equals(student))
				{
					position1=k;
					break;
				}
			}
			return students[position1++];
		}catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
