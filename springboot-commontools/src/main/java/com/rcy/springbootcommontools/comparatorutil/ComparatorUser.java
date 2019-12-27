package com.rcy.springbootcommontools.comparatorutil;

import com.rcy.springbootcommontools.bean.User;

import java.util.Comparator;

/**
 * @description:
 * @author: rencaiyu
 * @create: 2019年12月18日 21:29
 **/
public class ComparatorUser implements Comparator<User> {

    @Override
    public int compare(User userOne, User userTwo) {
        int ageOne = userOne.getAge();
        int ageTwo = userTwo.getAge();
        //先返回1则为升序，先返回-1则为降序
        if (ageOne > ageTwo) {
            return -1;
        }
        if (ageOne < ageTwo) {
            return 1;
        }
        return 0;
    }
}
