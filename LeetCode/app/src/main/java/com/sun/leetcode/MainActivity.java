package com.sun.leetcode;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.sun.leetcode.company.Ms.FindNum;
import com.sun.leetcode.company.Ms.Lc692;
import com.sun.leetcode.company.Ms.Lc794;
import com.sun.leetcode.company.Ms.Lc917;
import com.sun.leetcode.company.bytedance.BigNumber;
import com.sun.leetcode.company.bytedance.PrintArray;
import com.sun.leetcode.company.bytedance.ThreadDemo;
import com.sun.leetcode.differentkind.array.EasyLc717;
import com.sun.leetcode.differentkind.greed.LcMedium767;
import com.sun.leetcode.difficulty.medium.LeetCode54;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        int[][] res = new int[4][4];
//        res[0] = new int[]{1, 2, 3,     4};
//        res[1] = new int[]{12, 13, 14, 5};
//        res[2] = new int[]{11, 16, 15, 6};
//        res[3] = new int[]{10, 9, 8,    7};
////        PrintArray.printArray(res,getBaseContext());
//
//        int[] rrr = {1,3,5,3,1,3,6,80,4,68,77,22,44,65,14,1,56,1516,16,11};
//        quicks(rrr,0,rrr.length-1);
//        String string = "h";
//        for (int i : rrr) {
//            string +=i+",";
//        }
//
//        Toast.makeText(this,string,Toast.LENGTH_LONG).show();


        String s = BigNumber.bigNumber("123", "234");
        Log.d("suzzhen",s);



    }

    public static String s = "";

    public void hh() {
        s = "ssss";
    }

    public void insertSort(int[] nums) {
        // 1,2,4,5, --- 3
        for (int i = 1; i < nums.length - 1; i++) {
            int j = i - 1;
            int temp = nums[i];
            for (; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }


    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l > r) return;

        int i = l;
        int j = r;
        int temp = nums[l];

        while (i != j) {
            while (nums[j] >= temp && i < j) {
                j--;
            }

            while (nums[i] <= temp && i < j) {
                i++;
            }

            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        //i = j
        nums[l] = nums[i];
        nums[i] = temp;


        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);


        LinearLayout lll = new LinearLayout(this);
        lll.getChildCount();
    }

    public void qs(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }

        int i = l;
        int j = r;
        int temp = nums[l];
        while (i != j) {
            while (nums[j] >= temp && i < j) {
                j--;
            }

            while (nums[i] <= temp && i < j) {
                i++;
            }

            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }

        nums[l] = nums[i];
        nums[i] = temp;

        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, j);
    }


    public void quicks(int[] nums, int left, int right) {
        if(left > right){
            return;
        }

        int temp = nums[left];
        int l = left;
        int r = right;

        while (l != r){
            while (nums[r] >= temp && l < r){
                r--;
            }
            while (nums[l] <= temp && l < r){
                l++;
            }

            if (l < r){
                int swap = nums[l];
                nums[l] = nums[r];
                nums[r] = swap;
            }
        }

        nums[left] = nums[l];
        nums[l] = temp;

        quicks(nums,left,l-1);
        quicks(nums,l+1,right);

    }









}
