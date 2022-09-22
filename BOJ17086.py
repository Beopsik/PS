import itertools
from queue import Queue
from sys import stdin

dy=[1, 1, 0, -1, -1, -1, 0, 1]
dx=[0, 1, 1, 1, 0, -1, -1, -1]
n, m=map(int, stdin.readline().split())
board=[]
for i in range(n):
    board.append(list(map(int, stdin.readline().split())))

def bfs(y, x):
    q=Queue()
    q.put((y, x, 0))
    result[y][x]=0

    while not q.empty():
        cur=q.get()

        for i in range(8):
            nextY=cur[0]+dy[i]
            nextX=cur[1]+dx[i]
            nextCount=cur[2]+1
            if nextY>=0 and nextY<n and nextX>=0 and nextX<m and result[nextY][nextX]>nextCount:
                q.put((nextY, nextX, nextCount))
                result[nextY][nextX]=nextCount

result=[[1000000000 for  j in range(m)] for i in range(n)]
for i in range(n):
    for j in range(m):
        if board[i][j]==1:
            bfs(i, j)

# print()
# for r in result:
#     print(*r)

Max=0
for r in result:
    Max=max(Max, max(r))
print(Max)
