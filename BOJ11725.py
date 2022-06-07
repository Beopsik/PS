from sys import stdin
import sys
limit_number = 1000000
sys.setrecursionlimit(limit_number)

n=int(stdin.readline())
tree=[[] for i in range (n+1)]
for i in range(n-1):
    v1, v2=map(int, stdin.readline().split())
    tree[v1].append(v2)
    tree[v2].append(v1)

parent=[0 for i in range(n+1)]
check=[False for i in range(n+1)]
def dfs(node):
    check[node]=True
    for next in tree[node]:
        if not check[next]:
            parent[next]=node
            dfs(next)

dfs(1)
for i in range(2, n+1):
    print(parent[i])
