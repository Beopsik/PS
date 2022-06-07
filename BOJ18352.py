from sys import stdin

n, m, k, x=map(int, stdin.readline().split())
check=[False for i in range(n+1)]
graph=[[] for i in range(n+1)]
for i in range(m):
    v1, v2=map(int, stdin.readline().split())
    graph[v1].append(v2)

result=[]
def bfs(city):
    check[city]=True
    queue=[[city, 0]]

    while len(queue)!=0:
        cur=queue.pop(0)
        curCity=cur[0]
        curDistance=cur[1]

        if curDistance>k:
            break
        
        if curDistance==k:
            result.append(curCity)

        for next in graph[curCity]:
            if not check[next]:
                check[next]=True
                queue.append([next, curDistance+1])

bfs(x)

if len(result)==0:
    print(-1)
else:
    result.sort()
    for i in result:
        print(i)
