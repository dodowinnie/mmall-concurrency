package com.branodn.mmall.example.publish;

import com.branodn.mmall.annotation.NotRecommend;
import com.branodn.mmall.annotation.NotThreadSafe;

/**
 * Created by Brandoncui on 2019/1/12.
 */
@NotThreadSafe
@NotRecommend
public class Escape {

    private int canBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass() {
            System.out.println("" + Escape.this.canBeEscape);
        }
    }


    public static void main(String[] args) {
        new Escape();
    }
}
