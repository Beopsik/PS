from sys import stdin        
import itertools

n, m=map(int, stdin.readline().split())
numList = [i for i in range(1, n+1)]
result=list(itertools.combinations_with_replacement(numList, m))
result.sort()
for e in result:
    print(*e)
