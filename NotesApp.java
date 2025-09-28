package com.elevatelabs.internship;


	import java.io.*;
	import java.util.Scanner;

	public class NotesApp {
	    private static final String FILE_NAME = "C:/Users/Dell/Desktop/note.txt.txt";
	    private static Scanner sc = new Scanner(System.in);

	    public static void main(String[] args) {
	        int choice;
	        do {
	            System.out.println("\n===== Notes App =====");
	            System.out.println("1. Add Note");
	            System.out.println("2. View Notes");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	            switch (choice) {
	                case 1 -> addNote();
	                case 2 -> viewNotes();
	                case 3 -> System.out.println("Exiting... Thank you!");
	                default -> System.out.println("nvalid choice! Try again.");
	            }
	        } while (choice != 3);
	    }

	    
	    private static void addNote() {
	        System.out.print("Enter your note: ");
	        String note = sc.nextLine();

	        try (FileWriter fw = new FileWriter(FILE_NAME, true)) { 
	            fw.write(note + System.lineSeparator());
	            System.out.println("Note saved successfully!");
	        } catch (IOException e) {
	            System.out.println("Error writing note: " + e.getMessage());
	        }
	    }

	    
	    private static void viewNotes() {
	        System.out.println("\n--- Your Notes ---");
	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            int count = 1;
	            while ((line = br.readLine()) != null) {
	                System.out.println(count++ + ". " + line);
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("No notes found. Please add some notes first.");
	        } catch (IOException e) {
	            System.out.println("Error reading notes: " + e.getMessage());
	        }
	    }
	}


