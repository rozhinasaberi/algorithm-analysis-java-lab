package com.exercise3.rojina.saberi;

public class Exercise3 {

    public static int findNonTwoSum(int[] A) {
        if (A == null || A.length == 0) {
            return 0; 
        }

        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

  
        return 2 * max + 1;
    }

    // helper method 
    public static boolean canBeTwoSum(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (A[i] + A[j] == target) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       
        //Rojina Saberi
    	//301533334

        int[] A = {3, 10, -2, 7, 4};

        int answer = findNonTwoSum(A);

        System.out.println("Answer (cannot be formed as sum of two numbers): " + answer);
        System.out.println("Check (should be false): " + canBeTwoSum(A, answer));
    }
}
