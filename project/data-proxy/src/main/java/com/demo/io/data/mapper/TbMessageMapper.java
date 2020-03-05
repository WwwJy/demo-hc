package com.demo.io.data.mapper;

import com.demo.io.data.model.TbMessage;

public interface TbMessageMapper {
    int deleteByPrimaryKey(Long messageId);

    int insert(TbMessage record);

    int insertSelective(TbMessage record);

    TbMessage selectByPrimaryKey(Long messageId);

    int updateByPrimaryKeySelective(TbMessage record);

    int updateByPrimaryKey(TbMessage record);
}