package main;


import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        Map<String, String> ext = new HashMap<>();
        Map<String, String> ext2 = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
           // System.err.println("ex: " + EXT);
            String MT = in.next(); // MIME type.
            //System.err.println("mt: " + MT);
            ext.put(EXT.toLowerCase(), MT);
        }
        
        for (Map.Entry<String, String> entry : ext.entrySet()) {			
			ext2.put(entry.getKey().toLowerCase(), entry.getValue());
		}
		
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
           // System.err.println("fn: " + FNAME);
            if (isFilenameValid(FNAME)) {
				
				String extention = getFileExtension(FNAME).toLowerCase();
								
				if (ext.containsKey(extention)) {				
					System.out.println(ext.get(extention));
				}else {
					System.out.println("UNKNOWN");
				}
			}else {
				System.out.println("UNKNOWN");
			}
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.

        
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