from queue import PriorityQueue
from sys import stdin        

class Node:
    def __init__(self, num, count):
        self.num=num
        self.count=count
    def __lt__(self, other):
        if self.count==other.count:
            return self.num<other.num
        else:
            return self.count<other.count

n, m=map(int, stdin.readline().split())
root=[[] for i in range(n+1)]
belong=[[] for i in range(n+1)]

for i in range(m):
    a, b=map(int, stdin.readline().split())
    root[b].append(a)
    belong[a].append(b)
for i in range(n):
    root[i].sort()
    belong[i].sort()

check=[False for i in range(n+1)]
result=[]
def bfs():
    q=PriorityQueue()

    for i in range(1, n+1):
        if len(root[i])==0:
            q.put(Node(i, 0))

    while not q.empty():
        cur=q.get()
        if not check[cur.num]:
            check[cur.num]=True
            result.append(cur.num)
            for next in belong[cur.num]:
                if not check[next]:
                    root[next].remove(cur.num)
                    q.put(Node(next, len(root[next])))

bfs()
print(*result)
