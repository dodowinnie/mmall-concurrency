package com.branodn.mmall.example.publish;

import com.branodn.mmall.annotation.NotThreadSafe;

import java.util.Arrays;

/**
 * Created by Brandoncui on 2019/1/12.
 */
@NotThreadSafe
public class UnsafePublish {

    private String[] states = {"a", "b", "c"};

    public String[] getStates(){
        return states;
    }


    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        System.out.println("" + Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";

        System.out.println("" + Arrays.toString(unsafePublish.getStates()));

    }
}
