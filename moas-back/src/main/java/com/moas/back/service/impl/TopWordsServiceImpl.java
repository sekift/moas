package com.moas.back.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moas.back.common.LocaleMessage;
import com.moas.back.dao.TopWordsMapper;
import com.moas.back.model.TopWords;
import com.moas.back.service.TopWordsService;
import com.moas.back.util.CommUtils;
import com.moas.back.util.JsonRslt;
import com.moas.back.util.LogUtils;
import com.moas.back.vo.TopWordsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopWordsServiceImpl implements TopWordsService {

    @Resource
    private LocaleMessage localeMessage;

    @Autowired
    private TopWordsMapper topWordsMapper;

    @Override
    public JsonRslt insert(TopWordsVO topWordsVO) {
        try{
            TopWords topWords=new TopWords();
            CommUtils.copyProperties(topWords,topWordsVO);

            int count = topWordsMapper.insertSelective(topWords);
            if(count>0){
                return this.select(topWords.getWordid());
            }
        }catch (Exception e){
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("ADD_FAIL", 0)/*"新增失败"*/);
    }

    @Override
    public JsonRslt search(TopWordsVO topWordsVO) {
        try{
            PageHelper.startPage(topWordsVO.getPage(),topWordsVO.getRows());
            TopWords topWords = new TopWords();
            CommUtils.copyProperties(topWords,topWordsVO);
            List<TopWords> rstList = topWordsMapper.search(topWords);
            return JsonRslt.putSuccess(new PageInfo(rstList));
        }catch (Exception e){
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("FAIL", 0)/*失败*/);
    }

    @Override
    public JsonRslt select(Long wordid) {
        TopWords topWords = topWordsMapper.selectByPrimaryKey(wordid);
        return JsonRslt.putSuccess(topWords);
    }

    @Override
    public JsonRslt edit(TopWordsVO topWordsVO) {
        try{
            TopWords topWords=new TopWords();
            CommUtils.copyProperties(topWords,topWordsVO);
            int count = topWordsMapper.updateByPrimaryKeySelective(topWords);
            if(count>0){
                return this.select(topWords.getWordid());
            }
        }catch (Exception e){
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("EDT_FAIL", 0)/*"修改失败"*/);
    }


    @Override
    public JsonRslt del(Long wordid) {
        try{
            int count = topWordsMapper.deleteByPrimaryKey(wordid);
            if(count>0){
                return JsonRslt.putSuccess(localeMessage.getMessage("DEL_SUCCESS", 0)/*"删除成功"*/);
            }
        }catch (Exception e){
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("DEL_FAIL", 0)/*"删除失败"*/);
    }

    @Override
    public JsonRslt topWordsSearch() {
        try{
            List<TopWords> rstList = topWordsMapper.topWordsSearch();
            return JsonRslt.putSuccess(rstList);
        }catch (Exception e){
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("FAIL", 0)/*失败*/);
    }
}
