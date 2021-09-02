package com.lnt.splitfilesbysize;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Main {

	String sizeTypes = "B,KB,MB,GB";

	public static void main(String[] args) throws Exception {

//		args = new String[] {
//				"/Users/admin/OneDrive - Platform 3 Solutions LLC/projects/cmod/data/dev/output/ATM-RECON-U.csv", "1",
//				"KB" };
		
		if (args.length != 3)
			System.err.println("Please pass the input file, split size like (10), MB/KB/GB in arguments");
		Main main = new Main();
		main.start(args);
	}

	private void start(String[] args) throws Exception {
//		check new file is present
		File file = new File(args[0]);
		if (!file.exists())
			throw new Exception("File is invalid/not exist");
		if (Integer.valueOf(args[1]) <= 0)
			throw new Exception("The size value " + args[1] + " is incorrection");
		if (!sizeTypes.contains(args[2]))
			throw new Exception("The size value " + args[1] + " is incorrection");
//		read the file
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		int splitSize = getSplitSize(args);
		int size = 0;
		int fileCounter = 0;
		String outputFile;
		Writer out = null;
		String header = "";
		while ((line = br.readLine()) != null) {
			if (size == 0 || size >= splitSize) {
				if (out != null) {
					out.flush();
					out.close();
				}
				outputFile = file.getParent() + File.separator + file.getName().split("\\.")[0] + "-" + fileCounter++
						+ "." +file.getName().split("\\.")[1];
				out = new OutputStreamWriter(new FileOutputStream(new File(outputFile)));
				if(size == 0)
					header = line;
				else
					out.write(header + "\n");
				size = 0;
				System.out.println("Writing to new file " + outputFile);
			}
			out.write(line + "\n");
			size += line.getBytes().length;
		}
		if (out != null) {
			out.flush();
			out.close();
		}
		System.out.println("spliting files process completed, Total Files =" + fileCounter + " , each size = " + args[1] + args[2]);
//		create new files

//		write to file

//		flush and close the file

//		pring the new files

	}

	private int getSplitSize(String[] args) {
		int size = Integer.valueOf(args[1]);
		switch (args[2]) {
		case "B":
			return size;
		case "KB":
			return size * 1024;
		case "MB":
			return size * 1024 * 1024;
		case "GB":
			return size * 1024 * 1024 * 1024;
		default:
			throw new IllegalArgumentException("Unexpected value: " + args[2]);
		}
	}

}
