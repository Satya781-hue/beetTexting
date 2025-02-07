package com.beetexting.code;

import java.util.Arrays;

public class AlternateMergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {3, 1, 2}; // Unsorted first array
        int[] arr2 = {6, 5, 4}; // Unsorted second array

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] mergedArray = mergeAlternating(arr1, arr2);

        System.out.println("Merged Array: " + Arrays.toString(mergedArray));
    }

    public static int[] mergeAlternating(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] mergedArray = new int[n1 + n2];

        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            mergedArray[k++] = arr1[i++]; // Take one from arr1
            mergedArray[k++] = arr2[j++]; // Take one from arr2
        }

        while (i < n1) {
            mergedArray[k++] = arr1[i++];
        }

        while (j < n2) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }
}
