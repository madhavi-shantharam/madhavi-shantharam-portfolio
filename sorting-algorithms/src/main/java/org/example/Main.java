package org.example;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        int[] copy;

        // Bubble Sort
        copy = Arrays.copyOf(arr, arr.length);
        BubbleSort.bubbleSort(copy);
        System.out.println("BubbleSort: " + Arrays.toString(copy));

        // Selection Sort
        copy = Arrays.copyOf(arr, arr.length);
        SelectionSort.selectionSort(copy);
        System.out.println("SelectionSort: " + Arrays.toString(copy));

        // Insertion Sort
        copy = Arrays.copyOf(arr, arr.length);
        InsertionSort.insertionSort(copy);
        System.out.println("InsertionSort: " + Arrays.toString(copy));

        // Merge Sort
        copy = Arrays.copyOf(arr, arr.length);
        MergeSort.mergeSort(copy);
        System.out.println("MergeSort: " + Arrays.toString(copy));

        // Quick Sort
        copy = Arrays.copyOf(arr, arr.length);
        QuickSort.quickSort(copy);
        System.out.println("QuickSort: " + Arrays.toString(copy));
    }
}