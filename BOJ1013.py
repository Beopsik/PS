import re
from sys import stdin

p=re.compile('(100+1+|01)+')
result=[]
n=int(stdin.readline())
for i in range(n):
    temp=stdin.readline().rstrip()
    if p.fullmatch(temp)!=None:
        result.append("YES\n")
    else:
        result.append("NO\n")
print("".join(result))
