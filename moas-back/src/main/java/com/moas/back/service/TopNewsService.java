package com.moas.back.service;

import com.moas.back.util.JsonRslt;
import com.moas.back.vo.TopNewsVO;

public interface TopNewsService {

    /**
     * 新增消息信息
     * @param topNewsVO
     * @return
     */
    JsonRslt insert(TopNewsVO topNewsVO);
    
    /**
     * 条件分页查询消息信息
     * @param topNewsVO
     * @return
     */
    JsonRslt search(TopNewsVO topNewsVO);
    
    /**
     * 消息信息单条记录查询
     * @param topid
     * @return
     */
    JsonRslt select(Long topid);

    /**
     * 消息信息记录修改
     * @param topNewsVO
     * @return
     */
    JsonRslt edit(TopNewsVO topNewsVO);

    /**
     * 删除消息信息
     * @param topid
     * @return
     */
    JsonRslt del(Long topid);

}
