var=0
while read p; do
  echo "0,0,0,$var,$p"
  var=$((var+1))
done <ackley.csv>ackley-tmp.csv

sed -e "s/0,0,0,0/run,target,generation,index/g" ackley-tmp.csv > ackley-expanded.csv
rm ackley-tmp.csv

