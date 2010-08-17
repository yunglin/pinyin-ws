package com.bluetangstudio.shared.pinyin.token

/**
 * super class of all classes that parses inputs(file, etc...) into StringToken(s).
 * 
 */
trait TokenStream {

    def next: StringToken;

    def isClosed: Boolean;
}