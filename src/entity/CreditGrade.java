package entity;

public class CreditGrade {
	private int creditGradeId;
	private String creditGradeName;
	
	public CreditGrade(int creditGradeId, String creditGradeName) {
		this.creditGradeId = creditGradeId;
		this.creditGradeName = creditGradeName;
	}
	public int getCreditGradeId() {
		return creditGradeId;
	}
	public void setCreditGradeId(int creditGradeId) {
		this.creditGradeId = creditGradeId;
	}
	public String getCreditGradeName() {
		return creditGradeName;
	}
	public void setCreditGradeName(String creditGradeName) {
		this.creditGradeName = creditGradeName;
	}

}
