package cn.applnfoSystem.service;

import cn.applnfoSystem.pojo.AppInfo;

import java.util.List;

public interface AppInfoService {
    /**
     *根据条件获取appInfo集合
     * @param querySoftwareName
     * @param queryStatus
     * @param queryCategoryLevel1
     * @param queryCategoryLevel2
     * @param queryCategoryLevel3
     * @param queryFlatformId
     * @param devId
     * @param currentPageNo
     * @param pageSize
     * @return
     */
    public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3,
                                        Integer queryFlatformId, Integer devId, Integer currentPageNo, Integer pageSize) throws Exception;

    public int getAppInfoCount(String querySoftwareName, Integer queryStatus, Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3,
                               Integer queryFlatformId, Integer devId) throws Exception;
}
