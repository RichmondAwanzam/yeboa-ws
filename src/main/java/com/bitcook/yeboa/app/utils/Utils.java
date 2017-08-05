package com.bitcook.yeboa.app.utils;

public class Utils {

	public static boolean validateImage(String filename) {
	    boolean isValid = false;
	    String formats[] = { "jpg", "png", "jpeg", "gif" };
	    int index = filename.lastIndexOf(".");
	    if (index == -1) {
	      return false;
	    }

	    String extension = filename.substring(index + 1);

	    for (String format : formats) {
	      if (extension.equalsIgnoreCase(format)) {
	        isValid = true;
	        break;
	      }
	    }

	    return isValid;
	  }
	
	public static String getFileEtension(String filename) {
	   
	    int index = filename.lastIndexOf(".");
	    if (index == -1) {
	      return "";
	    }

	    String extension = filename.substring(index + 1);

	
	    return extension;
	  }
	
	public static boolean isImage(String filename) {
	    boolean isValid = false;
	    String formats[] = { "jpg", "png", "jpeg", "gif" };
	    int index = filename.lastIndexOf(".");
	    if (index == -1) {
	      return false;
	    }

	    String extension = filename.substring(index + 1);

	    for (String format : formats) {
	      if (extension.equalsIgnoreCase(format)) {
	        isValid = true;
	        break;
	      }
	    }

	    return isValid;
	  }
}
