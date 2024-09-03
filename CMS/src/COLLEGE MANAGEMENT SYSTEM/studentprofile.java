package LOGIN;

import java.util.Scanner;

public class studentprofile 
{
	static Scanner sc=new Scanner(System.in);
	private static int id=0;
	public studentprofile(int id) 
	{
		this.id = id;
	}
	
	// STUDENT PROFILE MENU
	
	void studprofile()
	{
		DBoperations o=new DBoperations();
		Student st=o.getStudentprofile(id);
		System.out.println("******************************************");
		System.out.println("Hi    "+st.getSTUDENT_NAME());
		int n;
		do
		{
		System.out.println("1:View Prfile");
		System.out.println("2:ViewMark");
		System.out.println("3:LogOut");
		
		System.out.println("Select an option");
		n=sc.nextInt();
		switch(n)
		{
		
		case 1:Studentprofile();
				break;
		case 2:viewmark();
				break;
		
		}
		}while(n!=2);
	}
	
	//TO VIEW STUDENT PROFILE
	static void Studentprofile()
	{
		System.out.println("*******DETAILS OF STUDENT (ADM NO "+id+")******");
		System.out.println("");
		Student st=DBoperations.viewprofile(id);
		System.out.println("ADM_NO: "+st.getADMN_NO()+" ,STUDENT_NAME: "+st.getSTUDENT_NAME()+" ,DOB:"+st.getDOB()+" ,EMAIL: "+st.getEMAIL()+" ,PASSWORD: "+st.getPASSWORD()+" ,G_NAME: "+st.getG_NAME());
	}
	
	//TO VIEW STUDENT MARKLIST
	
	static void viewmark()
	{	
		System.out.println("MARK OF SUBJECTS");
		mark mk=DBoperations.viewmark(id);
		System.out.println("BIOLOGY :"+mk.getBIOLOGY()+"CHEMISTRY :"+mk.getCHEMISTRY()+"PHYSICS :"+mk.getPHYSICS()+"MATHS :"+mk.getMATHS());
	}
	
}
