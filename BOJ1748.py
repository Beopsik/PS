from sys import stdin
from unicodedata import digit

n=int(stdin.readline())
k=len(str(n))

digitNum=0
for i in range(1, k):
    temp=pow(10, i)-pow(10, i-1)
    digitNum+=temp*i

start=pow(10, k-1)
digitNum+=(n-start+1)*k
print(digitNum)
