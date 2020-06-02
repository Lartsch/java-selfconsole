import java.lang.System;
import java.net.URLDecoder;

/*
* @author lartsch
*/

public class Main {
	// get the platform string
	public static String systemName = System.getProperty("os.name").toLowerCase();
	public static void main(String[] args) throws Exception {
		// check if an argument was passed on jar execution
	    if (args.length == 0) {
	    	// get the path of the currently running jar
	    	final String jarPath = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	    	final String decodedPath = URLDecoder.decode(jarPath, "UTF-8");
	    	// Setting for the terminal window title (Linux/Windows)
	    	final String windowTitle = "App Name";
	    	// Check the current platform...
	    	if(systemName.contains("windows")) {
	    		// then start the new process with the OS or terminal dependent commands
	    		new ProcessBuilder(new String[] {"cmd", "/k", "start", "\""+windowTitle+"\"", "java", "-jar", decodedPath.substring(1), "run"}).start();
	    	} else if(systemName.contains("mac")) {
	    		new ProcessBuilder(new String[] {"/bin/bash", "-c", "java", "-jar", decodedPath, "run"}).start();
	    	} else if(systemName.contains("linux")) {
	    		// TODO: add support for other Linux terminals
	    		new ProcessBuilder(new String[] {"xfce4-terminal", "--title="+windowTitle, "--hold", "-x", "java", "-jar", decodedPath, "run"}).start();
	    	} else {
	    		// No OS could be detected
	    		System.err.println("OS could not be detected.");
	    	}
	    	// destroy the original process
	    	System.exit(0);
	    } else {
	    	// ACTUAL PROGRAM TO EXECUTE COMES HERE
	    } 
	}
}
