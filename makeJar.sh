echo "Main-Class: Main" > manifest.txt
javac *.java
javac Graphics/*.java
javac Features/*.java
javac Listeners/*.java
jar cvfm CircuitSimulator.jar manifest.txt Main.class *.class Graphics/*.class Features/*.class Listeners/*.class
cp CircuitSimulator.jar ~/desktop/CircuitSimulator.jar
rm manifest.txt
