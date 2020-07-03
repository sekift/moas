package com.moas.back.controller;

import com.moas.back.service.TopWordsService;
import com.moas.back.util.JsonRslt;
import com.moas.back.vo.TopWordsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/topwords")
@Api(tags="词语信息API")
public class ApiTopWordsController {

    @Autowired
    private TopWordsService topWordsService;

    /**
     * 查询词语信息
     * @param topWordsVO
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value="查询条件词语信息", notes="词语信息接口，支持wordid、content、sourceid或cource" ,httpMethod="POST")
    public JsonRslt search(@RequestBody TopWordsVO topWordsVO) {
        return topWordsService.search(topWordsVO);
    }

    /**
     * 词语信息单条记录查询
     * @param topWordsVO
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ApiOperation(value="查询单条词语信息", notes="词语信息接口，只传wordid即可" ,httpMethod="POST")
    public JsonRslt select(@RequestBody TopWordsVO topWordsVO) {
        return topWordsService.select(topWordsVO.getWordid());
    }

    /**
     * 词语信息插入
     * @param topWordsVO
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value="词语信息插入", notes="词语信息接口，除了后台生成和readonly之外有什么传什么" ,httpMethod="POST")
    public JsonRslt insert(@RequestBody TopWordsVO topWordsVO) {
        return topWordsService.insert(topWordsVO);
    }

    /**
     * 词语信息修改
     * @param topWordsVO
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value="词语信息修改", notes="词语信息接口，除了后台生成和readonly之外有什么传什么" ,httpMethod="POST")
    public JsonRslt edit(@RequestBody TopWordsVO topWordsVO) {
        return topWordsService.edit(topWordsVO);
    }

    /**
     * 词语信息删除
     * @param topWordsVO
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(value="词语信息删除", notes="词语信息接口，只传wordid即可" ,httpMethod="POST")
    public JsonRslt del(@RequestBody TopWordsVO topWordsVO) {
        return topWordsService.del(topWordsVO.getWordid());
    }

    /**
     * 查询热点词语信息
     * @return
     */
    @RequestMapping(value = "/topWordsSearch", method = RequestMethod.POST)
    @ApiOperation(value="查询热点词语信息", notes="词语信息接口" ,httpMethod="POST")
    public JsonRslt topWordsSearch() {
        return topWordsService.topWordsSearch();
    }
}