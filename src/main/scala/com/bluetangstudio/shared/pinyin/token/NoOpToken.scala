package com.bluetangstudio.shared.pinyin.token

import com.bluetangstudio.shared.pinyin.OutputFormat;

case class NoOpToken(content: String) extends ParsedToken {

    def toString(spec: OutputFormat): String = content;

}