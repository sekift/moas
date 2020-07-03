package com.moas.back.service;

import com.moas.back.util.JsonRslt;
import com.moas.back.vo.TopWordsVO;

public interface TopWordsService {

    /**
     * 新增分词信息
     * @param topWordsVO
     * @return
     */
    JsonRslt insert(TopWordsVO topWordsVO);

    /**
     * 条件分页查询分词信息
     * @param topWordsVO
     * @return
     */
    JsonRslt search(TopWordsVO topWordsVO);

    /**
     * 分词信息单条记录查询
     * @param wordid
     * @return
     */
    JsonRslt select(Long wordid);

    /**
     * 分词信息记录修改
     * @param topWordsVO
     * @return
     */
    JsonRslt edit(TopWordsVO topWordsVO);

    /**
     * 删除分词信息
     * @param wordid
     * @return
     */
    JsonRslt del(Long wordid);

    /**
     * 分词信息热点查询
     * @return
     */
    JsonRslt topWordsSearch();

}
