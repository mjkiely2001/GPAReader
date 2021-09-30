import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class compareGPA {
	
	public static void main(String[] args) {
		//Print out instructions for the user
		System.out.println("Instructions:" + "\n" + "You will be prompted with simple questions in regards to Group and Section files needed to be read." + "\n" + 
				"- Create a main folder which holds the section files and Group folders." + "\n" +
				"- Make sure the Group files are in their own labeled Group folder with proper file names." + "\n" + 
				"- Keep section files out of the Group folder if it is being compared to a Group." + "\n" + 
				"*Press the 'enter' key once instructions have been read*");
		//Call getPath Method
		getPath();
    }
	
	//This method retrieves the main file path from the user
    public static void getPath() {
    	Scanner scanner1 = new Scanner(System.in);
        String anyKey = scanner1.nextLine();
        if(anyKey != null) {
        	System.out.println("Please paste the file path to the main folder:");
		        String mainFolderPath = scanner1.nextLine();
		        if (mainFolderPath != null) {
		        	//Pass in the main folder path to the " Get Section File Name" Method
		        	getSecFileName(mainFolderPath);
		        } else {
		        	System.out.print("File path is unknown, please retry");
		        }
        }
    }
	
    //This method opens the main folder and checks for the users inputed section file
    public static void getSecFileName(String mainFolderPath) {
    	Scanner scanner2 = new Scanner(System.in);
    	
    	File folder = new File(mainFolderPath);
    	File[] listOfFiles = folder.listFiles();
    	String secFileNames[] = new String[listOfFiles.length];
    	
    	System.out.println("Enter Section file you would like to select:");
    	String sectionName1 = scanner2.nextLine();
    	
    	//If a group is selected, the "Get Group Name" method is called
    	System.out.println("Would you like to select a Group? (y/n)");
    	String answer = scanner2.nextLine();
    	if(answer.contains("y")) {
    		getGroupName(mainFolderPath);
		//If a group is not selected, the user is asked for another section file with the main folder
    	} else if (answer.contains("n")){
    		getSecondSecFileName();
    	} else {
    		System.out.print("Incorrect character inputted");
    	}
    	//Looks for the first section file inputed by the user
    	for(int i = 0; i < listOfFiles.length; i++) {
    		secFileNames[i] = listOfFiles[i].getName();
    		if(!secFileNames[i].contains(sectionName1)) {
    			System.out.println("Invalid Section Name");
    			break;
    		} else if(secFileNames[i].contains(sectionName1)) {
    			sectionName1 = secFileNames[i];
    			readFirstSectionFile(sectionName1, mainFolderPath);
    			break;
    		}
    	}
    }
    
    //This method retrieves the second section file from the user if there is no groups
    public static void getSecondSecFileName() {
    	
    }
    
    //This method gets the groups' name based on how many Groups are wanted by the user
    public static void getGroupName(String mainFolderPath) {
  
    	Scanner scanner3 = new Scanner(System.in);
    	int num;
    	String groupSecFileName1;
    	
    	System.out.println("How many group folders would you like to select?");
    	num = scanner3.nextInt();
    	scanner3.nextLine();
      	
    	//If there is one group folder selected, get the folder's name
    	if(num == 1) {
    		System.out.println("Enter the name of Group folder:");
			String groupFolderName = scanner3.nextLine();
			
        	File folder = new File(mainFolderPath + "/" + groupFolderName);
        	File[] listOfGroupFiles = folder.listFiles();
        	
        	groupSecFileName1 = listOfGroupFiles[0].getName();
        	System.out.println(groupSecFileName1);
        	
        	
    	} else {
    		System.out.println("Not implemented yet");
    	}
    }
    
    //This method reads the first section file and calls the "Parsing Methods: getSecName(), getID(), getName(), getGPA()"
    public static void readFirstSectionFile(String sectionName1, String mainFolderPath) {
    	File file = new File(mainFolderPath + "/" + sectionName1);

    	System.out.println(sectionName1);
    	
    	try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));) {
    		getSecName(br);
    		getID(br);
    		
    	} catch(IOException e) {
    		System.out.println("Could not read file");
    	}
    }
    
    //This method parses the first line of the text file and receives the section name
    public static void getSecName(BufferedReader br) {
    	String sectionName="";
		try {
			sectionName = br.readLine();
		} catch (IOException e) {
			System.out.print("Cannot read first line");
		}
		//Remove "commas: ',,'" from the Section Name.
    	sectionName = sectionName.replaceAll(",,", "");
    	System.out.println(sectionName);
    }
    
    //This method gets the ID or the first string before the first comma of each line (lines 2 - last line)
    public static void getID(BufferedReader br) {
    	LinkedList<String> listOfIDs = new LinkedList<String>();
    	
    	int countLines = 0;
    	String[] lines = null;
    	String line = "";

		try {
			while((line = br.readLine()) != null) {
				lines = line.split(",");
				listOfIDs.add(lines[0]);
			}
			System.out.println(listOfIDs);
			
		} catch (IOException e) {
			System.out.println("Cannot read user IDs'");
		} finally {
			try {
		        br.close();
		    } catch (Exception e) {
		    	System.out.println("Cannot close file");
		    }
	    }
    }
}
    
  //This method gets the Name of the student of each line (lines 2 - last line)

