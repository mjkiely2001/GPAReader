
public class Student {
private static String ID = "";
private static String Name ="";
private static int GPA = 0;

public static String getID()
{
	return ID;
}

public static void setID(String nID)
{
	ID = nID;
}

public static String getName()
{
	return Name;
}

public static void setName(String nName)
{
	Name = nName;
}

public static int getGPA()
{
	return GPA;
}

public static void setGPA(int nGPA)
{
	GPA = nGPA;
}

@Override
public String toString()
{
	return ID + " " + Name + " " + GPA;
}
}
