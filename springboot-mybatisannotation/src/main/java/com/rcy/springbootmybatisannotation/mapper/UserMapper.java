package com.rcy.springbootmybatisannotation.mapper;

import com.rcy.springbootmybatisannotation.bean.UserEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: rencaiyu 2019年12月30日 15:10
 **/
public interface UserMapper {


    @Select("select * from t_sssc_users")
    @Results({
            @Result(property = "userName", column = "userName"),
            @Result(property = "passWord", column = "passWord")
    })
    List<UserEntity> getUserList();

}
