import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("HASHMAP TO CALCULATE WORD OCCURANCE\n");
        //String text = "To be or not to be";
        
        String paragraph = "Paranoids are not paranoid because they are paranoid but "
                + "because they keep putting themselves deliberately into paranoid avoidable situations";
        
        //clean and processed text
        String[] words = TextFormatting.cleanTexts(paragraph);

        // Hash table to store word frequencies
        Map<Integer, LinkedList<Node>> hashMap = new HashMap<>();

         // Process each word in the array
        for(String word: words){
            int hash = HashWordCount.getHash(word);
            // Check if the hash is already a key
            if(!hashMap.containsKey(hash)){
                hashMap.put(hash, new LinkedList<>());
            }

            LinkedList<Node> linkedList = hashMap.get(hash);

            // Check if the word is already in the list
            Node existingNode = HashWordCount.CountNodeByKey(linkedList, word);

            if(existingNode != null){
                //increment the value if found
                existingNode.value++;
            }else{
                //if not then add the new node to the linkedlist
                linkedList.add(new Node(word,1));
            }
        }

        //Displaying the words and the frequency
        for (Map.Entry<Integer, LinkedList<Node>> entry : hashMap.entrySet()) {
            LinkedList<Node> linkedList = entry.getValue();
            for (Node node : linkedList) {
                System.out.println(node.key + ": " + node.value);
            }
        }

        
    }

    
}
