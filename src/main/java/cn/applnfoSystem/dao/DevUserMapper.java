package cn.applnfoSystem.dao;

import cn.applnfoSystem.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface DevUserMapper {

    /**
     * app开发者平台登录验证
     * @param devCode
     * @param
     * @return
     */
    public DevUser The_login(@Param("devCode")String devCode);
}
