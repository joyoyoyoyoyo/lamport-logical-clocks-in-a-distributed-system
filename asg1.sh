#!/bin/bash
first=$1
second=$2
sbt compile
sbt package
scala target/scala-2.12/distributed-systems-cs171-proj1_2.12-1.0.jar $first $second

