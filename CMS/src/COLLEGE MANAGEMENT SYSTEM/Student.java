package LOGIN;

public class Student 
{
	String ADMN_NO;
	String STUDENT_NAME;
	String DOB;
	String EMAIL;
	String PASSWORD;
	String G_NAME;
	String ROLE;
	public int getTutor() {
		return tutor;
	}
	public void setTutor(int id) {
		this.tutor = id;
	}
	int tutor;
	public String getADMN_NO() {
		return ADMN_NO;
	}
	public void setADMN_NO(String aDMN_NO) {
		ADMN_NO = aDMN_NO;
	}
	public String getSTUDENT_NAME() {
		return STUDENT_NAME;
	}
	public void setSTUDENT_NAME(String sTUDENT_NAME) {
		STUDENT_NAME = sTUDENT_NAME;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getG_NAME() {
		return G_NAME;
	}
	public void setG_NAME(String g_NAME) {
		G_NAME = g_NAME;
	}
	public String getROLE() {
		return ROLE;
	}
	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}
}
