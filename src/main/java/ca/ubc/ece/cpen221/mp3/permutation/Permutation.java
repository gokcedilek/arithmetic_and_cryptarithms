package ca.ubc.ece.cpen221.mp3.permutation;

// add class overview

import java.util.List;

public class Permutation<T> implements AbstractPermutation<T> {

	// you may need more here

    /**
     * Create a permutation generator with a given list that will be
     * permuted
     * @param baseList is not empty
     */
    public Permutation(List<T> baseList) {
        // TODO implement this constructor
    }

	@Override
	public boolean hasNext() {
		// TODO implement this method
        return false;
	}

	@Override
	public List<T> next() {
		// TODO implement this method
		return null;
	}
	
}
