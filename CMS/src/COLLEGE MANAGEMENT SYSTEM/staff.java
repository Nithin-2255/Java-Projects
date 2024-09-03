package LOGIN;


//  ENCAPSULATION CLASS OF TEACHER(STAFF)

public class staff 
{
	String EMP_ID;
	String EMP_NAME;
	public String getEMP_ID() {
		return EMP_ID;
	}
	public void setEMP_ID(String eMP_ID) {
		EMP_ID = eMP_ID;
	}
	public String getEMP_NAME() {
		return EMP_NAME;
	}
	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}
	public String getSUBJCT() {
		return SUBJCT;
	}
	public void setSUBJCT(String sUBJCT) {
		SUBJCT = sUBJCT;
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
	public String getROLE() {
		return ROLE;
	}
	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}
	String SUBJCT;
	String EMAIL;
	String PASSWORD;
	String ROLE;
	String TUTOR;
	public String getTUTOR() {
		return TUTOR;
	}
	public void setTUTOR(String tUTOR) {
		TUTOR = tUTOR;
	}
	
}
