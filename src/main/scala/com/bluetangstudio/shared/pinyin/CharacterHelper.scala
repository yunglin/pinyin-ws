package com.bluetangstudio.shared.pinyin

object CharacterHelper {

    def isChineseCharacter(ch: Char): Boolean = {
        val ub = Character.UnicodeBlock.of(ch);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) {
            return true;
        } else {
            return false;
        }
    }
}