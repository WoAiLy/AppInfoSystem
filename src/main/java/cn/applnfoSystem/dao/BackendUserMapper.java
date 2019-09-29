package cn.applnfoSystem.dao;


import cn.applnfoSystem.pojo.BackendUser;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface BackendUserMapper {

    public BackendUser login(@Param("userCode")String userCode);

    public List<BackendUser> getAllBackendUser(@Param(value = "softwareName")String softwareName);
}
