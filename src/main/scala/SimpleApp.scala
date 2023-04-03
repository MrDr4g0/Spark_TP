/* SimpleApp.scala */
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SimpleApp {
  def main(args: Array[String]) {
    val inputDir = args(0)
    var outputDir= args(1)
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val collisions =spark
	.read
	.option("inferSchema","true").option("header","true")
	.csv(inputDir)
import spark.implicits._
    val donneesDF=collisions
	.where($"borough".isNotNull)
	.groupBy("borough")
	.agg(sum("number_of_persons_killed") as "total_killed")
	.sort($"total_killed")

    donneesDF.write
	.option("header",true)
	.option("sep",";")
	.csv(outputDir)
    spark.stop()
  }
}
