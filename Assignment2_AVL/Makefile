all:	./bin/LSArrayApp.class	
#./bin/BinaryTreeNode.class	./bin/BinaryTree.class ./bin/BinarySearchTree.class	./bin/LSBSTApp.class
# define a makefile variable for the java compiler
JCC = javac
#params=" "

default: ./bin/LSArrayApp.class

#Hacky wildcard * method to compile all in 1 go
./bin/LSArrayApp.class: ./src/LSArrayApp.java
	$(JCC) -d ./bin -g ./src/*.java

./bin/LSBSTApp.class: ./src/LSBSTApp.java
	$(JCC) -d ./bin -g ./src/*.java
# Removes all .class files, so that the next make rebuilds them
./bin/BinarySearchTree.class: ./src/BinarySearchTree.java
	$(JCC) -d ./bin -g ./src/BinarySearchTree.java

./bin/BinaryTree.class: ./src/BinaryTree.java
	$(JCC) -d ./bin -g ./src/BinaryTree.java

./bin/BinaryTreeNode.class: ./src/BinaryTreeNode.java
	$(JCC) -d ./bin -g ./src/BinaryTreeNode.java

docs:
	javadoc -classpath bin/ -d doc/ src/*.java

clean:
	$(RM) ./bin/*.class

bst: ./bin/LSBSTApp.class
	@java -cp ./bin LSBSTApp  $(params)

avl: ./bin/LSArrayApp.class
	@java -cp ./bin AVLApp $(params)
