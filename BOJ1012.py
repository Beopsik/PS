from sys import stdin
import sys
sys.setrecursionlimit(10**6)

T=int(stdin.readline())

dy=[1, 0, -1, 0]
dx=[0, 1, 0, -1]
def dfs(cabage, y, x):
    cabage[y][x]=0

    for i in range(4):
        if y+dy[i]>=0 and y+dy[i]<n and x+dx[i]>=0 and x+dx[i]<m:
            if cabage[y+dy[i]][x+dx[i]]==1:
                dfs(cabage, y+dy[i], x+dx[i])

for test in range(T):
    m, n, k = map(int, stdin.readline().split())
    
    cabbage=[[0 for i in range(m)] for j in range(n)]
    for i in range(k):
        x, y=map(int, stdin.readline().split())
        cabbage[y][x]=1
    
    count=0
    for i in range(n):
        for j in range(m):
            if cabbage[i][j]==1:
                count+=1
                dfs(cabbage, i, j)
    print(count)
