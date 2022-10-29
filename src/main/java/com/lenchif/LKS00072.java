package com.lenchif;

import java.util.ArrayList;
import java.util.List;

public class LKS00072 {
    public int minDistance(String word1, String word2) {
        Integer[] item=new Integer[word1.length()+1];
        for(int i=0; i<item.length;i++){
            item[i]=i;
        }
        Integer[][] data=new Integer[2][];
        data[0]=item;
        data[1]=new Integer[word1.length()+1];
        for(int j=0;j<word2.length();j++){
            data[(j+1)%2][0]=j+1;
            for(int i=0; i<word1.length();i++){
                if(word1.charAt(i)==word2.charAt(j)){
                    Integer min=Math.min(data[(j+1)%2][i],data[(j)%2][i+1]);
                    data[(j+1)%2][i+1]=Math.min(min,data[(j)%2][i]-1)+1;
                }else{
                    Integer min=Math.min(data[(j+1)%2][i],data[(j)%2][i+1]);
                    data[(j+1)%2][i+1]=Math.min(min,data[(j)%2][i])+1;
                }
            }
        }
        return data[(word2.length()+1)%2][word1.length()];
    }

    public static void main(String[] args) {
        new LKS00072().minDistance("horse","ros");
    }
}
