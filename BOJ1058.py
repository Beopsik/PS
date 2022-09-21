import itertools
from queue import Queue
from sys import stdin

Max=0
n=int(stdin.readline())
graph=[[] for i in range(n)]
for i in range(n):
    relation=stdin.readline().rstrip()
    for j in range(n):
        if relation[j]=='Y':
            graph[i].append(j)

def bfs(i):
    count=0

    q=Queue()
    q.put((i, 0))
    check[i]=True

    while not q.empty():
        cur=q.get()
        # print(cur)
        for next in graph[cur[0]]:
            if not check[next] and cur[1]<2:
                check[next]=True
                q.put((next, cur[1]+1))
                count+=1
    
    return count

for i in range(n):
    check=[False for _ in range(n)]
    Max=max(Max, bfs(i))
print(Max)
