package com.sun.leetcode.company.Ms;

import com.sun.leetcode.model.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: jfson sun
 * Create on:  2019/12/22
 * Question:
 * Description:
 * Train of thought:
 */
public class Lc429 {
    /**
     *
     */

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> currList = new ArrayList<>();

            for(int i = 0;i < queueSize; i++){
                Node currNode = queue.poll();
                currList.add(currNode.val);
                if(currNode.children != null && currNode.children.size() != 0){
                    for(Node node:currNode.children){
                        queue.add(node);
                    }
                }
            }

            ret.add(currList);
        }
        return ret;
    }
}
