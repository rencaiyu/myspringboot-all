package com.rcy.sort;

import com.rcy.bean.User;
import com.rcy.enums.SortTypeEnum;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: rencaiyu 2020年01月03日 10:36
 **/
public class StreamUtils {

    private static final String DESC = "desc";
    private static final String ASC = "asc";

    public static  <S> List<S> sort(List<S> s, String sortType, String sortField) {
        if (s == null) {
            return null;
        }
        //降序
        if (sortType.equals(DESC)) {
            List<S>  list1= s.stream().sorted(Comparator.comparing(S -> "getAge()").reversed()).collect(Collectors.toList());
            return list1;
        }
        // 升序
        if (sortType.equals(ASC)) {
            s.sort(Comparator.comparing(S ->"getAge()"));
            return s;
        }
        return null;
    }

    public static void main(String[] args) {
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

        List<User> getAge = StreamUtils.sort(userList, ASC, "getAge");
        for (User user1 : getAge) {
            System.out.println(user1.getAge());

        }
    }
}
