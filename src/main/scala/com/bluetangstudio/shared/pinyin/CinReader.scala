package com.bluetangstudio.shared.pinyin

import scala.io.Source
import scala.collection.mutable.{Map => MutableMap, Set => MutableSet};

object CinReader {
    
    def read(source: Source): BoPoMoFoTable = {
        val cin = new InternalCinReader(source);
        val mmap = MutableMap[Char, List[String]]();
    
        cin.bopomofoTable.foreach(kv => mmap += (kv._1 -> kv._2.toList));
        
        return new BoPoMoFoTable(mmap.toMap);
    }
    
    def main(args: Array[String]): Unit = {
        val bompmofoTable = CinReader.read(scala.io.Source.fromFile(args(0)));
    }
}

class InternalCinReader(private val cin: Source) {

    val bopomofoTable = MutableMap[Char, MutableSet[String]]();
    
    private var inCharDef = false;

    cin.getLines().foreach(line => {
        var res = handleLine(line);
        res match {
            case (word: Char, spelling: String) => {
                var spellings: Option[MutableSet[String]] = bopomofoTable.get(word);

                if (spellings.isEmpty) {
                    bopomofoTable.update(word, MutableSet(spelling));
                } else {
                    spellings.get += spelling;
                }
            }
            case _ => 
        };
    });

    def handleLine(line: String): Any = {
        if (line.startsWith("%")) {
            if (line.startsWith("%chardef")) {
                if (line.contains("begin"))
                    inCharDef = true;
                else if (line.contains("end"))
                    inCharDef = false;
            }
            return;
        }

        if (inCharDef) {
            return handleChardef(line);
        }

        return;
    }

    def handleChardef(chardef: String): (Char, String) = {
        val x: Seq[String] = chardef.split(Array(' ', '\n', '\t')).filter(x => x.length != 0);
        val Seq(spelling, word) = x;
        return (word.toCharArray.apply(0), spelling);
    }
}
