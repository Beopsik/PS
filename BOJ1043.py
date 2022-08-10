from collections import deque
from sys import stdin        

n, m=map(int, stdin.readline().split())
fact=list(map(int, stdin.readline().split()))
fact=deque(fact[1:]) 
check=[False for i in range(n+1)]
people=[[] for i in range(n+1)]
party=[[] for i in range(m+1)]
for i in range(1, m+1):
    temp=list(map(int, stdin.readline().split()))
    temp=temp[1:]
    party[i]=temp
    for p in temp:
        people[p].append(i)

while len(fact)!=0:
    f=fact.popleft()
    for pt in people[f]:
        for p in party[pt]:
            fact.append(p)
        party[pt].clear()

print(len(party)-party.count([]))
