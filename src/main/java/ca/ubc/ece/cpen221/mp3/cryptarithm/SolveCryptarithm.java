package ca.ubc.ece.cpen221.mp3.cryptarithm;

import ca.ubc.ece.cpen221.mp3.expression.Expression;
import ca.ubc.ece.cpen221.mp3.operator.*;
import ca.ubc.ece.cpen221.mp3.parser.ExpressionMaker;
import ca.ubc.ece.cpen221.mp3.parser.ExpressionParser;

import java.util.*;

public class SolveCryptarithm {

	static public void main(String[] args) {

		String[] cryptarithm;

		Scanner scanner = new Scanner( System.in ) ;
		System.out.println("Enter a valid cryptarithm, with each token separated by one or more spaces: ");
		//if the user inputs an invalid cryptarithm, Illegal Argument Exception which is an unchecked exception will be thrown.
		//the reason for this choice is that the user should input a valid cryptarithm format that can be solved, the program can throw an unexpected exception if not.

		//args = scanner.nextLine().split(" ");
		try {
			Cryptarithm c= new Cryptarithm(args);
			List<Map<Character, Integer>> solutions= c.solve();
			for(Map<Character,Integer> solution: solutions){
				System.out.println(solution);
				System.out.printf("%n");
			}
		} catch (NoSolutionException e) {
			System.out.println("There are no solutions to this cryptarithm! ");
		}
	}
}