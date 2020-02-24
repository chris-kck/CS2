# define a makefile variable for the java compiler
JCC = javac

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information

JFLAGS = -g

# make runs first target which is default in this case
#
default: LSArrayApp.class


LSArrayApp.class: LSArrayApp.java
        $(JCC) $(JFLAGS) LSArrayApp.java

# Removes all .class files, so that the next make rebuilds them

clean:
        $(RM) *.class