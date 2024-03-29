
public class SpellChecker {


	public static void main(String[] args) {
		String word = "coooool";
		int threshold = 3;
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
		//String word1 = "concensus";
		//String word2 = "consensus"; 
		
	}

	public static String tail(String str) {
		str = str.substring(1);
		return str; 
	}

	public static int levenshtein(String word1, String word2) {
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase(); 

		if (word1.length() == 0) {
			return word2.length();
		}
		if (word2.length() == 0) {
			return word1.length();
		}
		if (word1.charAt(0) == word2.charAt(0)) {
			return levenshtein(tail(word1), tail(word2)); 
		} 
		int a = levenshtein(tail(word1), word2);
		int b = levenshtein(word1, tail(word2)); 
		int c = levenshtein(tail(word1), tail(word2)); 
		
		return 1 + Math.min(Math.min(a, b), c); 
	}
		 
	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In fileIn = new In(fileName);
		
		for (int i = 0; i < dictionary.length; i++) {
			String word = fileIn.readLine();
			dictionary[i] = word; 
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) { 
		int min = 0; 
		for (int i = 1; i < dictionary.length; i++) {
			if (levenshtein(word, dictionary[i]) < levenshtein(word, dictionary[min])) {
				min = i; 
			}	
		}
		if (levenshtein(word, dictionary[min]) <= threshold) {
			return dictionary[min];
		}
		return word; 
	}

}
