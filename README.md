Remove-Item -Recurse -Force .git

git init

javac -d out -sourcepath src src/Main.java

java -cp out Main
