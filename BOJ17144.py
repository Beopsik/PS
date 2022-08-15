from copy import deepcopy
import math
from sys import stdin        

n, m, k=map(int, stdin.readline().split())
room=[]
dy=[1, 0, -1, 0]
dx=[0, 1, 0, -1]
counterClock=[(0, 1), (-1, 0), (0, -1), (1, 0)]
clock=[(0, 1), (1, 0), (0, -1), (-1, 0)]
airCleaner=[]
for i in range(n):
    room.append(list(map(int, stdin.readline().split())))
    if room[i][0]==-1:
        airCleaner.append(i)
airCleaner.sort()

def spread():
    global room
    newRoom=[[0 for i in range(m)] for j in range(n)]
    newRoom[airCleaner[0]][0]=-1
    newRoom[airCleaner[1]][0]=-1

    for i in range(n*m):
        y=i//m
        x=i%m
        if room[y][x]>0:
            temp=room[y][x]
            for i in range(4):
                nextY=y+dy[i]
                nextX=x+dx[i]
                if nextY>=0 and nextY<n and nextX>=0 and nextX<m and room[nextY][nextX]!=-1:
                    newRoom[nextY][nextX]+=math.trunc(room[y][x]/5)
                    temp-=math.trunc(room[y][x]/5)
            newRoom[y][x]+=temp
    room=newRoom

def clean():
    global room
    newRoom=[[0 for i in range(m)] for j in range(n)]
    newRoom[airCleaner[0]][0]=-1
    newRoom[airCleaner[1]][0]=-1

    for i in range(1, n-1):
        if i == airCleaner[0] or i== airCleaner[1]:
            continue
        for j in range(1, m-1):
            newRoom[i][j]=room[i][j]

    y=airCleaner[0]
    x=1
    for dir in counterClock:
        while y+dir[0]>=0 and y+dir[0]<n and x+dir[1]>=0 and x+dir[1]<m:
            if y+dir[0]==airCleaner[0] and x+dir[1]==0:
                break
            newRoom[y+dir[0]][x+dir[1]]=room[y][x]
            y+=dir[0]
            x+=dir[1]

    y=airCleaner[1]
    x=1
    for dir in clock:
        while y+dir[0]>=0 and y+dir[0]<n and x+dir[1]>=0 and x+dir[1]<m:
            if y+dir[0]==airCleaner[1] and x+dir[1]==0:
                break
            newRoom[y+dir[0]][x+dir[1]]=room[y][x]
            y+=dir[0]
            x+=dir[1]
    room=newRoom

for i in range(k):
    spread()
    clean()

result=2
for line in room:
    result+=sum(line)
print(result)
# spread()
# for line in room:
#     print(*line)
# print()
