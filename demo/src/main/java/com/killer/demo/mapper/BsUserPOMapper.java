package com.killer.demo.mapper;

import com.killer.demo.po.BsUserPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BsUserPOMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(BsUserPO record);

    int insertSelective(BsUserPO record);

    BsUserPO selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(BsUserPO record);

    int updateByPrimaryKey(BsUserPO record);
    BsUserPO selectByUserName(String userName);
}