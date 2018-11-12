package ca.ubc.ece.cpen221.mp3.cryptarithm;

import ca.ubc.ece.cpen221.mp3.expression.BinaryExpression;
import ca.ubc.ece.cpen221.mp3.expression.Expression;
import ca.ubc.ece.cpen221.mp3.expression.VariableExpression;
import ca.ubc.ece.cpen221.mp3.operator.*;
import ca.ubc.ece.cpen221.mp3.parser.ExpressionMaker;
import ca.ubc.ece.cpen221.mp3.permutation.Permutation;

import java.util.*;

/* Representation Invariant: a valid Cryptarithm object is composed of at most 10 different letters,
 is composed of one more words than there are operators,
 and is composed of exactly one equals sign
* Abstraction Function: given an equation composed of words, finds numerical values for letters so that the equation could be solved, and returns all possible mappings*
*/

/**
 * Cryptarithm - a datatype that represents a cryptarithm
 *
 */
public class Cryptarithm {

	//CONVERT HELPER METHODS TO PRIVATE

	/**
	 * Cryptarithm constructor
	 *
	 * @param cryptarithm
	 *            where each element is a String that represents part of the
	 *            cryptarithm
	 */

	private static List<String> leftElements; //everything to the left of =
	private static List<String> rightElements; //everything to the right of =
	private static List<String> uniqueLetters; //to map to digits in solve
	private static List<Integer> numbers;
	private static Set<List<Integer>> numberSubLists;
	private static List<Character> firstLetters;


	/**
	 * @param cryptarithm string array representing the contents of the cryptarithm
	 * @return Cryptarithm to be solved
	 *
	 */
	public Cryptarithm(String[] cryptarithm){
		leftElements=new ArrayList<>();
		rightElements= new ArrayList<>();
		uniqueLetters=new ArrayList<>();
		numbers=new ArrayList<>();
		numberSubLists=new HashSet<>();
		firstLetters= new ArrayList<>();

		if(!isValid(cryptarithm) || cryptarithm.length==0) {
			throw new IllegalArgumentException();
		}
		else{
			int equals= Arrays.asList(cryptarithm).indexOf("=");
			int i=0;
			while(i<equals){
				leftElements.add(cryptarithm[i]);
				i++;
			}
			int j= equals+1;
			while(j<cryptarithm.length){
				rightElements.add(cryptarithm[j]);
				j++;
			}
			numbers.add(0); numbers.add(1); numbers.add(2); numbers.add(3); numbers.add(4); numbers.add(5); numbers.add(6); numbers.add(7); numbers.add(8); numbers.add(9);
			for(String s:leftElements){
				if(Character.isLetter(s.charAt(0))){
					firstLetters.add(s.charAt(0));
				}
			}
			for(String s: rightElements){
				if(Character.isLetter(s.charAt(0))){
					firstLetters.add(s.charAt(0));
				}
			}
		}
	}
	//modifies uniqueLetters list to have all unique letters
	private boolean isValid(String[] cryptarithm){
		int numWords=0; int numOperators=0; int numEquals=0;
		int i=0;
		List<Character> characters= new ArrayList<>();
		while(i<cryptarithm.length){
			int j=0;
			//if it is a letter enter a loop
			//else just add as an operator
			Character next= cryptarithm[i].charAt(j);
			if(Character.isLetter(next)){
				while(j<cryptarithm[i].length()) {
					next=cryptarithm[i].charAt(j);
					if (!characters.contains(next)) {
						characters.add(next);
						uniqueLetters.add(Character.toString(next));
					}
					j++;
				}
				numWords++;
			}
			else{
				numOperators++;
				if(next.equals('=')){
					numEquals++;
				}
			}
			i++;
		}
		if(uniqueLetters.size()>10 || uniqueLetters.size()<=0) return false;
		if(numEquals!=1) return false;
		if(numWords!=1+numOperators) return false;
		return true;
	}

	private static void getDigitSubsets(List<Integer> sequence, int index, Set<List<Integer>> subsequences, List<Integer> current){
		//sequence: pass numbers, subsequences: numberSubLists
		if(current.size()== uniqueLetters.size()){ //ONLY THE SUBLISTS OF A GIVEN LENGTH
			subsequences.add(current);
		}
		if(index>=sequence.size()) return;
		else{
			int element= sequence.get(index);
			//pass two different List<Integer>s that are made up of current(what we have accumulated so far)
			//add the new element to ONE of them
			List<Integer> list1= new ArrayList<>(current);
			List<Integer> list2= new ArrayList<>(current); list2.add(element);
			getDigitSubsets(sequence,index+1,subsequences,list1);
			getDigitSubsets(sequence,index+1, subsequences,list2);
		}
	}

