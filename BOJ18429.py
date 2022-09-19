import itertools
from sys import stdin

n, k=map(int, stdin.readline().split())
kit=list(map(int, stdin.readline().split()))
order=itertools.permutations([i for i in range(0, n)], n)

result=0
for o in order:
    weight=500
    check=True
    for i in o:
        weight+=kit[i]
        weight-=k
        if weight<500:
            check=False
            break
    if check:
        result+=1
print(result)
