package com.lenchif;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LKS00068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        List<ArrayList<String>> data=new ArrayList<>();
        ArrayList<String> item=new ArrayList<>();
        Integer l=0;
        int i=0;
        while (i<words.length){
            Integer wl=words[i].length();
            l=wl+l;
            if(l<=maxWidth){
                l+=1;
                item.add(words[i]);
                i++;
            }else{
                data.add(item);
                item=new ArrayList<>();
                l=0;
            }
        }
        if(item.size()>0){
            data.add(item);
        }
        for(int g=0;g<data.size();g++){
            StringBuilder stringBuilder = new StringBuilder();
            Integer len=0;
            for(int j=0;j< data.get(g).size();j++){
                len+=data.get(g).get(j).length();
            }
            len=maxWidth-len;
            if(g == data.size() - 1){
                stringBuilder.append(data.get(g).get(0));
                for(int j=1;j< data.get(g).size();j++){
                    stringBuilder.append(" ");
                    len--;
                    stringBuilder.append(data.get(g).get(j));
                }
                for(int jl=0;jl<len;jl++){
                    stringBuilder.append(" ");
                }
            }else{
                Integer sp=data.get(g).size()-1;
                stringBuilder.append(data.get(g).get(0));
                for(int j=1;j< data.get(g).size();j++){
                    Integer il=(int)Math.ceil((float)len/sp);
                    for(int k=0;k<il;k++){
                        stringBuilder.append(" ");
                    }
                    len-=il;
                    sp--;
                    stringBuilder.append(data.get(g).get(j));
                }
                while (len>0){
                    stringBuilder.append(" ");
                    len--;
                }
            }

            res.add(stringBuilder.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words={"This", "is", "an", "example", "of", "text", "justification."};
        String[] words2={"What","must","be","acknowledgment","shall","be"};
        new LKS00068().fullJustify(words2,16);
    }
}

