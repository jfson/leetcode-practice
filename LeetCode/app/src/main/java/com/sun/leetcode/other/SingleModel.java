package com.sun.leetcode.other;

/**
 * Author: jfson sun
 * Create on:  2019/5/9
 * Question:
 * Description:
 * Train of thought:
 */
public class SingleModel {
    private static class Holder{
        private static SingleModel model = new SingleModel();
    }

    private SingleModel(){

    }

    public SingleModel getInstance(){
        return Holder.model;
    }
}
