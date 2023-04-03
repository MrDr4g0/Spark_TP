# TP_Spark

## SSH :
#### SSh key Generation 
```
cd ~/.ssh && ssh-keygen
```
####  You need to copy this to your clipboard.
```
cat id_rsa.pub
cd
```
####  Add your key to your account via the website.

### Setup your .gitconfig.
```
git config --global user.name "bob"
git config --global user.email bob@... 
```

## Clone the Github Repo:
```
git clone git@github.com:amesmoudi/Spark_TP.git
cd Spark_TP 
```

## Compiling and packaging
```
sbt package
```

The generated jar is located in : target/scala-2.13/simple-project_2.13-1.0.jar

## Running the jar using spark-submit


```
spark-submit --class SimpleApp --master yarn --deploy-mode cluster --queue default target/scala-2.13/simple-project_2.13-1.0.jar hdfs:///data/collisions/csv hdfs:///user/setudiant2/data/extract_0
```

### Running parameters: 
SimpleApp: The main Scala Object
hdfs:///data/collisions/csv: the input folder 
hdfs:///user/setudiant2/data/extract_0: the output folder
