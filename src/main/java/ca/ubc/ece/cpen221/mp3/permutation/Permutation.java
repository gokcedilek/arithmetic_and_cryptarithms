package ca.ubc.ece.cpen221.mp3.permutation;

// add class overview

import java.util.*;

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
        wrapPermutations= (Stack)(allPermutations);
    }

	@Override
	public boolean hasNext() {
		return !wrapPermutations.isEmpty();
	}

	@Override
	public List<T> next() {
		return wrapPermutations.pop();
	}

	public Set<List<T>> getAllPermutations(){
    	Set<List<T>> copy= new HashSet<>();
    	copy.addAll(allPermutations);
    	return copy;
	}
	public void permuteAll(){
    	permute(aPermutation, 0,aPermutation.size());
	}

	public void permute(List<T> myList, int start, int end){
    	if(start==end){
    		allPermutations.add(myList);
		}
		else{
			for(int i=start; i<end; i++){
				myList= swap(myList, start, i);
				permute(myList,start+1, end );
			}
		}
	}
	private List<T> swap(List<T> myList, int start, int end){
    	List<T> tempList= myList;
    	T temp= tempList.get(start);
    	tempList.add(start, tempList.get(end)); //add end to start
    	tempList.add(end, temp); //add start to end
		return tempList;
	}
	
}
