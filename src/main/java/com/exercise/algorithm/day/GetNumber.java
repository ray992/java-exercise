package com.exercise.algorithm.day;

import com.exercise.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @ClassName GetNumber
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/16 4:11 PM
 * @Version 1.0
 **/
public class GetNumber {

    public int getNumber(TreeNode root, int[][] ops) {
        List<int[]> mList = new ArrayList<>();
        for (int i = 0; i < ops.length; i++){
            int type = ops[i][0];
            int s = ops[i][1];
            int e = ops[i][2];
            if (type == 1){
                if (mList.size() == 0){
                    mList.add(new int[]{s,e});
                    continue;
                }
                boolean insertStatus = false;
                for (int[] aa:mList){
                    int ss = aa[0];
                    int ee = aa[1];
                    if (ss > e || ee < s){
                        insertStatus =true;
                        continue;
                    }
                    if (s < ss && ee >= e && e >= ss){
                        aa[0] = s;
                        continue;
                    }
                    if (e > ee && (ss <= s &&  s <= ee)){
                        aa[1] = e;
                    }
                }
                if (insertStatus){
                    mList.add(new int[]{s,e});
                }
            }else {
                if (mList.size() > 0){
                    boolean removeStatus = false;
                    int index = 0;
                    for (int t = 0; t < mList.size(); t++){
                        int ss = mList.get(t)[0];
                        int ee = mList.get(t)[1];
                        if (ss >= s && ee <= e){
                            removeStatus = true;
                            index = t;
                            break;
                        } else if (ss < e && e <= ee && ss < s && s < ee){
                            mList.get(t)[1] = s - 1;
                            mList.add(new int[]{ee+1,e});
                        }else if (e > ee && s >= ss && s <= ee){
                            mList.get(t)[1] = s -1 ;
                        }else if (s < ss && e >= ss && e <= ee){
                            mList.get(t)[0] = e + 1;
                        }
                    }
                    if (removeStatus){
                        mList.remove(index);
                    }
                }
            }
        }
        if (mList.size() == 0){
            return 0;
        }
        List<Integer> valList = new ArrayList<>();
        treeToList(root, valList);
        Collections.sort(valList);
        int sum = 0;
        for (int[] mm:mList){
            int s = mm[0];
            int e = mm[1];
            int tempSum = 0;
            for (int i = 0; i < valList.size(); i++){
                if (valList.get(i) >= s && valList.get(i) <= e){
                    tempSum++;
                }
            }
            sum = sum + tempSum;
        }
        return sum;
    }

    // 保存的是没有操作过的节点
    TreeSet<Integer> set;

    public int getNumber2(TreeNode root, int[][] ops){
        if(root == null) return 0;

        set = new TreeSet<>();
        build(root);

        int res = 0;

        for(int i = ops.length - 1; i >= 0; i--){
            while(true){
                // 找到第一个大于x的节点
                Integer upper = set.higher(ops[i][1] - 1);
                if(upper == null || upper > ops[i][2]) break;
                // 删除操作过的节点
                set.remove(upper);
                // 如果是染红，记录红色节点数
                if(ops[i][0] == 1) res++;
            }

        }

        return res;
    }

    private void build(TreeNode root){
        if(root == null) return;
        build(root.left);
        set.add(root.val);
        build(root.right);
    }

    public void treeToList(TreeNode treeNode, List<Integer> valList){
        if (treeNode == null){
            return;
        }
        valList.add(treeNode.val);
        treeToList(treeNode.left,valList);
        treeToList(treeNode.right, valList);
    }

    public static void main(String[] args) {
        GetNumber getNumber = new GetNumber();
        System.out.println(getNumber.getNumber(null, new int[][]{{0,2,2},{1,1,5},{0,4,5},{1,5,7}}));
    }
}
