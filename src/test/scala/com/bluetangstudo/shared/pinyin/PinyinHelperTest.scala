package com.bluetangstudio.shared.pinyin

import org.scalatest.testng.TestNGSuite
import org.scalatest.matchers.ShouldMatchers

import org.testng.Assert._
import org.testng.annotations.{DataProvider, Test}

class PinyinHelperTest extends TestNGSuite with ShouldMatchers {
    val helper = PinyinHelper;

    @DataProvider(name = "positive")
    def getPositiveTestData: Array[Array[Object]] = {
        Array(
            Array("中文-Test  !", "jhong wun -Test  !"),
            Array("中文是個舊東西  !", "jhong wun shih ge jiou dong si   !")

        )
    
    }

    @Test(dataProvider = "positive")
    def test(input: String, expected: String) {
        assertEquals(helper.toTongYong(input), expected);
    }

}