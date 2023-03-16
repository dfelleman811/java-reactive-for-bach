package com.revature.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapOperation {
	
	public static void main(String[] args) {
		
		
		// suppose we have two streams
		
		Stream<String> a = Stream.of("Hello", "there!");
		Stream<String> b = Stream.of("Learning", "Java Streams");
		
		
		Stream<Stream<String>> c = Stream.of(a, b); // this isn't what we wanted...a stream of streams
		
		// instead we use flatmap
		Stream.of(a,b)
			.flatMap(e -> e); // Identity Function - takes an element and returns the same element
		
		// Useful for reading in text files...
		
		// create a Path object
		Path p = Paths.get("C:\\Users\\DanielFelleman\\OneDrive - revature.com\\Documents\\reactive-prep\\JavaStreamsDemo\\src\\main\\resources\\frankenstein.txt");
	

		// read the lines from the file
		try (Stream<String> frankenstein = Files.lines(p)) {
		
			// we have lines, but we want the words
			// the mapper function we use will return a stream of all the words from each line
			// the flatMap function will take that and return a stream of all the words from all the lines
			frankenstein
				.flatMap(line -> Arrays.stream(line.split(" ")))
				.forEach(System.out::println);
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
