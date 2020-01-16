package com.rcy.sort;

import com.rcy.bean.User;
import com.rcy.enums.SortTypeEnum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: JDK8Stream排序
 * @author: rencaiyu 2020年01月03日 10:21
 **/
public class StreamSort {

    public static List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setAge(100);
        User userOne = new User();
        userOne.setAge(20);
        User userTwo = new User();
        userTwo.setAge(80);
        userList.add(user);
        userList.add(userOne);
        userList.add(userTwo);
        return userList;
    }

    /**
     * 降序
     *
     * @return
     */
    public List<User> getDescUserList() {
        List<User> userList = getUserList();
        //降序需要用此返回值
        List<User> collect = userList.stream().sorted(Comparator.comparing(User::getAge).reversed()).collect(Collectors.toList());
        for (User user : collect) {
            System.out.println(user.getAge());
        }
        return collect;
    }

    /**
     * 升序
     */
    public void getAscUserList() {
        List<User> userList = getUserList();
        userList.sort(Comparator.comparing(user1 -> user1.getAge()));
        for (User user1 : userList) {
            System.out.println(user1.getAge());
        }
    }


}
