
public class Student implements Comparable<Student> 
{
	private String ID;
	private String Name;
	private int GPA;

	Student()
	{
		ID = "";
		Name = "";
		GPA = 0;
	}
	
	Student(String nID, String nName, int nGPA)
	{
		ID = nID;
		Name = nName;
		GPA = nGPA;
	}
	
	public String getID()
	{
		return ID;
	}

	public void setID(String nID)
	{
		ID = nID;
	}

	public String getName()
	{
		return Name;
	}
	
	public void setName(String nName)
	{
		Name = nName;
	}

	public int getGPA()
	{
		return GPA;
	}

	public void setGPA(int nGPA)
	{
		GPA = nGPA;
	}

	@Override
	public String toString()
	{
		return ID + " " + Name + " " + GPA;
	}

	@Override
	public int compareTo(Student s) 
	{
		if(s.getGPA() < this.getGPA())
			return 1;
		else if(this.getGPA() < s.getGPA())
			return -1;
		return 0;
	}
}
