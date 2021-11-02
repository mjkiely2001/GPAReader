import java.util.LinkedList;

public class Section implements Comparable<Section>
{
	
	LinkedList<Student> Sec = new LinkedList<Student>();
	private string Name = "";
	
	public Section()
	{
		Name = "";
	}
	
	public Section(String nName)
	{
		Name = nName;
	}
	
	public void addStudent(String nID, String nName, int nGPA)
	{
		Student s = new Student(nID, nName, nGPA);
		Sec.add(s);
	}
	
	public int avgGPA()
	{
		int aGPA = 0;
		for(int i = 1; i <= Sec.size(); i++)
		{
			aGPA += Sec.get(i).getGPA();
		}
		aGPA = aGPA/Sec.size();
		return aGPA;
	}
	
	@Override
	public int compareTo(Section s) 
	{
		if(this.avgGPA() < s.avgGPA())
			return -1;
		else if(this.avgGPA() > s.avgGPA())
			return 1;
		return 0;
	}

}

	
