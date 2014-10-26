import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class codeParser {

	public codeParser () {
	}

	public static void main(String [] args) {
		
		// Get path names of tools and code bases and store them as strings
		String pathLib =  System.getProperty("user.dir") + "/lib";
		String pathNCSS = pathLib + "/javancss-32.53/bin/javancss";
		String pathXML = pathLib + "/test.xml";
		String pathCodeBase1 = pathLib + "/micropolis-java";
		System.out.println(pathLib);
		System.out.println(pathNCSS);
		System.out.println(pathXML);
		System.out.println(pathCodeBase1);
		
		// Resets the xml file as a blank xml file
		File xml = new File(pathXML);
		PrintWriter writer;
		try {
			writer = new PrintWriter(xml);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Checks to see if javancss tool is executable; if not then set setExecutable to true
		File file = new File(pathNCSS);
		if(file.exists()){
			if (!file.canExecute()) {
				file.setExecutable(true);
			}
			System.out.println("Is Execute allowed : " + file.canExecute());
		}

		// Creates command to run javancss
		List<String> commands = new ArrayList<String>();
		commands.add(pathNCSS);
		commands.add("-ncss");
		commands.add("-recursive");
		commands.add("-xml");
		commands.add("-all");
		commands.add("-out");
		commands.add(pathXML);
		commands.add(pathCodeBase1);
		System.out.println(commands);

		ProcessBuilder pb = new ProcessBuilder(commands);

		try {
			Process process = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
