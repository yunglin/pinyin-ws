object Test {
   def main(args: Array[String]) = {
       val f = scala.io.Source.fromFile(args(0));
       f.getLines().foreach(line => {
           var csv = line.split(' ')
           if (csv.length > 1) {
              printf("'%s' -> '%s',\n", csv(0), csv(1));
           }
       })
   }

}
