package LOGIN;

import java.sql.Statement;
import java.util.Scanner;

//MAIN  INTERFACE CLASS
public class home 
{
	static Scanner sc=new Scanner(System.in);
	public static void mainmenu()
	{
		int n;
		do
		{
		System.out.println("1.Create account");
		System.out.println("2.login");
		System.out.println("3.Exit");
		
		System.out.println("Please select an option");
		n=sc.nextInt();
			switch(n)
			{
			case 1:create();
			 		break;
			case 2:login();
					break;
			
			}
			}while(n!=3);
	}
	
// METHOD ACCOUNT CREATION AND  LOGIN 
	
	
	
// METHOD FOR CREATION
	
	static void create()
	{	
		staff st=new staff();
		System.out.println("Enter EMPLOYEE NAME");
		st.setEMP_NAME(sc.next());
		System.out.println("Enter SUBJECT");
		st.setSUBJCT(sc.next());
		System.out.println("Enter EMAIL");
		st.setEMAIL(sc.next());
		System.out.println("Enter the PASSWORD");
		st.setPASSWORD(sc.next());
		st.setROLE("Teacher");
	 DBoperations.teacher_create(st);
	}	
	
	
//MTHOD FOR STUDNET AND TEACHER LOGIN
	
	static void login()
	{
		System.out.println("Enter the username");
		String user=sc.next();
		System.out.println("Enter the password ");
		String pass=sc.next();
		DBoperations.login_account(user,pass);
	}

	}