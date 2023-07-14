import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;

//testing 

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

        if (countOnes.size() == 0 || countZeroes.size() == 0){
            return 0;
        }

        int cutSize = Math.min(countZeroes.size(), countOnes.size());
        boolean isConnected = false;

        if (countZeroes.size() - countOnes.size() == 0) {
            return nums.length;
        } else {
            while (isConnected == false) {
                isConnected = isContiguous(cut(countOnes, cutSize), cut(countZeroes, cutSize));
                if (isConnected == false) {
                    cutSize = cutSize - 1;
                } else {
                    break;
                }
            }
            return 2 * cutSize;
        }
    }

    public ArrayList<ArrayList<Integer>> cut(ArrayList<Integer> cutThis, int cutSize) {
        //creates all cuts of cutThis of size cutSize
        ArrayList<ArrayList<Integer>> allPossibleCuts = new ArrayList<>();
        int excess = cutThis.size() - cutSize;
        for (int i = 0; i < excess + 1; i++) {
            allPossibleCuts.add(new ArrayList<>(cutThis.subList(i, (cutSize + i))));
        }
        return allPossibleCuts;
    }

    public boolean isContiguous(ArrayList<ArrayList<Integer>> allPossible1, ArrayList<ArrayList<Integer>> allPossible2) {
        ArrayList<ArrayList<Integer>> mergedIndices = new ArrayList<>();

        for (int i = 0; i < allPossible1.size(); i++) {
            for (int j = 0; j < allPossible2.size(); j++) {
                //merge ith of 1 and jth of 2 into  mergedIndices
                ArrayList<Integer> temp = new ArrayList<>();
                temp.addAll(allPossible1.get(i));
                temp.addAll(allPossible2.get(j));
                Collections.sort(temp);
                mergedIndices.add(temp);

                //check if ijth entry of mergedIndices is connected
                for (int k = 0; k <= temp.size() - 2; k++) {
                    if ((temp.get(k + 1)) - temp.get(k) != 1) {
                        break;
                    }
                    if (k == temp.size() - 2) {
                        return true;
                    }
                }
            }
        }
        return false;


    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] nums = {0};
        System.out.println(s.findMaxLength(nums));
    }

}



/*  if (countZeroes.size() < countOnes.size()) {
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
    }*/

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

