import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) 
    {
    // Write your code here
    
        Map<Integer,Integer> pairsOfSocks = new HashMap<Integer,Integer>();
        
        for (int i=0; i<n; i++)
        {
            int currentColour = ar.get(i);
            
            if (pairsOfSocks.containsKey(currentColour))
            {
                int value = pairsOfSocks.get(currentColour);
                value++;
                pairsOfSocks.put(currentColour, value);
            }
            else
            {
                pairsOfSocks.put(currentColour, 1);
            }
            
        }
        
        Collection<Integer> values = pairsOfSocks.values();
        
        List<Integer> valuesList = new ArrayList<>(values);
        
        int numberOfPairs = 0;
        
        for (int j=0; j<values.size(); j++)
        {
            int currentValue = valuesList.get(j);
            int pairs = currentValue/2;
            
            numberOfPairs = numberOfPairs + pairs;
            
        }
        return numberOfPairs;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