	/**
	 * Find solutions to the cryptarithm
	 *
	 * @return a list of all possible solutions to the given cryptarithm. A
	 *         solution is a map that provides the value for each alphabet in
	 *         the cryptarithm.
	 */
	public List<Map<Character, Integer>> solve() throws NoSolutionException {
		getDigitSubsets(numbers, 0, numberSubLists, new ArrayList<>());
		List<Map<Character, Integer>> wholeMap= new ArrayList<>();
		//Set<List<Integer>> toPermute= helperForSubLists();
		//at this point numberSubLists contains all of List<Integer>s that we want to permute
		Set<List<Integer>> oneResult= new HashSet<>();
		for(List<Integer> toPerm: numberSubLists){ //onePerm is supposed to be one set of given numbers; that we now need to get all permutations of
			Permutation<Integer> perm= new Permutation(toPerm);
			perm.permuteAll();
			oneResult= perm.getAllPermutations(); //set of permutations of the given list
			List<Map<Character,Integer>> map= assignToLetters(oneResult); //map is all working results of a given permutation list
			for(Map<Character,Integer> m: map){
				wholeMap.add(m);
			}
		}
		if(wholeMap.size()==0) throw new NoSolutionException();
		return wholeMap;
	}

	private List<Map<Character, Integer>> assignToLetters(Set<List<Integer>> result){
		//assignToLetters returns all maps from a given option list
		List<Map<Character, Integer>> wholeMap= new ArrayList<>();
		for(List<Integer> oneOption: result){
			Map<Character, Integer> newMap= new HashMap<>();
			for(int i=0; i<oneOption.size(); i++){
				newMap.put(uniqueLetters.get(i).charAt(0),oneOption.get(i));
				//for each map, send to formMapping
			}
			boolean flag=true;
			for(Character c: firstLetters){
				if(newMap.get(c)==0){
					flag=false;
				}
			}
			if(flag){
				if(formMapping(newMap)){
					wholeMap.add(newMap);
				}
			}
		}
		return wholeMap;
	}

	private boolean formMapping(Map<Character, Integer> newMap) {
		//given a mapping from char to int, it needs to assign the integers to right and left characters
		List<Expression> leftExpressions = new ArrayList<>();
		List<Expression> rightExpressions = new ArrayList<>();
		List<BinaryOperator> leftOperators = new ArrayList<>();
		List<BinaryOperator> rightOperators = new ArrayList<>();
		double wordValue = 0;
		double leftResult = 0;
		double rightResult = 0;


		for (int i = 0; i < leftElements.size(); i++) {
			String word = leftElements.get(i);
			if (!checkOperator(word)) {
				for (int j = 0; j < word.length(); j++) {
					int val = newMap.get(word.charAt(j));
					double assign = val * Math.pow(10, word.length() - j - 1);
					wordValue = assign + wordValue;
				}
				VariableExpression oneWord = new VariableExpression(word);
				oneWord.store(wordValue);
				leftExpressions.add(oneWord);
				wordValue = 0;
			} else {
				switch (word) {
					case "+":
						leftOperators.add(new AdditionOperator());
						break;
					case "-":
						leftOperators.add(new SubtractionOperator());
						break;
					case "*":
						leftOperators.add(new MultiplicationOperator());
						break;
					case "/":
						leftOperators.add(new DivisionOperator());
						break;
				}
			}
		}

		for(int i=0; i<rightElements.size(); i++){
			String word= rightElements.get(i);
			if(!checkOperator(word)){
				for(int j=0; j<word.length(); j++){
					int val= newMap.get(word.charAt(j));
					double assign= val * Math.pow(10, word.length()-j-1);
					wordValue= assign+wordValue;
				}
				VariableExpression oneWord= new VariableExpression(word);
				oneWord.store(wordValue);
				rightExpressions.add(oneWord);
				wordValue=0;
			}
			else{
				switch(word){
					case "+":
						rightOperators.add(new AdditionOperator());
						break;
					case "-":
						rightOperators.add(new SubtractionOperator());
						break;
					case "*":
						rightOperators.add(new MultiplicationOperator());
						break;
					case "/":
						rightOperators.add(new DivisionOperator());
						break;
				}
			}
		}
		leftResult=evaluateMapping(leftExpressions,leftOperators);
		rightResult=evaluateMapping(rightExpressions,rightOperators);
		if(leftResult==rightResult) return true;
		return false;

	}

	private double evaluateMapping(List<Expression> expressions, List<BinaryOperator> operators){
		if(expressions.size()==1) return expressions.get(0).eval();
		ExpressionMaker maker= new ExpressionMaker();
		Expression e= maker.createBinaryOperationExpression(operators.get(0), expressions.get(0),expressions.get(1));
		for(int i=2; i<expressions.size(); i++){
			e= maker.createBinaryOperationExpression(operators.get(i-1), e, expressions.get(i));
		}
		return e.eval();
	}

	private boolean checkOperator(String s){
		return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/");
	}
}