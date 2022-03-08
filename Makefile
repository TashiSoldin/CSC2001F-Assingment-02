# Makefile

JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin
DOCDIR=doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

classes= BinaryTreeNode.class BinaryTree.class \
         BTQueueNode.class BTQueue.class \
         AVLTree.class AVLTreeTest.class

class_files=$(classes:%.class=$(BINDIR)/%.class)

default: $(class_files)

run:
	java -cp $(BINDIR) 

docs:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java

clean:
	rm $(BINDIR)/*.class