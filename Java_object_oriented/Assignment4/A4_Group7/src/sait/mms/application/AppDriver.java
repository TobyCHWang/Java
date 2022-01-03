package sait.mms.application;

import java.sql.SQLException;

import sait.mms.managers.MovieManagementSystem;

/**
 * Assignment 4 Problem: 
 * You are tasked with modifying the movie management system to work with a relational database system. 
 * You’re required to connect to and perform queries on a MariaDB database running on your computer.
 * @author  Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version August 08, 2021
 * This class is for app drive
 * 
 */

public class AppDriver {
	public static void main(String[] args) throws SQLException {
		
		new MovieManagementSystem();
		
	}
}
