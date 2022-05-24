from sys import stdin
import sys
limit_number = 15000
sys.setrecursionlimit(limit_number)

dY=[1, 0, -1, 0, -1, 1, 1, -1]
dX=[0, 1, 0, -1, 1, 1, -1, -1]
def dfs(Map, y, x):
    Map[y][x]=0

    for i in range(8):
        if y+dY[i]<h and y+dY[i]>=0 and x+dX[i]<w and x+dX[i]>=0:
            if Map[y+dY[i]][x+dX[i]]==1:
                dfs(Map, y+dY[i], x+dX[i])

result=[]
while True:
    w, h = map(int, stdin.readline().split())
    if w==0 and h==0:
        break
    Map=[]
    for i in range(h):
        Map.append(list(map(int, stdin.readline().split())))
    
    land=0
    for i in range(h):
        for j in range(w):
            if Map[i][j]==1:
                land+=1
                dfs(Map, i, j)
    print(land)
    

