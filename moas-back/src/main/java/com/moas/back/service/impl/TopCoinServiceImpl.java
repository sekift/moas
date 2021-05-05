package com.moas.back.service.impl;

import com.moas.back.common.LocaleMessage;
import com.moas.back.dao.TopCoinMapper;
import com.moas.back.model.TopCoin;
import com.moas.back.service.TopCoinService;
import com.moas.back.util.CommUtils;
import com.moas.back.util.JsonRslt;
import com.moas.back.util.LogUtils;
import com.moas.back.vo.TopCoinVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopCoinServiceImpl implements TopCoinService {

    @Resource
    private LocaleMessage localeMessage;

    @Autowired
    private TopCoinMapper topCoinMapper;

    @Override
    public JsonRslt search() {
        try {
            List<TopCoinVO> list = new ArrayList<>();
            // 最新的
            List<TopCoin> rstList = topCoinMapper.search(2 * 60 + 10, 0);
            // 10分钟前
            List<TopCoin> rstList10 = topCoinMapper.search(11 * 60, 9 * 60 - 10);
            // 30分钟前
            List<TopCoin> rstList30 = topCoinMapper.search(31 * 60, 29 * 60 - 10);
            // 60分钟前
            List<TopCoin> rstList60 = topCoinMapper.search(61 * 60, 59 * 60 - 10);
            // 12*60分钟前
            List<TopCoin> rstList1260 = topCoinMapper.search(721 * 60, 719 * 60 - 10);
            // 7*24*60分钟前
            //List<TopCoin> rstList72460 = topCoinMapper.search(10081 * 60, 10079 * 60 - 10);
            for(TopCoin coin0: rstList){
                TopCoinVO vo = new TopCoinVO();
                CommUtils.copyProperties(vo, coin0);
                Double last1 = vo.getLast().doubleValue();
                for(TopCoin coin10:rstList10){
                    if(coin10.getCoinName().equals(vo.getCoinName())){
                        Double last2 = coin10.getLast().doubleValue();
                        String diff = String.format("%.2f", (last1 - last2)/last2 * 100) + "%";
                        vo.setDiff10(diff);
                    }
                }

                for(TopCoin coin : rstList30){
                    if(coin.getCoinName().equals(vo.getCoinName())){
                        Double last2 = coin.getLast().doubleValue();
                        String diff = String.format("%.2f", (last1 - last2)/last2 * 100) + "%";
                        vo.setDiff30(diff);
                    }
                }

                for(TopCoin coin : rstList60){
                    if(coin.getCoinName().equals(vo.getCoinName())){
                        Double last2 = coin.getLast().doubleValue();
                        String diff = String.format("%.2f", (last1 - last2)/last2 * 100) + "%";
                        vo.setDiff60(diff);
                    }
                }

                for(TopCoin coin : rstList1260){
                    if(coin.getCoinName().equals(vo.getCoinName())){
                        Double last2 = coin.getLast().doubleValue();
                        String diff = String.format("%.2f", (last1 - last2)/last2 * 100) + "%";
                        vo.setDiff1260(diff);
                    }
                }

                Double last2 = vo.getLastDay().doubleValue();
                String diff = String.format("%.2f", (last1 - last2)/last2 * 100) + "%";
                vo.setDiff2460(diff);

                list.add(vo);
            }

            return JsonRslt.putSuccess(list);
        } catch (Exception e) {
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("FAIL", 0)/*失败*/);
    }

}
