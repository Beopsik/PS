from os import curdir
from sys import stdin
from tabnanny import check

n, m=map(int, stdin.readline().split())
check=[[False for j in range(m)] for i in range(n)]
board=[]
for i in range(n):
    board.append(list(stdin.readline().rstrip()))
# print(board)
dir={"D":(1, 0), "R":(0, 1), "U":(-1, 0), "L":(0, -1)}
def dfs(rootY, rootX, y, x):

    check[y][x]=True
    curdir=dir[board[y][x]]
    nextY=y+curdir[0]
    nextX=x+curdir[1]
    if not check[nextY][nextX]:
        checkRoot[(nextY, nextX)]=(rootY, rootX)
        belongRoot[(rootY, rootX)].append((nextY, nextX))
        dfs(rootY, rootX, nextY, nextX)
    else:
        nextRoot=checkRoot[(nextY, nextX)]
        if checkRoot[(rootY, rootX)]!=checkRoot[nextRoot]:
            if (rootY, rootX)>nextRoot:
                temp=nextRoot
                nextRoot=(rootY, rootX)
                rootY=temp[0]
                rootX=temp[1]
            for e in belongRoot[nextRoot]:
                checkRoot[e]=(rootY, rootX)
                belongRoot[(rootY, rootX)].append(e)
            del belongRoot[nextRoot]

result=0
checkRoot={}
belongRoot={}
for i in range(n):
    for j in range(m):
        if not check[i][j]:
            checkRoot[(i, j)]=(i, j)
            belongRoot[(i, j)]=[(i, j)]
            dfs(i, j, i, j)
            # for c in check:
            #     print(c)
            # print()
# for k in belongRoot.keys():
#     print(belongRoot[k])
# print()
print(len(belongRoot))
    
