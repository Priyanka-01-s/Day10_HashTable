import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("HASHMAP TO CALCULATE WORD OCCURANCE\n");
        String text = "To be or not to be";
        
    
        String[] words = TextFormatting.cleanTexts(text);

        Map<Integer, LinkedList<Node>> hashMap = new HashMap<>();

        for(String word: words){
            int hash = HashWordCount.getHash(word);
            if(!hashMap.containsKey(hash)){
                hashMap.put(hash, new LinkedList<>());
            }

            LinkedList<Node> linkedList = hashMap.get(hash);

            Node existingNode = HashWordCount.CountNodeByKey(linkedList, word);

            if(existingNode != null){
                existingNode.value++;
            }else{
                linkedList.add(new Node(word,1));
            }
        }

        for (Map.Entry<Integer, LinkedList<Node>> entry : hashMap.entrySet()) {
            LinkedList<Node> linkedList = entry.getValue();
            for (Node node : linkedList) {
                System.out.println(node.key + ": " + node.value);
            }
        }

        
    }

    
}
