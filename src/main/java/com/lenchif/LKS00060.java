package com.lenchif;

import java.util.HashMap;
import java.util.LinkedList;

public class LKS00060 {
    static int len=9;
    static LinkedList res =new LinkedList();
    static HashMap<Integer, Boolean> map=new HashMap<>();
    static boolean flag=false;
    static LinkedList dataA=new LinkedList();

    public static void main(String[] args) {
        int n=4;
        int k=9;
        for(int i=1;i<=n;i++){
            dataA.add(i);
            map.put(i,false);
        }
        dfs();

    }
     public static void dfs(){
         if(res.size()==dataA.size()){
            len--;
            if(len==0){
                for(int i=0;i<res.size();i++){
                    System.out.println(res.get(i));
                }
                    flag=true;
            }
            return;
         }
         for (Object o : dataA) {
             if (flag) {
                 return;
             }

             if (!map.get(o)) {
                 map.put((Integer) o, true);
                 res.addLast(o);
                 dfs();
                 res.removeLast();
                 map.put((Integer) o, false);
             }
         }
    }
}
