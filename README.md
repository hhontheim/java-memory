# Java-Memory

[![Build Status](https://travis-ci.com/hhontheim/java-memory.svg?branch=master)](https://travis-ci.com/hhontheim/java-memory)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/16588cd5b6d94cfbbc00b9b466c6ef22)](https://www.codacy.com/app/hhontheim/java-memory?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=hhontheim/java-memory&amp;utm_campaign=Badge_Grade)
[![codecov](https://codecov.io/gh/hhontheim/java-memory/branch/master/graph/badge.svg)](https://codecov.io/gh/hhontheim/java-memory)

This is a simple Java application to show the runtime's current memory allocation to test JVM flags.

## Getting started

### How to run

To run this application simply download the `.jar`-file from the releases tab. I recommend downloading latest `java-memory-x.x.x-jar-with-dependencies.jar` as it contains all necessary dependencies.

### How to build

To build this project on your own just run

```bash
mvn clean compile assembly:single
```

in the project's root. Then `cd` to the `target`-folder and there you go!

## What can I do?

Try running the `.jar` from shell:

```bash
java -jar java-memory-x.x.x-jar-with-dependencies.jar
```

Look at the runtime's max memory. Now try using `4 GB` of RAM:

```bash
java -Xmx4G -jar java-memory-x.x.x-jar-with-dependencies.jar
```

See the difference? :smile:
