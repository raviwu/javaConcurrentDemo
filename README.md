## Project Purpose

ServiceA to ServiceE are stand alone services that won't affect each other during the execution.

ServiceF and ServiceG are aggregator that depends on the calculation result of the stand alone services.

The design will be focus on:

1. Reduce the time required in total.
2. Make sure the data is correctly sum up in aggregator services.

## Execution

This is a Java CLI DEMO, using `javac` to compile the source code and `java` to execute the DEMO.
