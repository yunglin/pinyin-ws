package com.bluetangstudio.shared.pinyin.token

import scala.collection.mutable.MutableList;
import com.bluetangstudio.shared.pinyin.{CharacterHelper, BoPoMoFoTable};

/**
 *
 * Turn String input into List[Token]. 
 *
 * TODO: use algorithm described at http://technology.chtsai.org/cscanner/ to create PhraseToken.
 */
class StringTokenizer(private val bpmfoTable: BoPoMoFoTable) {
    def tokenize(input: StringToken): List[ParsedToken] = {
        return tokenize(input.content);
    }

    def tokenize(input: String): List[ParsedToken] = {
        val ret = new MutableList[ParsedToken];

        // store the non-chinese characters. We will flush this out when we reach a chinses
        // character.
        val noOpString = new StringBuffer;
        input.foreach(ch => {
            if (CharacterHelper.isChineseCharacter(ch)) {
                var token: BoPoMoFoToken = null;

                // try to create a bopomofo token;
                val candidates = bpmfoTable.getBoPoMoFoFor(ch);
                // use the first bopomofo translation.
                if (candidates.length > 0) {
                    token = BoPoMoFoToken(candidates(0))
                }

                if (token != null) {
                    // if there is something in the buffer, added it to the list first.
                    if (noOpString.length > 0) {
                        ret += new NoOpToken(noOpString.toString);
                        noOpString.setLength(0);
                    }
                    ret += token;
                } else {
                    // fail to parse char, add it the NoOpString.
                    noOpString.append(ch);
                }
            } else {
                noOpString.append(ch);
            }
        });

        if (noOpString.length > 0) {
            ret += new NoOpToken(noOpString.toString);
            noOpString.setLength(0);
        }

        return ret.toList;
    }
}