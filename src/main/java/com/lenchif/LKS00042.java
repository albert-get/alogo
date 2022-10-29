package com.lenchif;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 双指针和单调栈是两种思维，一种是横向的，一种是纵向的
 */
public class LKS00042 {
    public static void dandiaozhan(String[] args) {
        int []height={4,2,0,3,2,5};
        LinkedList<Integer> stack = new LinkedList<>();
        int res=0;
        for(int i=0;i< height.length;i++){
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int di=stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left=stack.peek();
                int w=i-left-1;
                int h=Math.min(height[i], height[left])-height[di];
                res+=w*h;
            }
            stack.push(i);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int []height={4,2,0,3,2,5};
        int left=0;
        int right=height.length-1;
        int left_max=0;
        int right_max=0;
        while (left<right){
            if(height[left]<height[right]){
                if(height[left]<left_max){
                    
                }
            }
        }
    }
}
