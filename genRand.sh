#!/bin/bash

#Bailey Phan
#July 24, 2017
#Purpose: Tests TwoSum by generating $1 random integers in range from 0 to $2 and runs TwoSum with the generated integers as input

#compile
#javac -d bin/ -cp src src/random/TwoSum.java

if [ -z $1 ] && [ -z $2 ] #check to see if first argument is set
	then 
	echo "Usage: ./genRand.sh <number of integers> <range of integers>."
	exit
fi

#generate the random integers and store
rand_ints=""

for i in $(seq $1);
do
	rand_ints+=$(( $RANDOM % $2))" "
done

#pass to program
echo $rand_ints | xargs java -cp bin random.TwoSum 