import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object Question_1 {
    def main(args: Array[String]) {
        val inputDir = args(0)
        var outputDir= args(1)
        val schemaMovie = StructType(Array(StructField("mID",LongType,true),
        StructField("title",StringType,true),
        StructField("year",LongType,true),
        StructField("director",StringType,true)
        ))
        val spark = SparkSession.builder.appName("Question_1").getOrCreate()
        val movie =spark
	    .read
	    .option("inferSchema","true").option("header","true").schema(schemaMovie)
	    .csv(inputDir)
    import spark.implicits._
        val donneesDF=movie
	    .filter(col("director") === "James Cameron")

    donneesDF.write
	.option("header",true)
	.option("sep",";")
	.csv(outputDir)
    spark.stop()
    }
}