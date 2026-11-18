#!/usr/bin/env bash

# Adds the columns run, target, generation and index to output/ackley.csv and
#   writes the result to output/ackley-expanded.csv.

set -e

var=0
while read -r p; do
  echo "0,0,0,$var,$p"
  var=$((var+1))
done <output/ackley.csv >output/ackley-tmp.csv
sed -e "s/0,0,0,0/run,target,generation,index/g" output/ackley-tmp.csv > output/ackley-expanded.csv
rm output/ackley-tmp.csv
