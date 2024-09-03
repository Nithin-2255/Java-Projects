package LOGIN;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeachrProfile
{	static Scanner sc=new Scanner(System.in);
	public static int id=0;
	public TeachrProfile(int id) 
	{
		this.id = id;
	}
	public static void Profile()
	{
		DBoperations o=new DBoperations();
		staff st=o.getStaffProfilefromDB(id);
		System.out.println("******************************************");
		System.out.println("Hi    "+st.getEMP_NAME());
		int n;
		do
		{
		System.out.println("1:Add Student");
		System.out.println("2:View all Student");
		System.out.println("3:View Student by ADMN NO");
		System.out.println("4:Add MarkList");
		System.out.println("5:LogOut");
		
		System.out.println("Select an option");
		n=sc.nextInt();
			switch(n)
			{
			
			case 1:addStud();
					break;
			case 2:viewStud();
					break;
					
			case 3:viewby();
					break;
			case 4:markList();
					break;
			}
		}while(n!=5);
	}
//	METHODS USED IN TEACHER PROFILE
	
	//1.TO ADD STUDENT 
	
	 static void addStud()
	 {
		
		Student su =new Student();
		System.out.println("Enter Admission  number");
		su.setADMN_NO(sc.next());
		System.out.println("Enter Student name");
		su.setSTUDENT_NAME(sc.next());
		System.out.println("Enter the Date of Birth");
		su.setDOB(sc.next());
		System.out.println("Enter Email");
		su.setEMAIL(sc.next());
		System.out.println("Enter Password");
		su.setPASSWORD(sc.next());
		System.out.println("Enter guradian name");
		su.setG_NAME(sc.next());
		su.setROLE("Student");
		su.setTutor(id);
		DBoperations.addStudent(su,id);
	 }
	 
	 //2.TO VIEW STUDENT ADDED
	 
	static void viewStud()
	{	
		
		System.out.println("*******LIST OF STUDENTS******");
		System.out.println("");
		List<Student>al=DBoperations.viewStudent(id);
		for(Student s:al)
		{
			System.out.println("ADM_NO        :"+s.getADMN_NO());
			System.out.println("STUDENT NAME  :"+s.getSTUDENT_NAME());
			System.out.println("DATE OF BIRTH :"+s.getDOB());
			System.out.println("EMAIL         :"+s.getEMAIL());
			System.out.println("PASSWORD      :"+s.getPASSWORD());
			System.out.println(" ");
			
		}
		
	}
	
	//3.TO VIEW STUDENT BY ADM
	

	static void  viewby()
	{
		System.out.println("Enter the the admission number of student");
		int a=sc.nextInt();
		Student st=DBoperations.viewbya(a);
		System.out.println("*******DETAILS OF STUDENT ******");
		System.out.println("");
		System.out.println("ADM NO: "+st.getADMN_NO()+" , STUDENT NAME: "+st.getSTUDENT_NAME()+" ,DOB:"+st.getDOB()+" ,EMAIL: "+st.getEMAIL()+" ,PASSWORD: "+st.getPASSWORD()+" ,G NAME: "+st.getG_NAME());
		System.out.println(" ");
	
	}
	
	
	//4.TO VIW MARKLIST OF  STUDENT
	
	static void markList()
	{
		mark mk=new mark();
		System.out.println("Enter ADM:NO ");
		int adm=sc.nextInt();
		System.out.println("Add Mark list");
		System.out.println("Enter marks of Maths");
		mk.setMATHS(sc.next());
		System.out.println("Enter marks of Physics");
		mk.setPHYSICS(sc.next());
		System.out.println("Enter marks of Chemistry");
		mk.setCHEMISTRY(sc.next());
		System.out.println("Enter marks of Biology");
		mk.setBIOLOGY(sc.next());
		DBoperations.addmark(mk, adm);
		
		
	}
}
