/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author mileidicabezas
 */
public class SelectionSort {
  
    public static void selectionSort(List<String> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // ths will swap the found minium element with the element at index i
            Collections.swap(list, i, minIndex);
        }
        
    }
    
    
    
    }
   
    
   