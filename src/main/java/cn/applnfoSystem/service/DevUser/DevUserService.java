package cn.applnfoSystem.service.DevUser;

import cn.applnfoSystem.pojo.BackendUser;
import cn.applnfoSystem.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface DevUserService {

    /**
     * app开发者平台登录验证
     * @param devCode
     * @param
     * @return
     */
    public DevUser The_login(@Param("devCode")String devCode);
}
