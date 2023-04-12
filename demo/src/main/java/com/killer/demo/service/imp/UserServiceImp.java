package com.killer.demo.service.imp;

import com.killer.demo.mapper.BsUserPOMapper;
import com.killer.demo.po.BsUserPO;
import com.killer.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class UserServiceImp implements UserService {
    private static final String userName ="李狗蛋";

    private BsUserPOMapper bsUserPOMapper;
    private  final Integer userId;//李狗蛋

    public UserServiceImp(BsUserPOMapper bsUserPOMapper) {
        this.bsUserPOMapper = bsUserPOMapper;
        this.userId = bsUserPOMapper.selectByUserName(userName).getUserId();
        System.out.println(" init success userId="+this.userId);
    }


    @Override
    public BsUserPO qryUser() {
        System.out.println("查询用户");
        return  bsUserPOMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int delectUser(int id) {

        if (id>0) {
            System.out.println("删除用户成功，用户id="+id);
            return 1;
        }
        System.out.println("删除用户失败");
        return 0;
    }
}
