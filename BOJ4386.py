from math import sqrt
from sys import stdin

n = int(stdin.readline())
star=[]
for i in range(n):
    x, y=map(float, stdin.readline().split())
    star.append((y, x))
starIdx={}
i=0
for s in star:
    starIdx[s]=i
    i+=1

graph=[]
for i in range(n):
    s1=star[i]
    for j in range(i+1, n):
        s2=star[j]
        cost=sqrt(pow(s1[0]-s2[0], 2)+pow(s1[1]-s2[1], 2))
        graph.append((cost, s1, s2))
graph.sort()
# print(graph)
i=0
result=0
e=len(graph)
if n>=3:
    e=(n*(n-3))//2+n
checkRoot=[i for i in range(n+1)]
belongRoot=[[i] for i in range(n+1)]
mstSet=set()
while True:
    if i==e or len(mstSet)+1==n:
        break

    cost=graph[i][0]
    s1=graph[i][1]
    s2=graph[i][2]
    if checkRoot[starIdx[s1]]!=checkRoot[starIdx[s2]]:
        result+=cost
        s1Root=checkRoot[starIdx[s1]]
        s2Root=checkRoot[starIdx[s2]]
        if s1Root>s2Root:
            temp=s1Root
            s1Root=s2Root
            s2Root=temp
        
        for s in belongRoot[s2Root]:
            checkRoot[s]=s1Root
            belongRoot[s1Root].append(s)
        belongRoot[s2Root]=[]
        mstSet.add((cost, s1, s2))
    i+=1
print(result)
