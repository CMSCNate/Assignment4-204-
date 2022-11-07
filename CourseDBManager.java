package Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	private CourseDBStructure structure;

	public CourseDBManager()
	{
		structure = new CourseDBStructure(300);
	}
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub
		structure.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		return structure.get(crn);
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		String sId = "";
		int sCRN = 0;
		int sCredits = 0;
		String sRoomNum ="";
		String sInstructor = "";
		String[] sArray = new String[4];
		
		Scanner myReader = new Scanner(input);
		while(myReader.hasNextLine())
		{
			sArray = myReader.nextLine().split(" ");
			structure.add(new CourseDBElement(sArray[0], Integer.parseInt(sArray[1]), Integer.parseInt(sArray[2]), sArray[3], sArray[4]));

			
			//structure.add(myReader.nextLine());
		}
		myReader.close();
		
	
	}

	@Override
	public ArrayList<String> showAll() {
		
		return structure.showAll();
	}


}
