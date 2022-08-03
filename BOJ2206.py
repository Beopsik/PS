from collections import deque
from queue import Queue
from sys import stdin        

dy=[1, 0, 0, -1]
dx=[0, 1, -1, 0]
n, m=map(int, stdin.readline().split())
board=[stdin.readline().rstrip() for i in range(n)]

minPath=[[[0]*2 for i in range(m)] for j in range(n)]
minPath[0][0][0]=1

def bfs():
    q=deque()
    q.append((0, 0, 0))

    while q:
        curY, curX, destroy=q.popleft()

        if curY+1==n and curX+1==m:
            return minPath[curY][curX][destroy]

        for i in range(4):
            nextY=curY+dy[i]
            nextX=curX+dx[i]
            if nextY>=0 and nextY<n and nextX>=0 and nextX<m:
                if board[nextY][nextX]=="1" and destroy==0:
                    minPath[nextY][nextX][1]=minPath[curY][curX][0]+1
                    q.append((nextY, nextX, 1))
                elif board[nextY][nextX]=="0" and minPath[nextY][nextX][destroy]==0:
                    minPath[nextY][nextX][destroy]=minPath[curY][curX][destroy]+1
                    q.append((nextY, nextX, destroy))
    return -1
print(bfs())
# for e in minPath:
#     print(e)
                
