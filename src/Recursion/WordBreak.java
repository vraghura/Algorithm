package Recursion;

/**
 * Created by vigneshwarraghuram on 10/12/17.
 */
public class WordBreak {


    private static String  dictionary[] = {"mobile","samsung","sam","sung",
            "man","mango","icecream","and",
            "go","i","like","ice","cream"};

    public static void main(String[] args) {

        System.out.println(wordBreak("ilikesamsung"));

    }

    private static boolean wordBreak(String input) {

        int size = input.length();

        if(size==0){
            return true;
        }

        for(int i=1; i<=size; i++){
            if(checkIfPresentInDictionary(input.substring(0,i)) && (wordBreak(input.substring(i,size)))){
                return true;

            }
        }
        return false;
    }

    private static boolean checkIfPresentInDictionary(String word){

        for(String a: dictionary){
            if(a.equals(word)){
                return true;
            }
        }
        return false;
    }


}
