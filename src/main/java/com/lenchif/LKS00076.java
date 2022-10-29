package com.lenchif;

import java.util.ArrayList;
import java.util.HashMap;

public class LKS00076 {
    public String minWindow(String s, String t) {
        Integer sStart=0;
        Integer sEnd =0;
        IsObj isObj = new IsObj(t);
        Integer len=Integer.MAX_VALUE;
        String res="";
        while (sEnd<=sStart&&sEnd<s.length()){
            if(isObj.isContain()){
                if(isObj.arr.size()<len){
                    len=isObj.arr.size();
                    res= isObj.arr.stream().reduce("",(String r,Character c)->r+String.valueOf(c),(String a, String b)->"");
                }
                isObj.pop();
                sEnd++;
            }else {
                if(sStart<s.length()){
                    isObj.add(s.charAt(sStart));
                    sStart++;
                }else{
                    break;
                }
            }
        }
        return res;
    }
    public class IsObj{
        private HashMap<Character,Integer> data=new HashMap();
        private ArrayList<Character> arr=new ArrayList<>();
        public IsObj(String t) {
            for(int i=0;i<t.length();i++){
                if(data.containsKey(t.charAt(i))){
                    data.put(t.charAt(i),data.get(t.charAt(i))+1);
                }else {
                    data.put(t.charAt(i),1);
                }
            }
        }
        public void add(Character c){
            arr.add(c);
            if(data.containsKey(c)){
                data.put(c,data.get(c)-1);
            }
        }

        public Boolean isContain(){
            return data.values().stream().allMatch((Integer i)-> i<=0);
        }
        public void pop(){
            Character remove = arr.remove(0);
            if(data.containsKey(remove)){
                data.put(remove,data.get(remove)+1);
            }
        }
    }

    public static void main(String[] args) {

        new LKS00076().minWindow("cabwefgewcwaefgcf","cae");
    }
}
