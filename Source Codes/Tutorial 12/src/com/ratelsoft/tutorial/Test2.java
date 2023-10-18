package com.ratelsoft.tutorial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Test2 {
	public static void main(String[] args){
		/*
		File folder = new File("C:\\Users\\Richboy\\workspar\\Tutorial 12\\bin\\com\\ratelsoft\\tutorial");
		
		File f = null;
		try{
			f = new File(folder, "image.png");
			f.getParentFile().mkdirs();
			f.createNewFile();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(f.getAbsolutePath());
		*/
		
		File newFile = new File("C:\\Users\\Richboy\\Documents\\Ratelsoft\\IT Students 2015\\dump\\test2.txt");
		
		try{
			/*
			Scanner input = new Scanner(newFile);
			while(input.hasNextLine())
				System.out.println(input.nextLine());
			*/
			
			/*
			BufferedReader reader = new BufferedReader(new FileReader(newFile));
			String line;
			while( (line = reader.readLine()) != null ){
				System.out.println(line);
			}
			
			reader.close();
			*/
			
			/*
			String text = new String(Files.readAllBytes(newFile.toPath()));
			System.out.println(text);
			*/
			
			String text = "\r\n\r\nthis is what i want\r\nto write\r\n\r\nthis should give two line space";
			Files.write(newFile.toPath(), text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}