package com.javarush.task.task22.task2210;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

        String text = "hello,hi,guten,labas,sveiki";
        System.out.println(Arrays.toString(getTokens(text,",")));

    }

    public static String[] getTokens(String query, String delimiter) {

        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        String[] word = new String[tokenizer.countTokens()];

        for (int i=0; i < word.length;i++){
            word[i]=tokenizer.nextToken();
        }

        return word;
    }


}
