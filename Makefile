# define a makefile variable for the java compiler
JCC = javac
#params=" "
# define a makefile variable for compilation flags

# make runs first target which is default in this case

default: ./bin/LSArrayApp.class

./bin/LSArrayApp.class: ./src/LSArrayApp.java
	$(JCC) -d ./bin -g ./src/LSArrayApp.java

# Removes all .class files, so that the next make rebuilds them

clean:
	$(RM) *.class

run: ./bin/LSArrayApp.class
	java -cp ./bin LSArrayApp  $(params)
