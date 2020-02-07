package com.sun.leetcode;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.widget.LinearLayout;

import com.sun.leetcode.company.Ms.FindNum;
import com.sun.leetcode.company.Ms.Lc692;
import com.sun.leetcode.company.Ms.Lc794;
import com.sun.leetcode.company.Ms.Lc917;
import com.sun.leetcode.company.bytedance.ThreadDemo;
import com.sun.leetcode.differentkind.array.EasyLc717;
import com.sun.leetcode.differentkind.greed.LcMedium767;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindNum.print();

        new ThreadDemo().startDemo();

        Handler hh = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };

        LruCache
    }

    public static String s = "";

    public void hh(){
        s = "ssss";
    }

    public void insertSort(int[] nums) {
        // 1,2,4,5, --- 3
        for (int i = 1; i < nums.length-1; i++) {
            int j = i - 1;
            int temp = nums[i];
            for (; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }


    public void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void quickSort(int[] nums,int l,int r){
        if (l > r) return;

        int i  = l;
        int j  = r;
        int temp = nums[l];

        while(i != j){
            while(nums[j] >= temp && i < j){
                j--;
            }

            while(nums[i] <= temp && i < j){
                i++;
            }

            if(i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        //i = j
        nums[l] = nums[i];
        nums[i] = temp;


        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);


        LinearLayout lll = new LinearLayout(this);
        lll.getChildCount();
    }

    public void  qs(int[] nums,int l,int r){
        if(l > r){
            return;
        }

        int i = l;
        int j = r;
        int temp = nums[l];
        while (i != j){
            while (nums[j] >= temp && i < j){
                j--;
            }

            while (nums[i] <= temp && i < j){
                i++;
            }

            if (i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        nums[l] = nums[i];
        nums[i] = temp;

        quickSort(nums,l, i-1);
        quickSort(nums,i+1, j);
    }










    public void quicks(int[] nums,int left,int right){
        if(left > right){
            return;
        }

        int temp = nums[left];
        int i = left;
        int j = right;


        while (i != j){
            while(nums[j] >= temp && i < j){
                j--;
            }

            while (nums[i] <= temp && i < j){
                i++;
            }

            if (i != j){
                int num = nums[i];
                nums[i] = nums[j];
                nums[j] = num;
            }
        }

        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);

    }














































}
