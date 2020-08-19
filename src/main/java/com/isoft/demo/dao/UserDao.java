package com.isoft.demo.dao;

import com.isoft.demo.entity.User;
import com.isoft.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends UserMapper {
    @Select("select count(*) from tb_user where userId=#{userId} and userPass=#{userPass}")
    int getPassCounts(@Param("userId")Integer userId, @Param("userPass")String userPass);
    @Update(
            "<script>"+
                    "       update tb_user" +
                    "        <set>" +
                    "            <if test=\"null != userPass\">" +
                    "                userPass=#{userPass}," +
                    "            </if>" +
                    "            <if test=\"null !=userPhotoUrl\">" +
                    "                userPhotoUrl=#{userPhotoUrl}" +
                    "            </if>" +
                    "        </set>" +
                    "        where userId=#{userId}"
            +"</script>"
    )
    int update(User user);
}
