package com.sun.leetcode;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sun.leetcode.differentkind.array.EasyLc717;
import com.sun.leetcode.differentkind.greed.LcMedium767;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new LeetCode48().rotate(new int[][]{new int[]{5, 1, 9, 11}, new int[]{2, 4, 8, 10}, new int[]{13, 3, 6, 7}, new int[]{15, 14, 12, 16}});
//        new LeetCode61().rotateRight()
//        Log.d("--->", String.valueOf(aa));

//        new EasyLc905().sortArrayByParity(new int[]{3,1,2,4});
        new EasyLc717().isOneBitCharacter(new int[]{1,0,0});
        String aaaaacccbbb = new LcMedium767().reorganizeString("aaaaacccbbb");
        Log.d("--->","result:"+ aaaaacccbbb);

        int a = 3;
        int b = 1;

        b ^= 1;
        Log.d("ss","-->" + a);
    }
}
