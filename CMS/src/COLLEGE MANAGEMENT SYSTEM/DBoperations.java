package LOGIN;

import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;


//ALL THE DATABASE OPERAIONS FOR EACH METHODS

public class DBoperations
{
//	TEACHER ACCCOUNT CREATION 
	public static void teacher_create(staff st)

	{
		try 
		{
			String sql="insert into teachers(EMP_NAME,SUBJECT,EMAIL,PASSWORD,ROLE) values('"+st.getEMP_NAME()+"','"+st.getSUBJCT()+"','"+st.getEMAIL()+"','"+st.getPASSWORD()+"','"+st.getROLE()+"')";	
			Statement stmt=DBconnection.createStmt();
			int a=stmt.executeUpdate(sql);
			
			if(a==1)
			{
				System.out.println("Inserted to tachers");
				
				sql="select	MAX(EMP_ID) from teachers";
				ResultSet rs=stmt.executeQuery(sql);
				int id = 0;
					while(rs.next())
					{
						id=rs.getInt("MAX(EMP_ID)");
						
					}
// CHECHKS IF ID> 0 TEACHER DETAILS INSERTED TO LOGIN TABLE
					if(id>0)
					{
						String sql2="insert into login (ID,EMAIL,PASSWORD,ROLE)values('"+id+"','"+st.getEMAIL()+"','"+st.getPASSWORD()+"','"+st.getROLE()+"')";
						Statement stm=DBconnection.createStmt();
						int b=stm.executeUpdate(sql2);
						if(b==1)
						{
							System.out.println("insertd to login");
						}
					}
					
				
			}
		} catch (Exception e) 
		
		{
			System.out.println(e);
		}
	}

//	LOGIN OPERATION
	
	public static void login_account(String user,String pass)
	{
		String sc="";
		int sd=0;
		try 
		{
			
			String sql="Select ID,ROLE from login where EMAIL='"+user+"'AND PASSWORD='"+pass+"'";
			Statement stmt=DBconnection.createStmt();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				 sc=rs.getString("ROLE");
				System.out.println("The role"+sc);
				 sd=rs.getInt("ID");
				System.out.println("Id is "+sd);
			}
			if(sd>0)
//CHECHKS FOR ROLE IF TEACHER THEN GOES TO TECHERPROFILE
//ELSE TO STUDENTPROFILE 
				
			{
				switch(sc)
				{
				case "Teacher":
								TeachrProfile tchr=new TeachrProfile(sd);
								tchr.Profile();
								break;
				case "Student":
								studentprofile std=new studentprofile(sd);
								std.studprofile();
								break;
				
				}
			}
			else
			{
				System.out.println("Invalid usrname or password");
				home.mainmenu();
			}
			
		} catch (Exception e) 
		
		{
			System.out.println(e);
		}
	}

