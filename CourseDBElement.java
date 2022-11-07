package Assignment4;

public class CourseDBElement implements Comparable<CourseDBElement>{

	private String ID;
	private int CRN;
	private int numOfCredits;
	private String roomNum;
	private String instructorName;
	private int hashCode;
	
	public CourseDBElement(String _courseId, int _crn, int _numOfCredits, String _roomNum, String _instructorName)
	{
		ID = _courseId;
		CRN = _crn;
		numOfCredits = _numOfCredits;
		roomNum = _roomNum;
		instructorName = _instructorName;
		hashCode = coerceToString().hashCode();
	}
	
	public CourseDBElement(CourseDBElement course)
	{
		ID = course.getID();
		CRN = course.getCRN();
		numOfCredits = course.getNumOfCredits();
		roomNum = course.getRoomNum();
		instructorName = course.getInstructorName();
		hashCode =  coerceToString().hashCode();
	}
	
	public CourseDBElement()
	{
		
	}
	@Override
	public int compareTo(CourseDBElement otherCourse) {
		if(this.CRN == otherCourse.getCRN())
				//&&this.ID.equals(otherCourse.getID())
				//&& this.numOfCredits == otherCourse.getNumOfCredits()
				//&& this.roomNum.equals(otherCourse.getRoomNum())
				//&& this.instructorName.equals(otherCourse.getInstructorName()))
		{
			return 0;
		}
		else		
		{
			return -1;
		}
			
	}
	
	public String getID() {
		return ID;
	}

	public int getCRN() {
		return CRN;
	}

	public int getNumOfCredits() {
		return numOfCredits;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public String getInstructorName() {
		return instructorName;
	}
	
	public String coerceToString()
	{
		return String.valueOf(CRN);
	}
	
	public int getHashCode()
	{
		return hashCode;
	}

	public void setCRN(int parseInt) {
		CRN = parseInt;
		
	}
	
	@Override
	public String toString()
	{
		return "Course:" + ID + " CRN:" + CRN + " Credits:" + numOfCredits + " Instructor:" + instructorName + " Room:" +roomNum ;
	}
		
}
