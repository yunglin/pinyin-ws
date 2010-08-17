package com.bluetangstudio.shared.pinyin

import org.scalatest.testng.TestNGSuite
import org.scalatest.matchers.ShouldMatchers

import org.testng.Assert._
import org.testng.annotations.Test


class PinyinHelperTest extends TestNGSuite with ShouldMatchers {
    val helper = PinyinHelper;

    @Test def test() {
        assertEquals(helper.toTongYong("中文-Test  !"), "jhong wun -Test  !");
    }

}