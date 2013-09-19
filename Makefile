VERSION=0.1

ROBOCODE_HOME?=.
ROBOCODE_LIBS?=$(wildcard $(ROBOCODE_HOME)/libs/picocontainer*.jar $(ROBOCODE_HOME)/libs/robocode*.jar)
CLASSPATH=$(patsubst %:,%, $(subst : ,:, $(foreach jar,$(ROBOCODE_LIBS),$(jar):)))

MODULES?=rhino yeti
TARGETS=robocode.loaders-$(VERSION).jar $(MODULES:%=robocode.loaders.%-$(VERSION).jar)

NAMESPACE_PATH=net/sf/robocode/loaders
COMMON_SRCS=$(wildcard common/*.java)
COMMON_CLASSES=$(patsubst common/%.java,net/sf/robocode/loaders/%.class, $(COMMON_SRCS))


.PHONY: all clean $(MODULES)

all: $(TARGETS)

all-in-one: $(COMMON_CLASSES) $(MODULES)
	jar cvf robocode.loaders.allinone-$(VERSION).jar $$(find net -name '*.class')

clean:
	rm -rf net *.jar

yeti: $(NAMESPACE_PATH)/yeti

rhino: rhino/Module.java $(COMMON_CLASSES)
	javac -cp .:/usr/share/java/js.jar:$(CLASSPATH) -d . $(<:%/Module.java=%)/*.java

robocode.loaders-$(VERSION).jar: $(COMMON_CLASSES)
	jar cvf $@ $(COMMON_CLASSES)

robocode.loaders.%-$(VERSION).jar: %
	jar cvf $@ $(NAMESPACE_PATH)/$</*.class

$(COMMON_CLASSES): $(COMMON_SRCS)
	javac -cp .:$(CLASSPATH) -d . $(COMMON_SRCS)

$(NAMESPACE_PATH)/%: %/Module.java $(COMMON_CLASSES)
	javac -cp .:$(CLASSPATH) -d . $(<:%/Module.java=%)/*.java
