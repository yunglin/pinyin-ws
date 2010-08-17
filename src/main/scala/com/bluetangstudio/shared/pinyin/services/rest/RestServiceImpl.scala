/*
 * Copyright 2010 Blue Tang Studio. All rights reserved.
 * Date: Aug 17, 2010 3:35:17 PM
 *
 */
package com.bluetangstudio.shared.pinyin.services.rest

import com.bluetangstudio.shared.pinyin.PinyinHelper;

class RestServiceImpl extends RestService {

    val helper = PinyinHelper;

    def toTongYong(input: String): String = {
        helper.toTongYong(input);
    }    

    def toWadegiles(input: String): String = {
        helper.toWadegiles(input);
    }
}