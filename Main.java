package fourth;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        permutation("cat");
    }
    public static void permutation(String input){
        List<Character> chars = new ArrayList<>();
        for(int i=0; i<input.length() ; i++)
            chars.add(input.charAt(i));
        Map<String , Integer> results = new HashMap<>();
        permutation(chars , new ArrayList<>() , results);
        System.out.println(results.keySet());

    }
    private static void permutation(List<Character> input, List<Character> output, Map<String , Integer> results ){
        if(input.isEmpty()){
            StringBuilder stringBuilder= new StringBuilder();
            for(char c : output)
                stringBuilder.append(c);
            String result = stringBuilder.toString();
            if(results.containsKey(result)){
                results.put(result, results.get(result)+1);
            }else
                results.put(result, 1);
            return;
        }
        for( int i=0; i < input.size() ; i++){
            List<Character> newInput = new ArrayList<>(input);
            List<Character> newOutput = new ArrayList<>(output);
            char c = newInput.remove(i);
            newOutput.add(c);
            permutation(newInput,newOutput,results);
        }
    }
}
