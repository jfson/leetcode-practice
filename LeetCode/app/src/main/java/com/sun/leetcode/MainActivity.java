package com.sun.leetcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sun.leetcode.company.Ms.Lc692;
import com.sun.leetcode.company.Ms.Lc794;
import com.sun.leetcode.company.Ms.Lc917;
import com.sun.leetcode.differentkind.array.EasyLc717;
import com.sun.leetcode.differentkind.greed.LcMedium767;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new LeetCode48().rotate(new int[][]{new int[]{5, 1, 9, 11}, new int[]{2, 4, 8, 10}, new int[]{13, 3, 6, 7}, new int[]{15, 14, 12, 16}});
//        new LeetCode61().rotateRight()
//        Log.d("--->", String.valueOf(aa));

//        new EasyLc905().sortArrayByParity(new int[]{3,1,2,4});
//        new EasyLc717().isOneBitCharacter(new int[]{1,0,0});
//        String aaaaacccbbb = new LcMedium767().reorganizeString("aaaaacccbbb");
//        Log.d("--->","result:"+ aaaaacccbbb);
//
//        int a = 3;
//        int b = 1;
//
//        b ^= 1;
//        Log.d("ss","-->" + a);
//
//
//        String[] st = {"OXX","XOX","OXO"};
//        new Lc794().validTicTacToe(st);

//        List<String> list = new Lc692().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);

        new Lc917().reverseOnlyLetters("ab-cd");

        int[] tests = new int[]{11,2,34,6,75,33,3,23,21,18,11,9,0,19,37};
//        quickSort(tests,0,tests.length-1);
        insertSort(tests);
        Log.d("--","");
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
    }
}
