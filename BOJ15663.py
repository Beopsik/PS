from sys import stdin        
import itertools

n, m=map(int, stdin.readline().split())
numList = list(map(int, stdin.readline().split()))
numList.sort()
result=list(set(itertools.permutations(numList, m)))
result.sort()
for e in result:
    print(*e)
