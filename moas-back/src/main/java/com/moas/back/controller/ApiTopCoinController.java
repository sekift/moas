package com.moas.back.controller;

import com.moas.back.service.TopCoinService;
import com.moas.back.util.JsonRslt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topcoin")
@Api(tags="虚拟币信息API")
public class ApiTopCoinController {

    @Autowired
    private TopCoinService topCoinService;

    /**
     * 查询虚拟币信息
     * @return
     */
    @GetMapping(value = "/search")
    @ApiOperation(value="查询条件热点信息", notes="虚拟币信息接口" ,httpMethod="GET")
    public JsonRslt search() {
        return topCoinService.search();
    }

}