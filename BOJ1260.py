from sys import stdin

n, m, v = map(int, stdin.readline().split())

graph=[[] for i in range(n+1)]
for i in range(m):
    v1, v2=map(int, stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

for i in graph:
    i.sort()

check=[False for i in range(n+1)]
result=[]
def dfs(v):
    check[v]=True
    result.append(v)
    for nextV in graph[v]:
        if not check[nextV]:
            dfs(nextV)
dfs(v)
print(*result)

check=[False for i in range(n+1)]
queue=[]
result=[]
def bfs(v):
    check[v]=True
    queue.append(v)

    while len(queue)!=0:
        curV=queue.pop(0)
        result.append(curV)
        for nextV in graph[curV]:
            if not check[nextV]:
                check[nextV]=True
                queue.append(nextV)
bfs(v)
print(*result)


