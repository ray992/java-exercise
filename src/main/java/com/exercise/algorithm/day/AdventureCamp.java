package com.exercise.algorithm.day;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName AdventureCamp
 * @Description TODO
 * @Author yeqiang
 * @Date 2023/4/22 15:44
 * @Version 1.0
 **/
public class AdventureCamp {

    public int adventureCamp(String[] expeditions) {
        if (expeditions.length == 1){
            return -1;
        }
        Set<String> campSet = new HashSet<>();
        String first = expeditions[0];
        if (first.length() > 0){
            String[] yidis = first.split("->");
            for (String yidi:yidis){
                campSet.add(yidi);
            }
        }
        int most = 0;
        int index = -1;
        Set<String> tempSet = new HashSet<>();
        for (int i = 1; i < expeditions.length; i++){
            String strings = expeditions[i];
            if (strings.length() == 0){
                continue;
            }
            String[] yidis =  strings.split("->");
            int newCamp = 0;
            for (String yidi:yidis){
                if (!campSet.contains(yidi) && tempSet.add(yidi)){
                    newCamp++;
                    campSet.add(yidi);
                }
            }
            if (newCamp > most){
                most = newCamp;
                index = i;
            }
            tempSet.clear();
        }
        return index;
    }

    public static void main(String[] args) {
        AdventureCamp adventureCamp = new AdventureCamp();
        //System.out.println(adventureCamp.adventureCamp(new String[]{"leet->code","leet->code->Campsite->Leet","leet->code->leet->courier"}));
        //System.out.println(adventureCamp.adventureCamp(new String[]{"Alice->Dex","","Dex"}));
        //System.out.println(adventureCamp.adventureCamp(new String[]{"","Gryffindor->Slytherin->Gryffindor","Hogwarts->Hufflepuff->Ravenclaw"}));
        System.out.println(adventureCamp.adventureCamp(new String[]{"xO->xO->xO","xO->BKbWDH","xO->BKbWDH","BKbWDH->mWXW","LSAYWW->LSAYWW","oAibBvPdJ","LSAYWW->u","LSAYWW->LSAYWW"}));
    }
}
