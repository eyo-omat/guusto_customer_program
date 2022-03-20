#!/bin/bash
#### Build guusto registry
cd ./guusto-registry
mvn clean package
echo "Finished packaging guusto-registry"

#### Build guusto service
cd ../guusto-service
mvn clean package
echo "Finished packaging guusto-service"

#### Build balance service
cd ../balance-service
mvn clean package
echo "Finished packaging balance-service"