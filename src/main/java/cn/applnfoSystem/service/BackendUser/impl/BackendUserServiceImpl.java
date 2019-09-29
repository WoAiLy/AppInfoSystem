package cn.applnfoSystem.service.BackendUser.impl;

import cn.applnfoSystem.dao.BackendUserMapper;
import cn.applnfoSystem.pojo.BackendUser;
import cn.applnfoSystem.service.BackendUser.BackendUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class BackendUserServiceImpl implements BackendUserService {

    @Resource
    private BackendUserMapper backendUserMapper;

    @Transactional
    @Override
    public BackendUser login(String userCode) {
        return backendUserMapper.login(userCode);
    }
}
