import java.util.Arrays;

/*
 * You are required to use the given `dict` array to implement the methods.
 * See test_one_array_implementation_insert and test_one_array_implementation_remove 
 * in class TestArrayImplementations.
 *
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class OneArrayDictionary implements Dictionary {

	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict;

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
	public OneArrayDictionary() {
		dict = new WordDefinitionPair[MAX_CAPACITY];
	}

	@Override
	public int size() {
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		String definition = null;
		boolean wordExist = false;
		
		for (int i = 0; i < this.count; i++) {
			if (word.equals(this.dict[i].getWord())) {
				wordExist = true;
				definition = this.dict[i].getDefinition();
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
		
		if (this.count >= MAX_CAPACITY) {
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
		
		this.dict[this.count] = new WordDefinitionPair(word, definition);

		this.count++;
	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		int indexToRemove = 0;
		String definition = null;
		boolean wordExist = false;

		for (int i = 0; i < this.count; i++) {
			if (word.equals(this.dict[i].getWord())) {
				indexToRemove = i;
				wordExist = true;
				definition = this.dict[i].getDefinition();
			}
		}
		
		if (!wordExist) {
			throw new WordNotInDictionaryException("Word is not in the dictionary!");
		}

		for (int i = indexToRemove; i < this.count; i++) {
			this.dict[i] = this.dict[i + 1];
		}

		this.count--;

		return definition;
	}

	@Override
	public String[] getWords() {

		String[] words = new String[this.count];

		for (int i = 0; i < this.count; i++) {
			words[i] = this.dict[i].getWord();
		}
		return words;
	}

	@Override
	public String[] getDefinitions() {
		String[] definition = new String[this.count];

		for (int i = 0; i < this.count; i++) {
			definition[i] = this.dict[i].getDefinition();
		}
		return definition;
	}

	@Override
	public WordDefinitionPair[] getEntries() {
		// TODO Auto-generated method stub
		WordDefinitionPair[] entries = new WordDefinitionPair[this.count];
		
		entries = Arrays.copyOf(this.dict, this.count);
		
		return entries;
	}

}
