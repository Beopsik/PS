from sys import stdin
import sys
limit_number = 15000
sys.setrecursionlimit(limit_number)

n, m = map(int, stdin.readline().split())

graph=[[] for i in range(n+1)]
for i in range(m):
    v1, v2 = map(int, stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

check=[False for i in range(n+1)]
def dfs(graph, v):
    check[v]=True

    for i in graph[v]:
        if not check[i]:
            dfs(graph, i)

count=0
for i in range(1, n+1):
    if not check[i]:
        count+=1
        dfs(graph, i)
print(count)
