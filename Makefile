# define a makefile variable for the java compiler
JCC = javac

# define a makefile variable for compilation flags

# make runs first target which is default in this case

default: ./out/LSArrayApp.class

./out/LSArrayApp.class: ./src/LSArrayApp.java
	$(JCC) -d ./out -g ./src/LSArrayApp.java

# Removes all .class files, so that the next make rebuilds them

clean:
	$(RM) *.class

run: ./out/LSArrayApp.class
	java -cp ./out LSArrayApp


