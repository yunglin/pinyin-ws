package com.bluetangstudio.shared.pinyin.token

import com.bluetangstudio.shared.pinyin.OutputFormat;

class TokenProcessor {
    def translate(token: ParsedToken, spec: OutputFormat): String = {
        return process(token).map(_.toString(spec)).mkString;
    }

    def process(tokens: List[Token]): List[Token] = {
        var ret = List[Token]();

        tokens.foreach(token => {
            ret = ret ::: process(token);
        });

        return ret;
    }

    /**
     * default handler for token.
     *
     * @param token
     * @return
     */
    def process(token: Token): List[ParsedToken] = {
        return List(new NoOpToken(token.toString));
    }

    /**
     *
     * @param token
     * @return list of phrase token, BoPoMoFo token, and NoOpToken.
     */
    def process(token: StringToken): List[ParsedToken] = {
        return Nil;
    }

    def process(token: PhraseToken): List[ParsedToken] = {
        return Nil;
    }
}