package cn.applnfoSystem.service.DevUser;

import cn.applnfoSystem.dao.DevUserMapper;
import cn.applnfoSystem.pojo.BackendUser;
import cn.applnfoSystem.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevUserServiceImpl implements DevUserService{

    @Resource
    private DevUserMapper devUserMapper;


    /**
     * app开发者平台登录验证
     * @param devCode
     * @param
     * @return
     */
    public DevUser The_login(String devCode) {
        return devUserMapper.The_login(devCode);
    }
}
