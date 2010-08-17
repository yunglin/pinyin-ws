package com.bluetangstudio.shared.pinyin

case class OutputFormat(val format: Int) {
    def | (additional: OutputFormat) : OutputFormat = {
        return OutputFormat(format | additional.format);
    }

    def & (additional: OutputFormat) : OutputFormat = {
        return OutputFormat(format & additional.format);
    }

    def == (toCompare: OutputFormat) : Boolean = {
        return format == toCompare.format;
    }
}

object OutputFormat {

    val WITH_TONE_NUMBER = OutputFormat(0x01);
    
    val WITHOUT_TONE_NUMBER = OutputFormat(0);
    
    val TONGYONG_PINYIN = OutputFormat(0x02);
 
    val WADEGILES_PINYIN_WITH_TONE = TONGYONG_PINYIN | WITH_TONE_NUMBER;
    
    val WADEGILES_PINYIN = OutputFormat(0x04);

}