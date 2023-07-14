import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;
import java.util.Arrays;

class Solution {

    public int findMaxLength(int[] nums) {
        //Separates 1's and 0's into two arrays
        ArrayList<Integer> countOnes = new ArrayList<>();
        ArrayList<Integer> countZeroes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                countOnes.add(i);
            } else {
                countZeroes.add(i);
            }
        }

        //Make countOne and countZero same size array
        int excess = Math.max(countZeroes.size(), countOnes.size()) - Math.min(countZeroes.size(), countOnes.size());
        ArrayList<ArrayList<Integer>> allPossibleCuts = new ArrayList<>(excess + 1);

        if (countZeroes.size() < countOnes.size()) {
            //Creates an array of arrays of all possible cuts of countOnes
            for (int i = 0; i < excess + 1; i++) {
                //Step i=0: 0 -> countOnes.Size()-excess; Step i: shifts initial array to the right by i
                allPossibleCuts.add(new ArrayList<>(countZeroes.subList(i, (countZeroes.size() - excess + i))));
            }
            //call function to find longest connected subarray

        } else if (countZeroes.size() > countOnes.size()) {
            //Creates an array of arrays of all possible cuts of countZeros
            for (int i = 0; i < excess + 1; i++) {
                //Step i=0: 0 -> countZeros.Size()-excess; Step i: shifts initial array to the right by i
                allPossibleCuts.add(new ArrayList<>(countOnes.subList(i, (countOnes.size() - excess + i))));
            }

        } else if (countZeroes.size() == countOnes.size()) {
            //we are done. return nums.length()
        }
    }

    public

        //JUNK//

        //Create an array of connected subarrays, and finds the longest one
       /* ArrayList<ArrayList<Integer>> connectedArrays = new ArrayList<>();
        for (int i=0; i<arrayPossible.size(); i++){
        ArrayList<Integer> temp = new ArrayList<>();
            temp.add(arrayPossible.get(i).get(0));
            for (int j=1; j<arrayPossible.get(i).size(); j++){
                if (arrayPossible.get(i).get(j) == arrayPossible.get(i).get(j-1)+1){
                    temp.add(arrayPossible.get(i).get(j));
                } else {
                    connectedArrays.add(temp);
                    temp.clear();
                    temp.add(arrayPossible.get(i).get(j));
                }
            }
            connectedArrays.add(temp);
        }*/

       /* //Find the longest connected subarray
        int longest = 0;
        for (int i=0; i<connectedArrays.size(); i++){
            if (connectedArrays.get(i).size() > longest){
                longest = connectedArrays.get(i).size();
            }
        }

        return longest;*/


