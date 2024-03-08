

public class HashTagTokenizer {

	public static void main(String[] args) {
	
		String hashTag = "iloveyou";
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		//System.out.println(existInDictionary("hey", dictionary)); 
		//printArray(readDictionary("dictionary.txt"));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		
		for (int i = 0; i < dictionary.length; i++) {
			String word = in.readLine();
			dictionary[i] = word; 
		}

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		for (int i = 0; i < dictionary.length; i++) {
			if (word.equals(dictionary[i])) {
				return true;
			}
		} 
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
      
		if (hashtag.isEmpty()) {
            return;
        }
		hashtag = hashtag.toLowerCase();
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) {
			if (existInDictionary(hashtag.substring(0, i), dictionary)) {
				System.out.println(hashtag.substring(0, i));
				breakHashTag(hashtag.substring(i), dictionary);
			}
		
        }
    }

	public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
         }
	}

}
