package com.sun.leetcode.company.airb;

import java.util.Iterator;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2019/1/2
 * Question:
 * Description:
 * Train of thought:
 */
public class ListIterator {
    /**
     List of List Iterator(2D List Iterator) 相似问题 Lc251/Lc341
     Given an array of arrays, implement an iterator class to allow the client to traverse and remove elements in the array list.

     This iterator should provide three public class member functions:

     boolean hasNext() return true if there is another element in the set
     int next() return the value of the next element in the array
     void remove() remove the last element returned by the iterator. That is, remove the element that the previous next() returned.
     This method can be called only once per call to next(), otherwise an exception will be thrown.


     solution:二维数组。没什么可说的
     */

    class Solution implements Iterator<Integer> {
        List<List<Integer>> res;
        int row,col;

        public Solution(List<List<Integer>> res){
            this.res = res;
            row = 0;
            col = 0;
        }


        @Override
        public boolean hasNext() {
            if (res == null || res.isEmpty()) return false;

            while (row < res.size()){
                if (col < res.get(row).size()){
                    return true;
                }else {
                    row--;
                    col = 0;
                }
            }

            return false;
        }

        @Override
        public Integer next() {
            int val = res.get(row).get(col);
            col++;
            return val;
        }

        @Override
        public void remove() {
            List<Integer> listRemoved;

            int rowRemoved = row;
            int colRemoved = col;

            if (col == 0){
                rowRemoved--;
                colRemoved = res.get(rowRemoved).size() -1;
                listRemoved = res.get(rowRemoved);
            }else {
                colRemoved--;
                listRemoved = res.get(rowRemoved);
            }

            listRemoved.remove(colRemoved);

            if (listRemoved.isEmpty()){
                res.remove(listRemoved);
                row--;
            }

            if (col > 0){
                col --;
            }
        }
    }
}
