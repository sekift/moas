
        package com.moas.crawler.nlp;

        import com.moas.crawler.model.TopNews;
        import com.moas.crawler.model.TopWords;
        import com.moas.crawler.service.TopWordsService;
        import com.moas.crawler.util.SnowflakeIdWorker;
        import com.moas.crawler.util.StringUtil;
        import me.midday.FoolNLTK;
        import me.midday.lexical.AnalysisResult;
        import me.midday.lexical.LexicalAnalyzer;
        import me.midday.lexical.Word;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.Date;
        import java.util.List;

/**
 * 分词，用于新闻聚集和跟踪
 * 分词词性总结
 *
 名词 (1个一类，7个二类，5个三类)
 名词分为以下子类：
 n 名词
 nr 人名
 nr1 汉语姓氏
 nr2 汉语名字
 nrj 日语人名
 nrf 音译人名
 ns 地名
 nsf 音译地名
 nt 机构团体名
 nz 其它专名
 nl 名词性惯用语
 ng 名词性语素

 时间词(1个一类，1个二类)
 t 时间词
 tg 时间词性语素

 处所词(1个一类)
 s 处所词

 方位词(1个一类)
 f 方位词

 动词(1个一类，9个二类)
 v 动词
 vd 副动词
 vn 名动词
 vshi 动词“是”
 vyou 动词“有”
 vf 趋向动词
 vx 形式动词
 vi 不及物动词（内动词）
 vl 动词性惯用语
 vg 动词性语素

 形容词(1个一类，4个二类)
 a 形容词
 ad 副形词
 an 名形词
 ag 形容词性语素
 al 形容词性惯用语

 区别词(1个一类，2个二类)
 b 区别词
 bl 区别词性惯用语

 状态词(1个一类)
 z 状态词

 代词(1个一类，4个二类，6个三类)
 r 代词
 rr 人称代词
 rz 指示代词
 rzt 时间指示代词
 rzs 处所指示代词
 rzv 谓词性指示代词
 ry 疑问代词
 ryt 时间疑问代词
 rys 处所疑问代词
 ryv 谓词性疑问代词
 rg 代词性语素

 数词(1个一类，1个二类)
 m 数词
 mq 数量词

 量词(1个一类，2个二类)
 q 量词
 qv 动量词
 qt 时量词

 副词(1个一类)
 d 副词

 介词(1个一类，2个二类)
 p 介词
 pba 介词“把”
 pbei 介词“被”

 连词(1个一类，1个二类)
 c 连词
 cc 并列连词

 助词(1个一类，15个二类)
 u 助词
 uzhe 着
 ule 了 喽
 uguo 过
 ude1 的 底
 ude2 地
 ude3 得
 usuo 所
 udeng 等 等等 云云
 uyy 一样 一般 似的 般
 udh 的话
 uls 来讲 来说 而言 说来
 uzhi 之
 ulian 连 （“连小学生都会”）

 叹词(1个一类)
 e 叹词

 语气词(1个一类)
 y 语气词(delete yg)

 拟声词(1个一类)
 o 拟声词

 前缀(1个一类)
 h 前缀

 后缀(1个一类)
 k 后缀

 字符串(1个一类，2个二类)
 x 字符串
 xx 非语素字
 xu 网址URL

 标点符号(1个一类，16个二类)
 w 标点符号
 wkz 左括号，全角：（ 〔 ［ ｛ 《 【 〖 〈 半角：( [ { <
 wky 右括号，全角：） 〕 ］ ｝ 》 】 〗 〉 半角： ) ] { >
 wyz 左引号，全角：“ ‘ 『
 wyy 右引号，全角：” ’ 』
 wj 句号，全角：。
 ww 问号，全角：？ 半角：?
 wt 叹号，全角：！ 半角：!
 wd 逗号，全角：， 半角：,
 wf 分号，全角：； 半角： ;
 wn 顿号，全角：、
 wm 冒号，全角：： 半角： :
 ws 省略号，全角：…… …
 wp 破折号，全角：—— －－ ——－ 半角：—
 wb 百分号千分号，全角：％ ‰ 半角：%
 wh 单位符号，全角：￥ ＄ ￡ ° ℃ 半角 $
 */
@Service
public class NlpService {

    @Autowired
    private TopWordsService topWordsService;

    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    private static LexicalAnalyzer lexicalAnalyzer = FoolNLTK.getLSTMLexicalAnalyzer();

    public void nlpParser(TopNews topNews){
        // 分词，词性，实体识别
        List<AnalysisResult> results = lexicalAnalyzer.analysis(topNews.getContent());
        results.forEach(System.out::println);
        for(AnalysisResult result:results){
            List<Word> words = result.getWords();
            for(Word word:words){
                if(word.getPos().startsWith("n")
                        && StringUtil.isNotEmpty(word.getContent())) {
                    TopWords topWords = new TopWords();
                    topWords.setWordid(snowflakeIdWorker.nextId());
                    topWords.setTopid(topNews.getTopid());
                    topWords.setWord(word.getContent());
                    topWords.setWordtype(word.getPos());
                    topWords.setCreatetime(new Date());
                    topWords.setUpdatetime(new Date());
                    topWords.setStatus(Byte.valueOf("1"));
                    topWords.setVisits(0);

                    topWordsService.insert(topWords);
                    //System.out.println(word.getContent() + " ; " + word.getPos());
                }
            }
        }
    }

}