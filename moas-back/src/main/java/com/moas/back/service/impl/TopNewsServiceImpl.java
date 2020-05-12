package com.moas.back.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.moas.back.common.LocaleMessage;
import com.moas.back.dao.TopNewsMapper;
import com.moas.back.model.TopNews;
import com.moas.back.service.TopNewsService;
import com.moas.back.util.CommUtils;
import com.moas.back.util.JsonRslt;
import com.moas.back.util.LogUtils;
import com.moas.back.vo.TopNewsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TopNewsServiceImpl implements TopNewsService {

    @Resource
    private LocaleMessage localeMessage;

    @Autowired
    private TopNewsMapper topNewsMapper;

    @Override
    public JsonRslt insert(TopNewsVO topNewsVO) {
        try{
            TopNews topNews=new TopNews();
            CommUtils.copyProperties(topNews,topNewsVO);

            int count = topNewsMapper.insertSelective(topNews);
            if(count>0){
                return this.select(topNews.getTopid());
            }
        }catch (Exception e){
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("ADD_FAIL", 0)/*"新增失败"*/);
    }

    @Override
    public JsonRslt search(TopNewsVO topNewsVO) {
        try{
            PageHelper.startPage(topNewsVO.getPage(),topNewsVO.getRows());
            TopNews topNews = new TopNews();
            CommUtils.copyProperties(topNews,topNewsVO);
            List<TopNews> rstList = topNewsMapper.search(topNews);
            return JsonRslt.putSuccess(new PageInfo(rstList));
        }catch (Exception e){
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("FAIL", 0)/*失败*/);
    }

    @Override
    public JsonRslt select(Long topid) {
        TopNews topNews = topNewsMapper.selectByPrimaryKey(topid);
        return JsonRslt.putSuccess(topNews);
    }

    @Override
    public JsonRslt edit(TopNewsVO topNewsVO) {
        try{
            TopNews topNews=new TopNews();
            CommUtils.copyProperties(topNews,topNewsVO);
            int count = topNewsMapper.updateByPrimaryKeySelective(topNews);
            if(count>0){
                return this.select(topNews.getTopid());
            }
        }catch (Exception e){
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("EDT_FAIL", 0)/*"修改失败"*/);
    }


    @Override
    public JsonRslt del(Long topid) {
        try{
            int count = topNewsMapper.deleteByPrimaryKey(topid);
            if(count>0){
                return JsonRslt.putSuccess(localeMessage.getMessage("DEL_SUCCESS", 0)/*"删除成功"*/);
            }
        }catch (Exception e){
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("DEL_FAIL", 0)/*"删除失败"*/);
    }
}
