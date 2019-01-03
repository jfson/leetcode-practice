package com.sun.leetcode.company.ab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author: jfson sun
 * Create on:  2019/1/1
 * Question:
 * Description:
 * Train of thought:
 */
public class TravelBuddy {
    /**
     1.相似度大于50%,就是目标解
     solution: 将所有目标存在HashSet，遍历判断，最后在排序
     */

    class Solution{
        List<Buddy> buddies;
        Set<String> myWishLish;

        // map(name,set)
        public Solution(Set<String> myWishList, Map<String, Set<String>> friendsWishList) {
            this.buddies = new ArrayList<>();
            this.myWishLish = myWishList;

            for (String name : friendsWishList.keySet()) {
                Set<String> wiishList = friendsWishList.get(name);
                Set<String> intersection = new HashSet<>(wiishList);
                intersection.retainAll(myWishList); // 交集
                int sim = intersection.size();
                if (sim > wiishList.size() / 2) {
                    buddies.add(new Buddy(name, sim, wiishList));
                }
            }

            printBuddys();
        }

        public void printBuddys(){
            for (Buddy b:this.buddies){
                System.out.print("name:" + b.name);
            }
        }

        // follow up ,推荐一个城市(不在你的buddy内的).k为城市数量
        // solution: 先排序。最受欢迎的。依次遍历。去除自己list
        public List<String> recommendCities(int k) {
            List<String> res = new ArrayList<>();
            List<Buddy> buddies = getSortedBuddies();
            int i = 0;

            while (k > 0 && i < buddies.size()){
                Set<String> diff = new HashSet<>(buddies.get(i).wishList);
                diff.removeAll(myWishLish);
                if (diff.size() <= k){
                    res.addAll(diff);
                    k -= diff.size();
                    i++;
                }else {
                    Iterator<String> it = diff.iterator();
                    while (k > 0){
                        res.add(it.next());
                        k--;
                    }
                }
            }


            return res;
        }

        public List<Buddy> getSortedBuddies() {
            Collections.sort(buddies);
            List<Buddy> list = new ArrayList<>(buddies);
            return list;
        }
    }


    class Buddy implements Comparable<Buddy> {
        String name;
        int similarity;
        Set<String> wishList;

        public Buddy(String name,int similarity,Set<String> wishList){
            this.name =  name;
            this.similarity = similarity;
            this.wishList = wishList;
        }

        @Override
        public int compareTo(Buddy that){
            return that.similarity - this.similarity;
        }
    }

    public static class UnitTest {
        public void test1() {
            Set<String> myWishList = new HashSet<>(Arrays.asList(new String[]{"a", "b", "c", "d"}));
            Set<String> wishList1 = new HashSet<>(Arrays.asList(new String[]{"a", "b", "e", "f"}));
            Set<String> wishList2 = new HashSet<>(Arrays.asList(new String[]{"a", "c", "d", "g"}));
            Set<String> wishList3 = new HashSet<>(Arrays.asList(new String[]{"c", "f", "e", "g"}));
            Map<String, Set<String>> friendWishLists = new HashMap<>();
            friendWishLists.put("Buddy1", wishList1);
            friendWishLists.put("Buddy2", wishList2);
            friendWishLists.put("Buddy3", wishList3);
            Solution sol = new TravelBuddy().new Solution(myWishList, friendWishLists);
            List<String> res = sol.recommendCities(10);

        }
    }
}
