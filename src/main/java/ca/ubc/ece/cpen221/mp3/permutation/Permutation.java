package ca.ubc.ece.cpen221.mp3.permutation;

// add class overview

import java.util.*;

/* Representation Invariant: a Permutation object is created with a baseList to permute and keeps track of all possible permutations of that list
the number of permutations should be equal to the factorial of the size of the input list
* Abstraction Function: given a list to permute, finds all possible permutations*
*/

public class Permutation<T> implements AbstractPermutation<T> {

	// you may need more here
	Set<List<T>> allPermutations;
	List<T> aPermutation;
	Stack<List<T>> wrapPermutations;

	/**
	 * Create a permutation generator with a given list that will be
	 * permuted
	 * @param baseList is not empty
	 */
	public Permutation(List<T> baseList) {
		aPermutation=baseList;
		allPermutations= new HashSet<>();
		wrapPermutations= new Stack<List<T>>();
		//wrapPermutations.push(aPermutation);
	}

	/**
	 * Check if there is another permutation that has not yet been explored
	 * @return true if there is a permutation that has not been returned yet,
	 *          and false if all permutations have been returned
	 */
	@Override
	public boolean hasNext() {
		return !wrapPermutations.isEmpty();
	}

	/**
	 * Obtain the next permutation to explore,
	 * with the precondition that hasNext() returns true
	 *
	 * @return the next permutation to explore
	 */
	@Override
	public List<T> next() {
		return wrapPermutations.pop();
	}

	/**
	 * @return set containing all permutations that can be obtained from a given list
	 */
	public Set<List<T>> getAllPermutations(){
		Set<List<T>> copy= new HashSet<>();
		copy.addAll(allPermutations);
		return copy;
	}

	/**
	 * starts the permutation on the given list
	 */
	public void permuteAll(){
		permute(aPermutation, 0,aPermutation.size()-1);
	}
	/**
	 * @param myList list to be permuted
	 * @param start start index in myList to compute permutations
	 * @param end end index in myList to compute permutations
	 * @return Cryptarithm to be solved
	 */
	public void permute(List<T> myList, int start, int end){
		if(start==end){
			allPermutations.add(new ArrayList<T>(myList));
			wrapPermutations.push(new ArrayList<T>(myList));
		}
		else{
			for(int i=start; i<=end; i++){
				myList= swap(myList, start, i);
				permute(myList,start+1, end );
				myList = swap(myList, start, i);
			}
		}
	}
	private List<T> swap(List<T> myList, int start, int end){
		List<T> tempList = myList;
		T temp= tempList.get(start);
    	/*tempList.add(start, tempList.get(end)); //add end to start
    	tempList.add(end, temp); //add start to end*/
		//Added here

		tempList.set(start, tempList.get(end));
		tempList.set(end, temp);
		//Until here
		return tempList;
	}

}