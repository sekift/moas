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
import java.math.RoundingMode;
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
            //24*60分钟前
            List<TopCoin> rstList2460 = topCoinMapper.search(1441 * 60, 1439 * 60 - 10);

            // 7*24*60分钟前
            List<TopCoin> rstList72460 = topCoinMapper.search(10081 * 60, 10079 * 60 - 10);
            for (TopCoin coin0 : rstList) {
                TopCoinVO vo = new TopCoinVO();
                CommUtils.copyProperties(vo, coin0);
                BigDecimal last1 = vo.getLast();
                BigDecimal vol1 = vo.getVol();
                for (TopCoin coin : rstList10) {
                    if (coin.getCoinName().equals(vo.getCoinName())) {
                        BigDecimal last2 = coin.getLast();
                        BigDecimal diffLast = ((last1.subtract(last2)).divide(last2,2)).multiply(new BigDecimal(100));
                        BigDecimal vol2 = coin.getVol();
                        BigDecimal diffVol = ((vol1.subtract(vol2)).divide(vol2,2)).multiply(new BigDecimal(100));
                        vo.setDiffLast10(diffLast.setScale(2, RoundingMode.HALF_UP));
                        vo.setDiffVol10(diffVol.setScale(2, RoundingMode.HALF_UP));
                    }
                }

                for (TopCoin coin : rstList30) {
                    if (coin.getCoinName().equals(vo.getCoinName())) {
                        BigDecimal last2 = coin.getLast();
                        BigDecimal diffLast = ((last1.subtract(last2)).divide(last2,2)).multiply(new BigDecimal(100));
                        BigDecimal vol2 = coin.getVol();
                        BigDecimal diffVol = ((vol1.subtract(vol2)).divide(vol2,2)).multiply(new BigDecimal(100));
                        vo.setDiffLast30(diffLast.setScale(2, RoundingMode.HALF_UP));
                        vo.setDiffVol30(diffVol.setScale(2, RoundingMode.HALF_UP));
                    }
                }

                for (TopCoin coin : rstList60) {
                    if (coin.getCoinName().equals(vo.getCoinName())) {
                        BigDecimal last2 = coin.getLast();
                        BigDecimal diffLast = ((last1.subtract(last2)).divide(last2,2)).multiply(new BigDecimal(100));
                        BigDecimal vol2 = coin.getVol();
                        BigDecimal diffVol = ((vol1.subtract(vol2)).divide(vol2,2)).multiply(new BigDecimal(100));
                        vo.setDiffLast60(diffLast.setScale(2, RoundingMode.HALF_UP));
                        vo.setDiffVol60(diffVol.setScale(2, RoundingMode.HALF_UP));
                    }
                }

                for (TopCoin coin : rstList1260) {
                    if (coin.getCoinName().equals(vo.getCoinName())) {
                        BigDecimal last2 = coin.getLast();
                        BigDecimal diffLast = ((last1.subtract(last2)).divide(last2,2)).multiply(new BigDecimal(100));
                        BigDecimal vol2 = coin.getVol();
                        BigDecimal diffVol = ((vol1.subtract(vol2)).divide(vol2,2)).multiply(new BigDecimal(100));
                        vo.setDiffLast1260(diffLast.setScale(2, RoundingMode.HALF_UP));
                        vo.setDiffVol1260(diffVol.setScale(2, RoundingMode.HALF_UP));
                    }
                }

                for (TopCoin coin : rstList2460) {
                    if (coin.getCoinName().equals(vo.getCoinName())) {
                        BigDecimal last2 = coin.getLast();
                        BigDecimal diffLast = ((last1.subtract(last2)).divide(last2,2)).multiply(new BigDecimal(100));
                        BigDecimal vol2 = coin.getVol();
                        BigDecimal diffVol = ((vol1.subtract(vol2)).divide(vol2,2)).multiply(new BigDecimal(100));
                        vo.setDiffLast2460(diffLast.setScale(2, RoundingMode.HALF_UP));
                        vo.setDiffVol2460(diffVol.setScale(2, RoundingMode.HALF_UP));
                    }
                }

//                Double last2 = vo.getLastDay().doubleValue();
//                String diff = String.format("%.2f", (last1 - last2) / last2 * 100);
//                Double vol2 = vo.getVol().doubleValue();
//                String diffVol = String.format("%.2f", (vol1 - vol2) / vol2 * 100);
//                vo.setDiff2460(diff + "|" + diffVol);
                vo.setBuySell(vo.getBuy().setScale(3, RoundingMode.HALF_UP) + "/"
                        +vo.getSell().setScale(3, RoundingMode.HALF_UP));
                vo.setHighLow(vo.getHigh().setScale(3, RoundingMode.HALF_UP)+"/"
                        +vo.getLow().setScale(3, RoundingMode.HALF_UP));
                vo.setVol(vo.getVol().setScale(0, RoundingMode.HALF_UP));
                vo.setMoney(vo.getMoney().setScale(0, RoundingMode.HALF_UP));
                list.add(vo);
            }

            return JsonRslt.putSuccess(list);
        } catch (Exception e) {
            LogUtils.logError(CommUtils.getException(e));
        }
        return JsonRslt.putError(localeMessage.getMessage("FAIL", 0)/*失败*/);
    }

}
