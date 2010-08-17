package com.bluetangstudio.shared.pinyin.romanization

/**
 * Created by IntelliJ IDEA.
 * User: hyl
 * Date: Aug 17, 2010
 * Time: 2:13:40 PM
 * To change this template use File | Settings | File Templates.
 */

trait RomanizationTable {

    protected def table:Map[String, String];

    def lookup(sound: String): String = {
        val ret = table.get(sound);
        if (ret == None) {
            return sound;
        }
        return ret.get;
    }
}