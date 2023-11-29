import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WordCounter {
    // Hash table to store word frequencies
    private Map<Integer, LinkedList<Node>> hashMap;

    public WordCounter() {
        this.hashMap = new HashMap<>();
    }

    // Method to process words and update frequencies
    public void processWords(String[] words) {
        for (String word : words) {
            int hash = HashWordCount.getHash(word);
            // Check if the hash is already a key 
            if (!hashMap.containsKey(hash)) {
                hashMap.put(hash, new LinkedList<>());
            }

            LinkedList<Node> linkedList = hashMap.get(hash);

            // Check if the word is already in the list
            Node existingNode = HashWordCount.CountNodeByKey(linkedList, word);

            if (existingNode != null) {
                //increment value, if found
                existingNode.value++;
            } else {
                //if not add the new node to the linkedlist
                linkedList.add(new Node(word, 1));
            }
        }
    }

    // Method to remove a specific word from the hash table
    public void removeWord(String wordToRemove) {
        for (LinkedList<Node> linkedList : hashMap.values()) {
            Node nodeToRemove = HashWordCount.CountNodeByKey(linkedList, wordToRemove);
            if (nodeToRemove != null) {
                linkedList.remove(nodeToRemove);
            }
        }
    }

    // Method to display word frequencies
    public void displayWordFrequencies() {
        for (Map.Entry<Integer, LinkedList<Node>> entry : hashMap.entrySet()) {
            LinkedList<Node> linkedList = entry.getValue();
            for (Node node : linkedList) {
                System.out.println(node.key + ": " + node.value);
            }
        }
    }
}
