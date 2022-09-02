from copy import deepcopy
from sys import stdin
T=int(stdin.readline())

result=[]
for t in range(T):
    n=int(stdin.readline())
    clothes={}
    for i in range(n):
        name, kind=map(str, stdin.readline().split())
        if kind in clothes:
            clothes[kind].append(name)
        else:
            clothes[kind]=[]
            clothes[kind].append(name)
    count=1
    for key in clothes.keys():
        count*=(len(clothes[key])+1)
    count-=1
    result.append(str(count))
print("\n".join(result))
