package com.company;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*InputStream stream = System.in;
        Scanner scanner = new Scanner(stream);
        System.out.println("Number Test cases:");
        String numTestCases = scanner.next();

        System.out.println("Sum:");
        String sum =scanner.next();

        System.out.println("Resultado:");++
*/
        int [] arr = {1, 2, 3, 7, 5};
        int resultado = 12;
        ArrayList<Integer> arrayList = subArrayWithGivenSumConsole(arr, resultado);
        /*for (int i : arrayList) {
            System.out.
        }*/
        arrayList.stream().forEach(p->System.out.print(p + " "));
        //System.out.println(arrayList);
        //scanner.close();
    }

    public static ArrayList subArrayWithGivenSumConsole(int [] arr, int sumTotal){
        int suma = 0;
        int posInicial = -1;
        int posFinal = -1;
        int numInicial;
        for (int k = 0; k < arr.length; k++) {
            if (posFinal > -1) {
                break;
            }
            numInicial = arr[k];
            posInicial = k;
            suma = numInicial;

            for (int i = k + 1; i < arr.length; i++) {
                suma += arr[i];
                if (suma == sumTotal) {
                    posFinal = i;
                    break;

                } else if (suma > sumTotal) {
                    int diferencia = suma - sumTotal;
                    for (int l = 0; l < i; l++) {
                        suma = suma - arr[l];
                        if (suma == sumTotal) {
                            posInicial = l + 1;
                            posFinal = i;
                            break;
                        }
                    }
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(++posInicial);
        arrayList.add(++posFinal);
        return arrayList;
    }

    public static Integer findIndex(int arr[], int t) {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .findFirst() // first occurence
                .orElse(-1); // No element found
    }
}
