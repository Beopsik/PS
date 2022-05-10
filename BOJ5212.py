from string import whitespace
from sys import stdin


r, c=map(int, stdin.readline().split())
currentMap=[]
for i in range(r):
    currentMap.append(stdin.readline().rstrip())

futureMap=currentMap.copy()
dY=[-1, 0, 1, 0]
dX=[0, 1, 0, -1]
for y in range(r):
    for x in range(c):
        if currentMap[y][x]=='X':
            count=0
            for i in range(4):
                if y+dY[i]>=r or y+dY[i]<0 or x+dX[i]>=c or x+dX[i]<0:
                    count+=1
                else:
                    if currentMap[y+dY[i]][x+dX[i]]=='.':
                        count+=1
            if count>=3:
                temp=list(futureMap[y])
                temp[x]="."
                futureMap[y]="".join(temp)

top=-1
bottom=-1
left=c
right=-1
for y in range(r):
    if "X" in futureMap[y]:
        if top==-1:
            top=y
        left=min(left ,futureMap[y].find('X'))
        right=max(right, futureMap[y].rfind('X'))
for y in range(r-1, -1, -1):
    if "X" in futureMap[y]:
        bottom=y
        break

result=[]
for i in range(top, bottom+1):
    result.append(futureMap[i][left:right+1])
for line in result:
    print(line)



