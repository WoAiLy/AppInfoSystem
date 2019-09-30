package cn.applnfoSystem.controller.develop;

import cn.applnfoSystem.controller.DevUserController;
import cn.applnfoSystem.pojo.AppCategory;
import cn.applnfoSystem.pojo.AppInfo;
import cn.applnfoSystem.pojo.DataDictionary;
import cn.applnfoSystem.pojo.DevUser;
import cn.applnfoSystem.service.AppInfoService;
import cn.applnfoSystem.tools.Constants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.krb5.internal.APOptions;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/dev/app")
public class AppInfoController {

    private Logger logger = Logger.getLogger(DevUserController.class);

    @Resource
    private AppInfoService appInfoService;

    public String getAppInfoList(Model model, HttpSession session, @RequestParam(value = "querySoftwareName",required = false)String _querySoftwareName,
                                 @RequestParam(value = "queryStatus",required = false)String _queryStatus,
                                 @RequestParam(value = "queryCategroyLevel1",required = false)String _queryCategroyLevel1,
                                 @RequestParam(value = "queryCategroyLevel2",required = false)String _queryCategroyLevel2,
                                 @RequestParam(value = "queryCategroyLevel3",required = false)String _queryCategroyLevel3,
                                 @RequestParam(value = "queryFlatformId",required = false)String _queryFlatformId,
                                 @RequestParam(value = "pageIndex",required = false)String pageIndex){
        logger.info("getAppInfoList--->querySoftwareName:"+_querySoftwareName);
        logger.info("getAppInfoList--->queryStatus:"+_queryStatus);
        logger.info("getAppInfoList--->queryCategroyLeve1:"+_queryCategroyLevel1);
        logger.info("getAppInfoList--->queryCategroyLeve2:"+_queryCategroyLevel2);
        logger.info("getAppInfoList--->queryCategroyLeve3:"+_queryCategroyLevel3);
        logger.info("getAppInfoList--->queryFlatformId:"+_queryFlatformId);
        logger.info("getAppInfoList--->pageIndex:"+pageIndex);
            Integer devId=((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId();
        List<AppInfo> appInfoList=null;
        List<DataDictionary> statusList=null;
        List<DataDictionary> flatFormList=null;
        //列出一级分类列表
        List<AppCategory> categoryLevel1List=null;
        List<AppCategory> categoryLevel2List=null;
        List<AppCategory> categoryLevel3List=null;

        //页面容量
        int pageSize=Constants.pageSize;
        //当前页码
        Integer currentPageNo=1;
        if (pageIndex!=null){
            try{
                currentPageNo=Integer.valueOf(pageIndex);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
        Integer queryStatus=null;
        if (_queryStatus!=null && !("").equals(_queryStatus)){
            queryStatus=Integer.parseInt(_queryStatus);
        }
        String querySoftwareName=null;
        if (querySoftwareName!=null && !("").equals(querySoftwareName)){
            querySoftwareName=_querySoftwareName;
        }
        Integer queryCategoryLevel1=null;
        if (queryCategoryLevel1!=null && !("").equals(queryCategoryLevel1)){
            queryCategoryLevel1=Integer.parseInt(_queryCategroyLevel1);
        }
        Integer queryCategoryLevel2=null;
        if (queryCategoryLevel2!=null && !("").equals(queryCategoryLevel2)){
            queryCategoryLevel2=Integer.parseInt(_queryCategroyLevel2);
        }
        Integer queryCategoryLevel3=null;
        if (queryCategoryLevel3!=null && !("").equals(queryCategoryLevel3)){
            queryCategoryLevel3=Integer.parseInt(_queryCategroyLevel3);
        }
        Integer queryFlatformId=null;
        if (queryFlatformId!=null && !("").equals(queryFlatformId)){
            queryFlatformId=Integer.parseInt(_queryFlatformId);
        }
        //总数
        int totalCount=0;
        try{
            totalCount=appInfoService.getAppInfoCount(querySoftwareName,queryStatus,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3,queryFlatformId,devId);
            statusList=this.getDataDictionaryList(_queryStatus);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
    public List<DataDictionary> getDataDictionaryList(String status){
        List<DataDictionary> list=null;
        return list;

    }
}
