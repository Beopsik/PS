from sys import stdin

computer=int(stdin.readline())
edge=int(stdin.readline())

graph=[[] for i in range(computer+1)]
for i in range(edge):
    v1, v2=map(int, stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

check=[False for i in range(computer+1)]
check[0]=True
def bfs():
    queue=[]
    queue.append(1)
    check[1]=True
    while len(queue)!=0:
        curV=queue[0]
        queue.pop(0)
        for nextV in graph[curV]:
            if not check[nextV]:
                check[nextV]=True
                queue.append(nextV)
bfs()
print((computer-1)-check.count(False))

