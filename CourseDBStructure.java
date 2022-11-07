package Assignment4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class CourseDBStructure implements CourseDBStructureInterface {
private int numOfCourses;
private LinkedList<CourseDBElement>[] hashTable;
private int hashTableSize;
private final double loadingFactor = 1.5;
private ArrayList<CourseDBElement> eledc = new ArrayList<CourseDBElement>();


	public CourseDBStructure(int _numOfCourses)
	{
		numOfCourses = _numOfCourses;
		hashTableSize = findNextPrimeArraySize();
		hashTable = new LinkedList[hashTableSize];
		for(int i = 0; i < hashTableSize; i++)
		{
			hashTable[i] = new LinkedList<CourseDBElement>();
		}
	}
	
	public CourseDBStructure(String testing, int _numOfCourses)
	{
		numOfCourses = _numOfCourses;
		hashTableSize = _numOfCourses;
		hashTable = new LinkedList[_numOfCourses];
		
		for(int i = 0; i < hashTableSize; i++)
		{
			hashTable[i] = new LinkedList<CourseDBElement>();
		}
	}
	
	@Override
	public void add(CourseDBElement element) 
	{
		int count = 0;
		boolean isThere = false;
		int HCArrayIndex = element.getHashCode() % hashTableSize;
		
		Iterator<CourseDBElement> myIterator = hashTable[HCArrayIndex].iterator();
	
		if(!myIterator.hasNext())
		{
			hashTable[HCArrayIndex].add(new CourseDBElement(element));
			eledc.add(new CourseDBElement(element));
			count++;
		}
		else {
			while(myIterator.hasNext())
			{ 
				if(element.compareTo(myIterator.next()) == 0)
				{
					isThere =true;
				}
				/*
				if(element.getCRN() == (myIterator.next().getCRN()));
				{
					isThere = true;
				}
				*/
				count++;
			}
			
			if (!isThere)
			{
				hashTable[HCArrayIndex].add(new CourseDBElement(element));
				eledc.add(new CourseDBElement(element));
				
			}
		}
		
		for(int i =0; i < eledc.size(); i++)
		{
			if(element.getCRN() == eledc.get(i).getCRN())
			{
				eledc.set(i, new CourseDBElement(element));
			}
		}
		
	}


	@Override
	public CourseDBElement get(int crn) throws IOException {
		Iterator<CourseDBElement> myIterator = hashTable[String.valueOf(crn).hashCode() % hashTableSize].iterator();
		//CourseDBElement currentListElement = myIterator.next();
			
		for (int i = 0; i < eledc.size(); i++)
		{
			if(eledc.get(i).getCRN() == crn)
			{
				return eledc.get(i);
			}
		}
		
		throw new IOException("This course element does not exist."); 
		/*
			while(myIterator.hasNext())
			{
			
				currentListElement = myIterator.next();
				if(crn == currentListElement.getCRN())
				{
					return currentListElement;
				}
			}
			throw new IOException("This course element does not exist.");
			*/
		}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> totalCourses = new ArrayList<>();
		for(int i = 0; i < hashTableSize; i++)
		{
			Iterator<CourseDBElement> myIterator = hashTable[i].iterator();
			for(int j = 0; j < hashTable[i].size(); j++)
			{
				totalCourses.add(myIterator.next().toString());
			}
		}
		return totalCourses;
		
	}

	@Override
	public int getTableSize() {
		return hashTableSize;
	}
		
	public int findNextPrimeArraySize()
	{
		int hashTableSize = (int) (numOfCourses / loadingFactor);
		boolean isPrime = false;

		while (isPrime == false || ((hashTableSize -3) % 4) != 0)
		{
			isPrime = true;
			for (int i = 2; i <= hashTableSize/2; i++)
			{
				if (hashTableSize%i == 0)
				{
					isPrime = false;
					hashTableSize++;
					break;
				}
			}
			if (isPrime == true && ((hashTableSize -3) % 4) != 0)
			{
				hashTableSize++;
			}
		}
		return hashTableSize;
	
	}

	
	
}
