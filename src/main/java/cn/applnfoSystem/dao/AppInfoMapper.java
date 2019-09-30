package cn.applnfoSystem.dao;

import cn.applnfoSystem.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {
    public List<AppInfo> getAppInfoList(@Param(value = "softwareName")String querySoftwareName,
                                        @Param("status")Integer queryStatus,
                                        @Param("categoryLevel1")Integer queryCategoryLevel1,
                                        @Param("categoryLevel2")Integer queryCategoryLevel2,
                                        @Param("categoryLevel3")Integer queryCategoryLevel3,
                                        @Param("flatformId")Integer queryFlatformId,
                                        @Param("devId")Integer devId,
                                        @Param("from")Integer currentPageNo,
                                        @Param("pageSize")Integer pageSize)throws Exception;
    public int getAppInfoCount(@Param(value = "softwareName")String querySoftwareName,
                               @Param("status")Integer queryStatus,
                               @Param("categoryLevel1")Integer queryCategoryLevel1,
                               @Param("categoryLevel2")Integer queryCategoryLevel2,
                               @Param("categoryLevel3")Integer queryCategoryLevel3,
                               @Param("flatformId")Integer queryFlatformId,
                               @Param("devId")Integer devId)throws Exception;
}
