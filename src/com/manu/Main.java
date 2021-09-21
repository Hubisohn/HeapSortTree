package com.manu;

import java.util.OptionalInt;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int size;
        int root;
        int indad;
        int leftchild;
        int rightchild;
        int pos;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie die groeße Ihres Arrays ein: ");

        size = scanner.nextInt();

        int[] randarr = new int[size];

        fillarr(randarr, size);
        printArr(randarr, size);

        for (int index = 0; index < size; index++) {
            leftchild = getleftindex(index, randarr);
            rightchild = getrightindex(index, randarr);

            int dad = getParent(randarr, index);

            printLeftChild(leftchild, dad, randarr);

            printRightChild(rightchild, dad, randarr);
            }


            heapsort(randarr);
            System.out.println("");
            printArr(randarr, size);
    }

    private static void heapsort(int[] randarr) {

        int indexone = 0;

        heapify(randarr);

        printArr(randarr, randarr.length);

        for (int indextwo = randarr.length - 1; indextwo >= 0; indextwo--) {
            swap(randarr, indexone, indextwo);
            sink(randarr, indexone, indextwo);
        }
    }

    private static void swap(int[] randarr, int indexone, int indextwo) {

        int buff = randarr[indexone];

        randarr[indexone] = randarr[indextwo];
        randarr[indextwo] = buff;

    }

    private static void heapify(int[] randarr) {
        int mid = randarr.length / 2;

        for (int i = mid; i >= 0; i--) {
            sink(randarr, i, randarr.length);
        }

    }

    private static void sink(int[] randarr, int i, int indextwo) {

        int leftindex = getleftindex(i, randarr);
        int rightindex = getrightindex(i, randarr);

        if(leftindex >= indextwo){
            return;
        }

        if(leftindex == 0){
            return;
        }else{
            if(rightindex == 0 || rightindex >= indextwo){
                if(randarr[i] < randarr[leftindex]){

                    swap(randarr, leftindex, i);
                    sink(randarr, leftindex, indextwo);
                }
            }else{
                if(randarr[rightindex] < randarr[leftindex]){
                    if(randarr[i] <= randarr[leftindex]) {
                        swap(randarr, leftindex, i);
                        sink(randarr, leftindex, indextwo);
                    }
                }
                    if(randarr[rightindex] >= randarr[i]) {
                        swap(randarr, rightindex, i);
                        sink(randarr, rightindex, indextwo);
                }
            }
        }
    }

    private static int getParent(int[] randarr, int index) {
        if(index == 0) {
            return randarr[index];
        }else{
            return randarr[index];
        }

    }

    private static int getleftindex(int index, int[] randarr) {
        index = index * 2 + 1;
        if(index >= randarr.length){
            index = 0;
            return index;
        }else{
            return index;
        }
    }

    private static int getrightindex(int index, int[] randarr) {
        index = index * 2 + 2;
        if(index >= randarr.length){
            index = 0;
            return index;
        }else{
            return index;
        }
    }

    private static void printRightChild(int rightchild, int dad, int[] randarr) {
        if(rightchild != 0) {
            System.out.println("Ich bin das rechte Kind: " + randarr[rightchild] + " mein Vater ist: " + dad);
        }
    }

    private static void printLeftChild(int leftchild, int dad, int[] randarr) {
        if(leftchild != 0) {
            System.out.println("Ich bin das linke Kind: " + randarr[leftchild] + " mein Vater ist: " + dad);
        }
    }

    private static void fillarr(int[] randarr, int size){

        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            randarr[i] = rand.nextInt(10) + 1;
        }
    /*
        randarr[0] = 7;
        randarr[1] = 5;
        randarr[2] = 9;
        randarr[3] = 4;
        randarr[4] = 8;
        randarr[5] = 1;

     */
    }
    
    private static void printArr(int[] randarr, int size){
        for (int i = 0; i < size; i++) {
            System.out.print(randarr[i] + " ");
        }
        System.out.println("");

    }


}