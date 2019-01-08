package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minetype {

	public static void main(String[] args) {

		Map<String, String> ext = new HashMap<>();
		Map<String, String> ext2 = new HashMap<>();
		
		ext.put("png", "image/png");
		ext.put("TIFF", "image/TIFF");
		ext.put("css", "text/css");
		ext.put("TXT", "text/plain");
		
		List<String> list = new ArrayList<String>();	
		
		list.add("example.TXT");
		list.add("referecnce.txt");
		list.add("strangename.tiff");
		list.add("resolv.CSS");
		list.add("matrix.TiFF");
		list.add("lanDsCape.Png");
		list.add("extract.cSs");
		
		String[] files = { "example.TXT", "referecnce.txt", "strangename.tiff", "resolv.CSS","matrix.TiFF","lanDsCape.Png","extract.cSs" };
				
		for (Map.Entry<String, String> entry : ext.entrySet()) {			
			ext2.put(entry.getKey().toLowerCase(), entry.getValue());
		}
		
		
		for (String FNAME : files) {
			if (isFilenameValid(FNAME)) {
				
				String extention = getFileExtension(FNAME).toLowerCase();
					System.out.println(extention);			
				if (ext2.containsKey(extention)) {				
					System.out.println(ext2.get(extention));
				} else {
					System.out.println("UNKNOWN");
				}
			}else {
				System.out.println("UNKNOWN");
			}
		}

	}

	private static String getFileExtension(String name) {
	   
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return name.substring(lastIndexOf+1);
	}
	
	public static boolean isFilenameValid(String file) {
		File f = new File(file);
		try {
			f.getCanonicalPath();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
