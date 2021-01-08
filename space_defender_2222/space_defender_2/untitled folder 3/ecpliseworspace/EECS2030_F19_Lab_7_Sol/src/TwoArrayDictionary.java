import java.util.Arrays;

/* Make sure the instructions document is read carefully.
 * 
 * You are required to use the given `words` and `definitions` arrays to implement the methods.
 * See test_two_array_implementation_insert and test_two_array_implementation_remove 
 * in class TestArrayImplementations.
 * 
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class TwoArrayDictionary implements Dictionary {
	
	/*
	 * Use these attributes only to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; // number of entries in dictionary
	
	String[] words;
	String[] definitions;
	
	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
	
	public TwoArrayDictionary() {
		this.words = new String[MAX_CAPACITY];
		this.definitions = new String[MAX_CAPACITY];
	}

	@Override
	public int size() {
		
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		
		return this.count == 0;
	}

	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		String definition = null;
		boolean wordExist = false;
		
		for (int i = 0; i < this.count; i++) {
			if (word.equals(this.words[i])) {
				wordExist = true;
				definition = this.definitions[i];
			}
		}
		
		if (!wordExist) {
			throw new WordNotInDictionaryException("Word is not in the dictionary!");
		}
		
		return definition;
	}

	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		boolean wordExist = false;
		
		if (this.count == MAX_CAPACITY) {
			throw new DictionaryFullException("The dictionary is full");
		}
		
		for (int i = 0; i < getWords().length; i++) {
			if (word.equals(getWords()[i])) {
				wordExist = true;
			}
		}
		
		if (wordExist) {
			throw new WordAlreadyExistsInDictionaryException("Word already exists in dictionary!");
		}
		
		this.words[this.count] = word;
		this.definitions[this.count] = definition;
		this.count++;
		
	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub
		
		int positionToRemove = 0;
		String definition = null;
		boolean wordExist = false;
		
		for (int i = 0; i < this.count; i++) {
			if (word.equals(this.words[i])) {
				positionToRemove = i;
				wordExist = true;
				definition = this.definitions[i];
			}
		}
		
		if (!wordExist) {
			throw new WordNotInDictionaryException("Word is not in the dictionary!");
		}
		
		for (int i = positionToRemove; i < this.count; i++) {
			this.words[i] = this.words[i + 1];
			this.definitions[i] = this.definitions[i + 1];
		}
		
		this.count--;
		
		return definition;
	}

	@Override
	public WordDefinitionPair[] getEntries() {
		// TODO Auto-generated method stub
		WordDefinitionPair[] dict = new WordDefinitionPair[this.count];
		for (int i = 0; i < this.count; i++) {
			dict[i] = new WordDefinitionPair(this.words[i], this.definitions[i]);
		}
		return dict;
	}

	@Override
	public String[] getWords() {
		String[] currentWords = new String[this.count];
		
		currentWords = Arrays.copyOf(this.words, this.count);
		
		return currentWords;
	}

	@Override
	public String[] getDefinitions() {
		
		String[] allDefinitions = new String[this.count];
		
		allDefinitions = Arrays.copyOf(this.definitions, this.count);
		
		return allDefinitions;
	}

	
	
}
