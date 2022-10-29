package com.lenchif;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LKS00065 {
    public static void main(String[] args) {
//        LKS00065 lks00065 = new LKS00065();
////        lks00065.isNumber("2E5");
//        System.out.println(lks00065.isZ("56"));


        Instant instant = Instant.ofEpochMilli(1663380142513L);
        java.util.Date date = Date.from(instant);
        System.out.println(instant);
        System.out.println(date);


    }
    public boolean isNumber(String s) {
        String[] split = s.split("e|E");

        return false;
    }
    public boolean isZ(String s){
        char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(chars[i]>'9'||chars[i]<'0'){
                return false;
            }
        }
        return true;
    }

}