//	THE NEXT TWO OPERATIONS ARE TO GET PRFILE OF TEACHR AND STUDENT
	
	//FOR TEACHER PROFILE	
	public staff getStaffProfilefromDB(int id)
	{
		staff s=new staff();
		try {
			
			Statement stmt=DBconnection.createStmt();
			ResultSet rs=stmt.executeQuery("select * from teachers where EMP_ID="+id+"");
			while(rs.next())
			{
				s.setEMP_NAME(rs.getString("EMP_NAME"));
				s.setSUBJCT(rs.getString("SUBJECT"));
				s.setEMAIL(rs.getString("EMAIL"));
				
			}
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		return s;
	}
	
	//FOR STUDNET PROFILE 
	
	public Student getStudentprofile(int id)
	{
		Student st=new Student();
		try
		{
			Statement stmt=DBconnection.createStmt();
			ResultSet rs=stmt.executeQuery("select * from student where ADM_NO="+id+"");
			while(rs.next())
			{
				st.setSTUDENT_NAME(rs.getString("STUDENT_NAME"));
				st.setDOB(rs.getString("DOB"));
			
			}
			
		} catch (Exception e) 
		
		{
			System.out.println(e);
		}
		return st;
	}
	
//	 NEXT FEW OPERATIONS AR FOR TEACHER PROFILE ONLY
	
	//TO ADD STUDENT
	
	public static void addStudent(Student su,int id)
	{
		try
		{
			String sql="insert  into student(ADM_NO,STUDENT_NAME,DOB,EMAIL,PASSWORD,G_NAME,ROLE,TUTOR) values('"+su.getADMN_NO()+"','"+su.getSTUDENT_NAME()+"','"+su.getDOB()+"','"+su.getEMAIL()+"','"+su.getPASSWORD()+"','"+su.getG_NAME()+"','"+su.getROLE()+"','"+su.getTutor()+"')";
			Statement stmt=DBconnection.createStmt();
			int a=stmt.executeUpdate(sql);
			if(a==1)
			{
				System.out.println("student Added");
				sql="select	MAX(ADM_NO) from student";
				ResultSet rs=stmt.executeQuery(sql);
				int id2 = 0;
					while(rs.next())
					{
						id2=rs.getInt("MAX(ADM_NO)");
						
					}
			//	STUDENT DETAILS ARE ADDED TO LOGIN AND MARK TABLE
					if(id2>0)
					{	String sql3="insert into marks(STUDENT_NAME,ADM_NO)values('"+su.getSTUDENT_NAME()+"','"+su.getADMN_NO()+"')";
						String sql2="insert into login(ID,EMAIL,PASSWORD,ROLE)values('"+su.getADMN_NO()+"','"+su.getEMAIL()+"','"+su.getPASSWORD()+"','"+su.getROLE()+"')";
						Statement stm=DBconnection.createStmt();
						int c=stm.executeUpdate(sql3);
						int b=stm.executeUpdate(sql2);
						
						if(b==1)
						{
							System.out.println("insertd to login");
						}
					}
			}
			}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	//TO VIEW STUDENT ADDED BY THE TEACHER
	
	public static List<Student> viewStudent(int id)
	{
		List<Student> li=new ArrayList<Student>();
		try 
		{	
			String sql="select * from student where TUTOR='"+id+"'";
			Statement stmt=DBconnection.createStmt();
	
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{	
				Student st=new Student();
			
				st.setADMN_NO(rs.getString("ADM_NO"));
				st.setSTUDENT_NAME(rs.getString("STUDENT_NAME"));
				st.setDOB(rs.getString("DOB"));
				st.setEMAIL(rs.getString("EMAIL"));
				st.setPASSWORD(rs.getString("PASSWORD"));
				st.setG_NAME(rs.getString("G_NAME"));
				li.add(st);
				
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return li;
	}
	
	//TP VIEWSTUDENT BY ADMISION NUMBER
	
	public static  Student viewbya(int a)
	{	
		Student st=new Student();
		try 
		{
			String sql="select * from student where ADM_NO='"+a+"'";
			Statement stmt=DBconnection.createStmt();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{	
				
				st.setADMN_NO(rs.getString("ADM_NO"));
				st.setSTUDENT_NAME(rs.getString("STUDENT_NAME"));
				st.setDOB(rs.getString("DOB"));
				st.setEMAIL(rs.getString("EMAIL"));
				st.setPASSWORD(rs.getString("PASSWORD"));
				st.setG_NAME(rs.getString("G_NAME"));
			} 
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
	return st;
	}
	
// TO ADD MARK TO marks TABLE
	
	public static void addmark(mark mk,int adm)
	{
		try {
			String sql="select ADM_NO FROM marks WHERE ADM_NO="+adm+"";
			Statement stmt=DBconnection.createStmt();
			ResultSet rs=stmt.executeQuery(sql);
			int ad=0;
			while(rs.next())
			{
				ad=rs.getInt("ADM_NO");
			}
			if(ad>0)
			{
			String sql2="UPDATE marks SET MATHS = " + mk.getMATHS() + ", " + "PHYSICS = " + mk.getPHYSICS() + ", " + "CHEMISTRY = " + mk.getCHEMISTRY() + ", " +"BIOLOGY = " + mk.getBIOLOGY() + " " +
                    "WHERE ADM_NO = " + adm;
			Statement stmt1=DBconnection.createStmt();
			int a=stmt1.executeUpdate(sql2);
				if(a==1)
				{
					System.out.println("mark inserted");
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
//	THE NEXT OPERATIONS AR FR STUDNT PROFILE
	//TO VIEW STUDNET PROFILE	
	public static   Student viewprofile(int id)
	{	Student st=new Student();
		try 
		{
			String sql="select * from student where ADM_NO='"+id+"'";
			Statement stmt=DBconnection.createStmt();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{	
				st.setADMN_NO(rs.getString("ADM_NO"));
				st.setSTUDENT_NAME(rs.getString("STUDENT_NAME"));
				st.setDOB(rs.getString("DOB"));
				st.setEMAIL(rs.getString("EMAIL"));
				st.setPASSWORD(rs.getString("PASSWORD"));
				st.setG_NAME(rs.getString("G_NAME"));
			}	
		} catch (Exception e) 
		
		{
			System.out.println(e);
		}
		return st;
	}
	
	//TO VIEW STUDENT MARKLIST
	
	public static mark viewmark(int id)
	{	
		mark mk =new mark();
		try 
		{	
			String sql="select * from marks where ADM_NO='"+id+"'";
			Statement stmt=DBconnection.createStmt();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				mk.setBIOLOGY(rs.getString("BIOLOGY"));
				mk.setCHEMISTRY(rs.getString("CHEMISTRY"));
				mk.setMATHS(rs.getString("MATHS"));
				mk.setPHYSICS(rs.getString("PHYSICS"));
			}
			
		} catch (Exception e)
		{
			System.out.println(e);
		}
		return mk;
	}
}
