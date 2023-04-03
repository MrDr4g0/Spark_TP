# TP_Spark

## REPONSE

spark-submit --class question_1 --master yarn --deploy-mode cluster --queue default target/scala-2.13/simple-project_2.13-1.0.jar hdfs:///home/lbrandy/Spark_TP/movie.csv hdfs:///home/lbrandy/Spark_TP/reponse_1

# schema

val schemaMovie = StructType(Array(StructField("mID",LongType,true),
StructField("title",StringType,true),
StructField("year",LongType,true),
StructField("director",StringType,true)
))