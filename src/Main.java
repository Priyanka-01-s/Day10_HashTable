public class Main {
    public static void main(String[] args) {
        System.out.println("HASHMAP TO CALCULATE WORD OCCURANCE\n");
        //String text = "To be or not to be";
        
        String paragraph = "Paranoids are not paranoid because they are paranoid but "
                + "because they keep putting themselves deliberately into paranoid avoidable situations";
        
        //clean and processed text
        String[] words = TextFormatting.cleanTexts(paragraph);

        WordCounter wordCounter = new WordCounter();
        wordCounter.processWords(words);

        // Display word frequencies
        wordCounter.displayWordFrequencies();

        // Remove the word "avoidable"
        wordCounter.removeWord("avoidable");

        // Display word frequencies after removal
        System.out.println("\nAfter removing 'avoidable':");
        wordCounter.displayWordFrequencies();

        
    }

    
}
