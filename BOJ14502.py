from collections import deque
from copy import deepcopy
from sys import stdin        

n, m=map(int, stdin.readline().split())
lab=[]
zeroCount=0
for i in range(n):
    lab.append(list(map(int, stdin.readline().split())))
    zeroCount+=lab[i].count(0)

dy=[1, 0, -1, 0]
dx=[0, 1, 0, -1]
def safeArea(lab, virus):

    virusCount=0
    for i in range(n*m):
        y=i//m
        x=i%m
        if lab[y][x]==2 and i not in virus:
            q=deque()

            q.append((y, x))
            virus.add(i)
            while len(q)!=0:
                cur=q.popleft()
                for j in range(4):
                    nextY=cur[0]+dy[j]
                    nextX=cur[1]+dx[j]
                    if nextY>=0 and nextY<n and nextX>=0 and nextX<m and lab[nextY][nextX]==0:
                        lab[nextY][nextX]=2
                        q.append((nextY, nextX))
                        virusCount+=1
    return virusCount

result=0
for i in range(n*m):
    for j in range(i, n*m):
        for k in range(j, n*m):
            if i==j or j==k or i==k:
                continue
            y1=i//m
            x1=i%m
            y2=j//m
            x2=j%m
            y3=k//m
            x3=k%m
            if lab[y1][x1]==0 and lab[y2][x2]==0 and lab[y3][x3]==0:
                lab[y1][x1]=1
                lab[y2][x2]=1
                lab[y3][x3]=1
                
                result=max(result, zeroCount-safeArea(deepcopy(lab), set())-3)
                
                lab[y1][x1]=0
                lab[y2][x2]=0
                lab[y3][x3]=0

print(result)
