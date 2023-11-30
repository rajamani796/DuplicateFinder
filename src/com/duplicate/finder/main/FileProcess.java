package com.duplicate.finder.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

public class FileProcess {
	public static void main(String[] args) throws IOException {
		JFileChooser jfile=new JFileChooser();
		jfile.showOpenDialog(null);
		String filePath=jfile.getSelectedFile().getAbsolutePath();
	//	List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\A718438\\Desktop\\redundancy\\LearningHistory.txt"));
		List<String> lines = Files.readAllLines(Paths.get(filePath));
		System.out.println(jfile.getSelectedFile().getParent()+" "+jfile.getSelectedFile().getPath()+" "+jfile.getSelectedFile().getCanonicalPath());
		List<String> duplicateRemovedList=new ArrayList<String>();
		//System.out.println(lines);
	/*	for(String line:lines) {
			if(!duplicateRemoved.contains(line)) {
				duplicateRemoved.add(line);
			}
		}
		System.out.println("*************************");
		System.out.println(duplicateRemoved);
		*/
		Map<String, String> detailsOfDuplicateMap=new HashMap<String,String>();
		for(int i=0;i<lines.size();i++) {
			if(!duplicateRemovedList.contains(lines.get(0))) {
				duplicateRemovedList.add(lines.get(0));
			}else {
				detailsOfDuplicateMap.put(lines.get(0), detailsOfDuplicateMap.get(lines.get(0))==null? String.valueOf(i+1):
					detailsOfDuplicateMap.get(lines.get(0))+","+String.valueOf(i+1));
			}
		}
		
		System.out.println(detailsOfDuplicateMap);
		
		Path writeFilePath=Paths.get(jfile.getSelectedFile().getParent()+"\\updated.txt");
	  
		Files.write(writeFilePath, duplicateRemovedList, StandardCharsets.UTF_8);
		
		System.out.println("End!!!!!!!!!!!!!");
		
	}

}
