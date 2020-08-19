package com.isoft.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {
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
