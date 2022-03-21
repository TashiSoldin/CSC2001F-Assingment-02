# Makefile

JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin
DOCDIR=doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

classes= Vaccine.class BinaryTreeNode.class BTQueueNode.class BTQueue.class BinaryTree.class \
         AVLTree.class AVLTreeTest.class AVLExperiment.class

class_files=$(classes:%.class=$(BINDIR)/%.class)

default: $(class_files)

run:
	java -cp $(BINDIR) AVLExperiment 10

docs:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java

clean:
	rm $(BINDIR)/*.class