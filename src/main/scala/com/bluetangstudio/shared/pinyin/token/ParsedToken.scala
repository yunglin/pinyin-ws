package com.bluetangstudio.shared.pinyin.token

import com.bluetangstudio.shared.pinyin.OutputFormat;

trait ParsedToken extends Token{
    def toString(spec: OutputFormat): String;
}