package de.mg.main;


public class OSCallHandler {

	private String osType;
	
	public OSCallHandler(String os) {
		this.osType = checkForActualOS(os);
	}

	private String checkForActualOS(String os) {
		if (isWindows(os)) {
			return "win";
		} else if (isMac(os)) {
			System.out.println("This is Mac");
			return "mac";
		} else if (isUnix(os)) {
			return "unixOrLinux";
		} else if (isSolaris(os)) {
			return "solaris";
		} else {
			return "OS NOT KNOWN";
		}
	}
 
	public static boolean isWindows(String os) {
 
		return (os.indexOf("win") >= 0);
 
	}
 
	public static boolean isMac(String os) {
 
		return (os.indexOf("mac") >= 0);
 
	}
 
	public static boolean isUnix(String os) {
 
		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0 );
 
	}
 
	public static boolean isSolaris(String os) {
 
		return (os.indexOf("sunos") >= 0);
 
	}

	public String getOsType() {
		return osType;
	}

}
