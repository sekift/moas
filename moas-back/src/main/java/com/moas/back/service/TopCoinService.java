package com.moas.back.service;

import com.moas.back.util.JsonRslt;

public interface TopCoinService {
    
    /**
     * 条件分页查询虚拟币信息
     * @return
     */
    JsonRslt search();


}
