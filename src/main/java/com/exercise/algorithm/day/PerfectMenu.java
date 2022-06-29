package com.exercise.algorithm.day;

import java.util.Arrays;

/**
 * @ClassName PerfectMenu
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/16 3:14 PM
 * @Version 1.0
 **/
public class PerfectMenu {

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int sum = 0;
        for (int i = 0; i < attribute.length; i++){
            sum += attribute[i][1];
        }
        if (sum < limit){
            return -1;
        }
        boolean[] status = new boolean[cookbooks.length];
        for (int i = 0; i < cookbooks.length; i++){
            if (materials[0] >= cookbooks[i][0] && materials[1] >= cookbooks[i][1] &&
                    materials[2] >= cookbooks[i][2] && materials[3] >= cookbooks[i][3] &&
                    materials[4] >= cookbooks[i][4]){
                status[i] = true;
            }
        }
        int i = 1;
        int cn = cookbooks.length;
        while (i <= cn){
            i++;
        }
        return 0;
    }

    public int getOneResult(int[] materials, int[][] cookbooks, int[][] attribute, int limit, boolean[] status){
        int maxSum = -1;
        for (int i = 0; i < status.length; i++){
            if (!status[i]){
                continue;
            }
            if (attribute[i][1] < limit){
                continue;
            }
            if (maxSum < attribute[i][0]){
                maxSum = attribute[i][0];
            }
        }
        return maxSum;
    }

    public int getTwoResult(int[] materials, int[][] cookbooks, int[][] attribute, int limit, boolean[] status){
        int maxSum = -1;
        int len = attribute.length;
        int[][] sm = null;
        if (len == 2){
            sm = new int[][]{{0,1}};
        }else if (len == 3){
            sm = new int[][]{{0,1}, {0,2}, {1,2}};
        }else if (len == 4){
            sm = new int[][]{{0,1}, {0,2}, {0,3}, {1,2}, {1,3}, {2,3}};
        }else if (len == 5){
            sm = new int[][]{{0,1}, {0,2}, {0,3}, {0,4}, {1,2}, {1,3},{1,4}, {2,3},{2,4}, {3,4}};
        }else if (len == 6){
            sm = new int[][]{{0,1}, {0,2}, {0,3}, {0,4}, {0,5}, {1,2}, {1,3},{1,4},{1,5}, {2,3},{2,4},{2,5}, {3,4},{3,5}, {4,5}};
        }else if (len == 7){
            sm = new int[][]{{0,1}, {0,2}, {0,3}, {0,4}, {0,5},{0,6},
                    {1,2}, {1,3},{1,4},{1,5},{1,6}, {2,3},{2,4},{2,5},{2,6}, {3,4},{3,5},{3,6}, {4,5},{4,6},{5,6}};
        }else if (len == 8){
            sm = new int[][]{{0,1}, {0,2}, {0,3}, {0,4}, {0,5},{0,6},{0,7},
                    {1,2}, {1,3},{1,4},{1,5},{1,6},{1,7}, {2,3},{2,4},{2,5},{2,6},{2,7}, {3,4},{3,5},{3,6},{3,7}, {4,5},{4,6},{4,7},{5,6},{5,7},{6,7}};
        }
        for (int i = 0; i < len; i++){
            int p0 = cookbooks[sm[i][0]][0] + cookbooks[sm[i][1]][0];
            int p1 = cookbooks[sm[i][0]][1] + cookbooks[sm[i][1]][1];
            int p2 = cookbooks[sm[i][0]][2] + cookbooks[sm[i][1]][2];
            int p3 = cookbooks[sm[i][0]][3] + cookbooks[sm[i][1]][3];
            int p4 = cookbooks[sm[i][0]][4] + cookbooks[sm[i][1]][4];
            if (p0 <= materials[0] && p1 <= materials[1] &&
                p2 <= materials[2] && p3 <= materials[3] &&
                p4 <= materials[4] && (attribute[sm[i][0]][1] + attribute[sm[i][1]][1]) >= limit){
                int curMax = attribute[sm[i][0]][0] + attribute[sm[i][1]][0];
                if (curMax > maxSum){
                    maxSum = curMax;
                }
            }
        }
       return maxSum;
    }

    public int getThreeResult(int[] materials, int[][] cookbooks, int[][] attribute, int limit, boolean[] status){
        int maxSum = -1;
        int len = attribute.length;
        int[][] sm = null;
        if (len == 3){
            sm = new int[][]{{0,1,2}};
        }else if (len == 4){
            sm = new int[][]{{0,1,2}, {0,1,3}, {1,2,3}};
        }else if (len == 5){
            sm = new int[][]{{0,1,2}, {0,1,3}, {0,1,4}, {1,2,3}, {1,2,4}, {2,3,4}};
        }else if (len == 6){
            sm = new int[][]{{0,1,2}, {0,1,3}, {0,1,4},{0,1,5},  {1,2,3},{1,2,4},{1,2,5}, {2,3,4},{2,3,5},{3,4,5}};
        }else if (len == 7){
            sm = new int[][]{{0,1,2}, {0,1,3}, {0,1,4},{0,1,5},{0,1,6},  {1,2,3},{1,2,4},{1,2,5},{1,2,6},
                    {2,3,4},{2,3,5}, {2,3,6}, {3,4,5},{3,4,6},{4,5,6}};
        }else if (len == 8){
            sm = new int[][]{{0,1,2}, {0,1,3}, {0,1,4},{0,1,5},{0,1,6}, {0,1,7}, {1,2,3},{1,2,4},{1,2,5},{1,2,6},{1,2,7},
                    {2,3,4},{2,3,5}, {2,3,6}, {2,3,7}, {3,4,5},{3,4,6},{3,4,7}, {4,5,6},{4,5,7},{5,6,7}};
        }
        for (int i = 0; i < len; i++){
            int p0 = cookbooks[sm[i][0]][0] + cookbooks[sm[i][1]][0] + cookbooks[sm[i][2]][0];
            int p1 = cookbooks[sm[i][0]][1] + cookbooks[sm[i][1]][1]+ cookbooks[sm[i][2]][1];
            int p2 = cookbooks[sm[i][0]][2] + cookbooks[sm[i][1]][2]+ cookbooks[sm[i][2]][2];
            int p3 = cookbooks[sm[i][0]][3] + cookbooks[sm[i][1]][3]+ cookbooks[sm[i][2]][3];
            int p4 = cookbooks[sm[i][0]][4] + cookbooks[sm[i][1]][4]+ cookbooks[sm[i][2]][4];
            if (p0 <= materials[0] && p1 <= materials[1] &&
                    p2 <= materials[2] && p3 <= materials[3] &&
                    p4 <= materials[4] && (attribute[sm[i][0]][1] + attribute[sm[i][1]][1] + attribute[sm[i][2]][1] ) >= limit){
                int curMax = attribute[sm[i][0]][0] + attribute[sm[i][1]][0] + attribute[sm[i][2]][0];
                if (curMax > maxSum){
                    maxSum = curMax;
                }
            }
        }
        return maxSum;
    }


    public int getFourResult(int[] materials, int[][] cookbooks, int[][] attribute, int limit, boolean[] status){
        int maxSum = -1;
        int len = attribute.length;
        int[][] sm = null;
        if (len == 4){
            sm = new int[][]{{0,1,2,3}}; //1
        }else if (len == 5){
            sm = new int[][]{{0,1,2,3}, {0,1,2,4}, {0,1,3,4}, {1,2,3,4}};//C54 =
        }else if (len == 6){
            sm = new int[][]{{0,1,2,3}, {0,1,2,4}, {0,1,2,5}, {0,1,3,4}, {0,1,3,5}, {0,1,4,5},  {1,2,3,4},{1,2,3,5}, {1,2,4,5}, {1,3,4,5}, {2,3,4,5}};
        }else if (len == 7){
            sm = new int[][]{{0,1,2,3}, {0,1,2,4}, {0,1,2,5}, {0,1,2,6}, {0,1,3,4}, {0,1,3,5},{0,1,3,6},
                    {0,1,4,5}, {0,1,4,6}, {0,1,5,6}, {0,2,3,4}, {0,2,3,5}, {0,2,3,6},  {1,2,3,4},{1,2,3,5}, {1,2,4,5}, {1,3,4,5}, {2,3,4,5}};
        }else if (len == 8){
            sm = new int[][]{{0,1,2}, {0,1,3}, {0,1,4},{0,1,5},{0,1,6}, {0,1,7}, {1,2,3},{1,2,4},{1,2,5},{1,2,6},{1,2,7},
                    {2,3,4},{2,3,5}, {2,3,6}, {2,3,7}, {3,4,5},{3,4,6},{3,4,7}, {4,5,6},{4,5,7},{5,6,7}};
        }
        for (int i = 0; i < len; i++){
            int p0 = cookbooks[sm[i][0]][0] + cookbooks[sm[i][1]][0] + cookbooks[sm[i][2]][0];
            int p1 = cookbooks[sm[i][0]][1] + cookbooks[sm[i][1]][1]+ cookbooks[sm[i][2]][1];
            int p2 = cookbooks[sm[i][0]][2] + cookbooks[sm[i][1]][2]+ cookbooks[sm[i][2]][2];
            int p3 = cookbooks[sm[i][0]][3] + cookbooks[sm[i][1]][3]+ cookbooks[sm[i][2]][3];
            int p4 = cookbooks[sm[i][0]][4] + cookbooks[sm[i][1]][4]+ cookbooks[sm[i][2]][4];
            if (p0 <= materials[0] && p1 <= materials[1] &&
                    p2 <= materials[2] && p3 <= materials[3] &&
                    p4 <= materials[4] && (attribute[sm[i][0]][1] + attribute[sm[i][1]][1] + attribute[sm[i][2]][1] ) >= limit){
                int curMax = attribute[sm[i][0]][0] + attribute[sm[i][1]][0] + attribute[sm[i][2]][0];
                if (curMax > maxSum){
                    maxSum = curMax;
                }
            }
        }
        return maxSum;
    }

    public int getFiveResult(int[] materials, int[][] cookbooks, int[][] attribute, int limit, boolean[] status){
        return 0;
    }

    public int getSixResult(int[] materials, int[][] cookbooks, int[][] attribute, int limit, boolean[] status){
        return 0;
    }

    public int getSevenResult(int[] materials, int[][] cookbooks, int[][] attribute, int limit, boolean[] status){
        return 0;
    }

    public int getEightResult(int[] materials, int[][] cookbooks, int[][] attribute, int limit, boolean[] status){
        return 0;
    }


}
