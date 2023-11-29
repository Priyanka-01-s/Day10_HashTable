import java.util.LinkedList;

public class HashWordCount {
   public static int getHash(String words){
    //creating a simple hash functions
    return words.hashCode();
   }

   public static Node CountNodeByKey(LinkedList<Node> linkedList, String key){
    for(Node node:linkedList){
        if(node.key.equals(key)){
            return node;
        }
    }
    return null;
   }

}
