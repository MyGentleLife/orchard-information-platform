package com.liyang.orchard.dao;

import com.liyang.orchard.config.shiro.SysUser;
import com.liyang.orchard.core.Mapper;
import com.liyang.orchard.model.User;
import com.liyang.orchard.model.user.DetailUser;
import com.liyang.orchard.model.user.SimpleUser;
import com.liyang.orchard.model.user.UpdateUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import javax.persistence.Id;
import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    @Results({
            @Result(column="user_id", property="userId", jdbcType = JdbcType.INTEGER),
            @Result(column="portrait_url", property="portraitUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column="nikename", property="nikename", jdbcType = JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType = JdbcType.VARCHAR),
            @Result(column="id_number", property="idNumber", jdbcType = JdbcType.VARCHAR),
            @Result(column="verified", property="verified", jdbcType = JdbcType.VARCHAR),
            @Result(column="membership_deadline", property="membershipDeadline", jdbcType = JdbcType.TIMESTAMP),
            @Result(column="phone", property="phone", jdbcType = JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType = JdbcType.VARCHAR)
    })

    @Select("SELECT * from user WHERE phone=#{userPhone}")
    User findByPhone(@Param("userPhone")String phone);

    SimpleUser getSimpleUserInfo(@Param("userId")Integer userId);

    DetailUser getDetailUserInfo(@Param("userId")Integer userId);

    void setUserInfo(@Param("updateUser")UpdateUser updateUser);

    List<SysUser> findUserAuthority(@Param("userPhone") String phone);
}