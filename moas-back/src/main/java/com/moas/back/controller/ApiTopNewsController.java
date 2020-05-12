package com.moas.back.controller;

import com.moas.back.service.TopNewsService;
import com.moas.back.util.JsonRslt;
import com.moas.back.vo.TopNewsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/topnews")
@Api(tags="热点信息API")
public class ApiTopNewsController {

    @Autowired
    private TopNewsService topNewsService;

    /**
     * 查询热点信息
     * @param topNewsVO
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value="查询条件热点信息", notes="热点信息接口，支持topid、content、sourceid或cource" ,httpMethod="POST")
    public JsonRslt search(@RequestBody TopNewsVO topNewsVO) {
        return topNewsService.search(topNewsVO);
    }

    /**
     * 热点信息单条记录查询
     * @param topNewsVO
     * @return
     */
    @RequestMapping(value = "/select", method = RequestMethod.POST)
    @ApiOperation(value="查询单条热点信息", notes="热点信息接口，只传albumid即可" ,httpMethod="POST")
    public JsonRslt select(@RequestBody TopNewsVO topNewsVO) {
        return topNewsService.select(topNewsVO.getTopid());
    }

    /**
     * 热点信息插入
     * @param topNewsVO
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ApiOperation(value="热点信息插入", notes="热点信息接口，除了后台生成和readonly之外有什么传什么" ,httpMethod="POST")
    public JsonRslt insert(@RequestBody TopNewsVO topNewsVO) {
        return topNewsService.insert(topNewsVO);
    }

    /**
     * 热点信息修改
     * @param topNewsVO
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ApiOperation(value="热点信息修改", notes="热点信息接口，除了后台生成和readonly之外有什么传什么" ,httpMethod="POST")
    public JsonRslt edit(@RequestBody TopNewsVO topNewsVO) {
        return topNewsService.edit(topNewsVO);
    }

    /**
     * 热点信息删除
     * @param topNewsVO
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @ApiOperation(value="热点信息删除", notes="热点信息接口，只传albumid即可" ,httpMethod="POST")
    public JsonRslt del(@RequestBody TopNewsVO topNewsVO) {
        return topNewsService.del(topNewsVO.getTopid());
    }

}