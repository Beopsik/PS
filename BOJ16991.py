from math import sqrt
from sys import stdin        

n=int(stdin.readline())
graph=[[] for i in range(n)]
dp=[[1000000000]*(1<<n) for i in range(n)]

temp=[]
for i in range(n):
    temp.append(list(map(int, stdin.readline().split())))
for i in range(n):
    for j in range(i+1, n):
        distance=sqrt(pow(temp[i][0]-temp[j][0], 2)+pow(temp[i][1]-temp[j][1], 2))
        graph[i].append(distance)
        graph[j].append(distance)
    graph[i].insert(i, 0)
def dfs(city, visited):
    # print(city, visited)
    if dp[city][visited]!=1000000000:
        return dp[city][visited]
    if visited==(1<<n)-1:
        if graph[city][0]:
            return graph[city][0]
        else:
            return -1
    
    ret=[]
    for nextCity in range(1, n):
        if not graph[city][nextCity]:
            continue
        if visited&(1<<nextCity):
            continue
        cost=dfs(nextCity, visited|(1<<nextCity))
        if cost==-1:
            continue
        ret.append(cost+graph[city][nextCity])
    if len(ret)==0:
        dp[city][visited]=-1
        return -1
    ret.sort()
    dp[city][visited]=ret[0]
    return dp[city][visited]
print(dfs(0, 1))
