#!/bin/bash
first=$1
second=$2
scalac -classpath -cp $PWD/src/main/scala/*.scala
scala Asg $first $second