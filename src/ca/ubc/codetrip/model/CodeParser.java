package ca.ubc.codetrip.model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jdepend.xmlui.*;
public class CodeParser {

	public CodeParser() {
	}

	public String parseToJDepend(String currDir, String pathCodeBase) throws IOException{
	
	String pathJDepxml = currDir + "/JDepReport.xml";
	File file = new File(pathJDepxml);
	if(file.exists()){
		if (!file.canExecute()) {
			file.setExecutable(true);
		}
		System.out.println("Is Execute allowed : " + file.canExecute());
	}
	
	JDepend jdepend = new JDepend();
	PrintWriter writer = new PrintWriter(new File("JDepReport.xml"));
	jdepend.setWriter(writer);
	jdepend.addDirectory(pathCodeBase);
	jdepend.analyze();
	writer.close();
	
	return pathJDepxml;
}
	
	public String parseToNCSS(String currDir, String pathCodeBase) throws InterruptedException {
		
		// Get path names of tools and code bases and store them as strings
		String pathNCSS = currDir + "/lib/javancss-32.53/bin/javancss";
		String pathNCSSxml = currDir + "/NCSSReport.xml";
		System.out.println(currDir);
		System.out.println(pathNCSS);
		System.out.println(pathNCSSxml);

		// Resets the xml file as a blank xml file
		File xml = new File(pathNCSSxml);
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
		commands.add(pathNCSSxml);
		commands.add(pathCodeBase);
		System.out.println(commands);

		ProcessBuilder pb = new ProcessBuilder(commands);

		// Kill javancss process after it's done
		try {
			Process process = pb.start();
			process.waitFor();
			if (process.exitValue() == 0){
				process.destroy();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pathNCSSxml;
	}
}
