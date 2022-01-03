package sait.mms.managers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import sait.mms.drivers.MariaDBDriver;

/**
 * This class is for methods.
 * 1. display Menu
 * 2. addMovie
 * 3. print Random Movies
 * 4. delete Movie
 * 5.print Movies In Year
 * 
 * @author  Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version August 08, 2021
 *
 * 
 */


public class MovieManagementSystem {
	MariaDBDriver md;
	private int id;
	private String title;
	private int duration;
	private int year;
	private int number;
	private boolean errorMessage;
	private ResultSet result;
	private Scanner userInput;
	
	public MovieManagementSystem() throws SQLException {
		displayMenu();
		
	}
	

	/**
	 * execute method
	 * display menu and choose the option
	 * 1. add movie
	 * 2. print movies in released year
	 * 3. print random list movie
	 * 4. delete movie 
	 * 5. exit
	 */
	public void displayMenu() {
		md = new MariaDBDriver();
		
		try {
			md.connect();
		} catch (SQLException e) {
			e.getMessage();
		}
		System.out.println("Movie Manager");
		System.out.println("1 \t Add New Movie");
		System.out.println("2 \t Print movies released in year");
		System.out.println("3 \t Print random list of movies");
		System.out.println("4 \t Delete a movie");
		System.out.println("5 \t Exit");
		
		userInput = new Scanner(System.in);
		int choice = 0;
		errorMessage=false;
		do {
			errorMessage=false;
		try {
		System.out.println();
		System.out.print("Enter option: ");
		choice=userInput.nextInt();
		userInput.nextLine();
		while(choice!=5) {
			switch(choice) {
			case 1:
				addMovie();
				break;
			case 2:
				printMoviesInYear();
				break;
			case 3:
				printRandomMovies();
				break;
			case 4:
				deleteMovie();
				break;
			default:
				System.out.println("Please enter a option between 1 - 5.");
				System.out.println();
				break;
			}
			System.out.println("Movie Manager");
			System.out.println("1 \t Add New Movie");
			System.out.println("2 \t Print movies released in year");
			System.out.println("3 \t Print random list of movies");
			System.out.println("4 \t Delete a movie");
			System.out.println("5 \t Exit");
			System.out.println();
			System.out.print("Enter option: ");
			
			choice=userInput.nextInt();
			userInput.nextLine();
		}
		
		try {
			md.connect();
		} catch (SQLException e) {
			System.out.println("ERROR"+e.getMessage());
		}
		System.out.println();
		
		System.out.println("Goodbye!");
		System.exit(0);
		return;
		}catch (InputMismatchException e) {
			System.out.println("You enter wrong option or data type, Please start from the beginning option.");
			errorMessage=true;
			userInput.nextLine();
		}
		}while(errorMessage);

		
		
	}
	
	/**
	 * add movies into database
	 * enter movie title
	 * enter duration
	 * enter year
	 */
	public void addMovie() {
		System.out.print("Enter movie title: ");
		title = userInput.nextLine();
		System.out.print("Enter duration: ");
		duration = userInput.nextInt();
		System.out.print("Enter year: ");
		year = userInput.nextInt();
		/*int id, int duration, String title, String year*/
		String sqlStatement = "INSERT INTO movies (duration, title, year) " +"VALUES "
				+ "(" + duration + ", '" + title + "', " + year + ")";
		try {
			md.update(sqlStatement);
			System.out.println("Added movie to database.");
			System.out.println();
		} catch (SQLException e) {
			System.out.println("ERROR"+e.getMessage());
		}
	}
	
	/**
	 * print Movies In Year
	 * enter year of movies you want to show
	 * show list and duration 
	 */
	
	public void printMoviesInYear() {
		
		duration=0;
		System.out.println();
		System.out.print("Enter in year: ");
		
		year=userInput.nextInt();
		
		String sqlStatement="SELECT * FROM movies " +  "WHERE year = " + year;
		try {
			result = md.get(sqlStatement);
			System.out.println();
			System.out.println("Movie List");
			System.out.printf("%-10s %-5s %-50s%n", "Duration", "Year", "Title");
			
			while (result.next()) {
				duration += result.getInt("Duration");
				System.out.printf("%-10d %-5d %-50s%n",result.getInt("Duration"),
						result.getInt("Year"),result.getString("Title"));
			}
			System.out.println();
			System.out.println("Total duration minutes: "+duration);
			System.out.println();
		}catch (SQLException e) {
			System.out.println("ERROR"+e.getMessage());
	}
		
		
	}
	
	/**
	 * print Random Movies
	 * enter number of movies you want to show
	 * show list and duration 
	 */
	
	public void printRandomMovies() {
		System.out.println();
		System.out.print("Enter number of movies: ");
		number=userInput.nextInt();
		String sqlStatement= "SELECT * FROM movies "+"ORDER BY RAND() "+ "LIMIT " + number;
		duration = 0;
		System.out.println();
		
		try {
			result = md.get(sqlStatement);
			System.out.println("Movie List");
			System.out.printf("%-10s %-5s %-50s%n", "Duration", "Year", "Title");
			
			while (result.next()) {
				duration += result.getInt("Duration");
				System.out.printf("%-10d %-5d %-50s%n",result.getInt("Duration"),
						result.getInt("Year"),result.getString("Title"));
			}
			System.out.println();
			System.out.println("Total duration minutes: "+duration);
			System.out.println();
		}catch (SQLException e) {
			System.out.println("ERROR"+e.getMessage());
	}
		
		
		/*SELECT * FROM table_name
		ORDER BY RAND()
		LIMIT 1;*/
		
	}
	
	/**
	 * delete Movie
	 * enter id of movies you want to delete
	 */
	public void deleteMovie(){
		/*int id*/
		System.out.println();
		System.out.print("Enter movie ID that you want to delete: ");
		try {
		id=userInput.nextInt();
		String sqlStatement = "DELETE FROM movies " + "WHERE id = " + id;	
		
			try {
				md.update(sqlStatement);
			} catch (SQLException e) {
				System.out.println("ERROR"+e.getMessage());
			}
			System.out.println();
			System.out.println("Movie " + id+" is deleted.");
			System.out.println();
			} catch (InputMismatchException e) {
				System.out.println("You enter wrong option or data type, Please start from the beginning option.");
				errorMessage=true;
		}
	}
 }
