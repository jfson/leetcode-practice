package com.sun.leetcode.company.ab;
import java.util.*;
/**
 * Author: jfson sun
 * Create on:  2019/1/3
 * Question:
 * Description:
 * Train of thought:
 */
public class DisplayPage {
        /*
        Display Page - LinkedList + HashSet
        AirBnB Interview Question

        给一个array of string, 每个string由"host_id,listing_id,score,city" 组成，
        并以score从大到小排列。给定一个target值N，按照每一页N行分页，并且host_id不能在一页里有重复。
        但是如果有哪一页（除最后一页外）没有放满N行，就要把原本应该放在后面几页的string拿过来填满
        （打破host_id不能重复的规则）。

        给你一组数据，和每页的容量，要求每页上力求没有重复的ID例子:
        "1,28,310.6,SF",
        "4,5,204.1,SF",
        "20,7,203.2,Oakland",
        input：1,2,3,4,1,5,1,2,3,1,3 ; page size : 5
        output:
        1,2,3,4,5 / 1,2,3,1,1 / 3
        */

    public List<String> displayPages(List<String> input, int pageSize) {
        List<String> res = new ArrayList();
        List<String> visited = new ArrayList<>();
        Iterator<String> iter = input.iterator();
        boolean pageEnd = false;
        int count = 0;

        while(iter.hasNext()){
            String curr = iter.next();
            String currStart = curr.split(",")[0];


            if (!visited.contains(currStart) || pageEnd) {
                res.add(curr);
                visited.add(currStart);
                iter.remove();
                count++;
            }

            if (count == pageSize) {//page 满了全部重置
                if (!input.isEmpty())
                    res.add(" ");

                iter = input.iterator();
                visited.clear();
                count = 0;
                pageEnd = false;
            }

            if (!iter.hasNext()) {
                pageEnd = true; //遍历一遍完了重置，重置继续添加
                iter = input.iterator();
            }
        }

        return res;
    }
}
