JCC = javac

target:
	$(JCC) -d ./bin -g ./src/*.java

clean:
	$(RM) ./bin/*.class

test: target
	@java -cp ./bin TestHashTable.java