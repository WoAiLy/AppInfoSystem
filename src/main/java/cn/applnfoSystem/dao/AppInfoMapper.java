package cn.applnfoSystem.dao;

import cn.applnfoSystem.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {
    public List<AppInfo> getAppInfoList(@Param(value = "softwareName")String softwareName,
                                        @Param("status")Integer status,
                                        @Param("categoryLevel1")Integer categoryLevel1,
                                        @Param("categoryLevel2")Integer categoryLevel2,
                                        @Param("categoryLevel3")Integer categoryLevel3,
                                        @Param("flatformId")Integer flatformId,
                                        @Param("devId")Integer devId,
                                        @Param("from")Integer currentPageNo,
                                        @Param("pageSize")Integer pageSize);
}
