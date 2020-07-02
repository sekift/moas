package com.moas.crawler.util;

import me.midday.FoolNLTK;
import me.midday.lexical.AnalysisResult;
import me.midday.lexical.LexicalAnalyzer;
import me.midday.lexical.Word;

import java.util.ArrayList;
import java.util.List;

public class LSTMLexicalParserDemo {

    public static void main(String[] args){
        String text = "国务院任命香港特别行政区维护国家安全委员会秘书长";
        LexicalAnalyzer lexicalAnalyzer = FoolNLTK.getLSTMLexicalAnalyzer();
        // 分词，词性，实体识别
        List<AnalysisResult>  results = lexicalAnalyzer.analysis(text);
        //results.forEach(System.out::println);
        for(AnalysisResult result:results){
            List<Word> words = result.getWords();
            for(Word word:words){
                if(word.getPos().startsWith("n")) {
                    System.out.println(word.getContent() + " ; " + word.getPos());
                }
            }
        }

    }
}
