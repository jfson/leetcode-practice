package com.sun.leetcode.hailong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: jfson sun
 * Create on:  2020/2/16
 * Question:
 * Description:
 * Train of thought:
 */
public class Test {


    public static void main(String[] args) {


    }

    public void map(){
        /**
         ("key1","chengji1")
         ("key2","chengji2")
         ("key3","chengji3")
         ("key4","chengji4")
         ...
         ("key100","chengji100")
         */

        HashMap<String,String> map = new HashMap<>();
        for (int i = 1; i <= 100; i=i+1) {
            map.put("key" + i,"chengji" + i);
        }

        //打印 iterator
        //打印,知道key,get出来
        for (int i = 1; i <= 100; i=i+1) {
            String curr = map.get("key" + i);
            System.out.print("key" + i);//key
            System.out.print(curr);//value
        }

        //打印，不知道key;乱序的list;set 跟list类似的
        //list --> [1,2,3,4,5,6,7,8,9... 100]
        //set  --> [2,3,,63,7,9,1,98 ... 22]
        Set<String> set = map.keySet();
        for (String curr : set) {
            System.out.print(curr);//key
            System.out.print(map.get(curr));//value
        }

        //50-60 改为 0;iterator
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();//key
            String value = map.get(key); //value
            if(value.equals("chengji20")){
                map.put(key,"chengji0");
            }

            if(value.equals("chengji30")){
                map.put(key,"chengji0");
            }

            if (value.equals("chengji40")){
                map.remove(key);//remove （key40,chengji40）
            }
        }


    }

    public void list(){

        for(int x = 10; x < 20; x = x+5) {
            //10,15
            System.out.print("value of x : " + x );
            System.out.print("\n");
        }


        //ArrayList
        //index ;增删改查
        //new 就这么写
        ArrayList<Integer> list = new ArrayList<>();
        //存1-100
        for (int i = 1; i <= 100; i=i+1) {
            list.add(i);
        }

        //值，数据 [100,2,3,4,5,6,7,8,9... 100]
        //index   [0,1,2,3,4,5,6,7,8... 99 ]
        //打印
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }

        // 50-60 改为 0
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= 60 || list.get(i) >= 50){
                list.set(i,0); //改值..
            }
        }
        //todo 删除，不能遍历的时候删除；用iterator


    }

    // 数组
    public void shuzu(){
        //数组的初始化，长度固定
        int[] shuzu = new int[100]; //优先。长度为100
        int[] shuzuTwo = new int[]{1,2,3,4};
        int[] shuzuThree = {1,2,3,4};

        //index ;增删改查

        //存1-100
        for (int i = 0; i < 100; i++) {
            shuzu[i] = i+1;
        }
        //[1,2,3,4,5,6,7,8,9... 100]

        //打印 1-100
        for (int i = 0; i < shuzu.length; i++) {
            System.out.print(shuzu[i]);
        }

        //删除，数组
        for (int i = 0; i < shuzu.length; i++) {
            if (shuzu[i] <= 60 || shuzu[i] >= 50){
                shuzu[i] = 0;
            }
        }

        //打印
        for (int i = 0; i < shuzu.length; i++) {
            System.out.print(shuzu[i]);
        }
    }
}
