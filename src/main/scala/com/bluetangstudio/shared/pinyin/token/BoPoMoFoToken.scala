package com.bluetangstudio.shared.pinyin.token

import com.bluetangstudio.shared.pinyin.{ OutputFormat, TongYongTable, WadegilesTable };

case class BoPoMoFoToken(val sound: String, val tone: Int) extends ParsedToken {
  
    def toString(format: OutputFormat): String = {
        val withTone = (format & OutputFormat.WITH_TONE_NUMBER) == OutputFormat.WITH_TONE_NUMBER;

        var mappingTable: { def lookup(sound: String): String } = TongYongTable;
        if ((format & OutputFormat.WADEGILES_PINYIN) == OutputFormat.WADEGILES_PINYIN) {
            mappingTable = WadegilesTable;
        }
        var ret: String = "";
        ret += mappingTable.lookup(sound);
        if (withTone) {
            ret += tone;
        }
        return ret;
    }
}

object BoPoMoFoToken {
    def apply(in: String) : BoPoMoFoToken = {
        val toneChar = in.last;
        var tone = 0;
        toneChar match {
            case '3' => tone = 3;
            case '4' => tone = 4;
            case '6' => tone = 2;
            case '7' => tone = -1;
        }
        if (tone != 0)
            return new BoPoMoFoToken(in.substring(0, in.length - 1), tone);

        return new BoPoMoFoToken(in, 0);
    }
}