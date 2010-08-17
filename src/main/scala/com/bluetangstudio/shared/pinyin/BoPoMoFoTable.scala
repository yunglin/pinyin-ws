package com.bluetangstudio.shared.pinyin

class BoPoMoFoTable(private val table: Map[Char, List[String]]) {

    def getBoPoMoFoFor(ch: Char): List[String] = {
        return table.get(ch).get;
    }

}