VERSION=0.1

ROBOCODE_HOME?=.
ROBOCODE_LIBS?=$(wildcard $(ROBOCODE_HOME)/libs/picocontainer*.jar $(ROBOCODE_HOME)/libs/robocode*.jar)
CLASSPATH=$(patsubst %:,%, $(subst : ,:, $(foreach jar,$(ROBOCODE_LIBS),$(jar):)))

MODULES?=rhino
TARGETS=$(MODULES:%=robocode.loaders.%-$(VERSION).jar)

NAMESPACE_PATH=net/sf/robocode/loaders
# COMMON_SRCS=$(wildcard common/*.java)
# COMMON_CLASSES=$(patsubst common/%.java,net/sf/robocode/loaders/%.class, $(COMMON_SRCS))


.PHONY: all clean $(MODULES)

all: $(TARGETS)

all-in-one: $(MODULES)
	jar cvf robocode.loaders.allinone-$(VERSION).jar $$(find net -name '*.class')

clean:
	rm -rf net *.jar

rhino: rhino/Module.java
	javac -cp .:/usr/share/java/js.jar:$(CLASSPATH) -d . $(<:%/Module.java=%)/*.java

robocode.loaders.%-$(VERSION).jar: %
	jar cvf $@ $(NAMESPACE_PATH)/$</*.class

$(NAMESPACE_PATH)/%: %/Module.java
	javac -cp .:$(CLASSPATH) -d . $(<:%/Module.java=%)/*.java
