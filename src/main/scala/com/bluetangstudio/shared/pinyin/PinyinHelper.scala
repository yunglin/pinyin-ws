package com.bluetangstudio.shared.pinyin

import scala.io.Source


object PinyinHelper {

    val instream = java.lang.Thread.currentThread().getContextClassLoader().getResourceAsStream("cnsphone.cin");

    val bpmfTable = CinReader.read(Source.fromInputStream(instream, "utf-8"));
    instream.close;
    
    val translator = new com.bluetangstudio.shared.pinyin.token.StringTokenizer(bpmfTable);
    
    def toTongYong(input: String): String = {
        val tokens = translator.tokenize(input);
        tokens.map(_.toString(OutputFormat.TONGYONG_PINYIN)).mkString(" ");
    }

    def main(args: Array[String]) {
        if (args.length > 0) {
            println(PinyinHelper.toTongYong(args.mkString(" ")));       
        }
    }
}