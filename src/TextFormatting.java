public class TextFormatting {

    //making the text lowercase and removing the white spaces from the text
    public static String[] cleanTexts(String text){
        String resText = text.toLowerCase();
        return resText.split("\\s");                 

    }    
}
