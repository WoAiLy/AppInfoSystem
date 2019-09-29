package cn.applnfoSystem.service.BackendUser;

import cn.applnfoSystem.pojo.BackendUser;
import org.apache.ibatis.annotations.Param;

public interface BackendUserService {

    public BackendUser login(@Param("userCode")String userCode);
}
