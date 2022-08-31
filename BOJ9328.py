from copy import deepcopy
from queue import Queue
from sys import stdin        
import re

dirY=[1, 0, -1, 0]
dirX=[0, 1, 0, -1]

T=int(stdin.readline())
result=[]
count=0

def bfs(y, x):
    global count
    q=Queue()
    check[y][x]=True
    if board[y][x]==".":
        q.put((y, x))
    elif board[y][x]=="$":
        q.put((y, x))
        count+=1
        board[y][x]="."
    elif re.match('[A-Z]', board[y][x]):
        if board[y][x].lower() in keySet:
            q.put((y, x))
            board[y][x]="."
    else:
        q.put((y, x))
        keySet.add(board[y][x])                            
        board[y][x]="."

    while not q.empty():
        cur=q.get()
        for i in range(4):
            nextY=cur[0]+dirY[i]
            nextX=cur[1]+dirX[i]
            if nextY>=0 and nextY<h and nextX>=0 and nextX<w:
                if not check[nextY][nextX] and board[nextY][nextX]!="*":
                    check[nextY][nextX]=True
                    if board[nextY][nextX]==".":
                        q.put((nextY, nextX))
                    elif board[nextY][nextX]=="$":
                        q.put((nextY, nextX))
                        count+=1
                        board[nextY][nextX]="."
                    elif re.match('[A-Z]', board[nextY][nextX]):
                        if board[nextY][nextX].lower() in keySet:
                            q.put((nextY, nextX))
                            board[nextY][nextX]="."
                    else:
                        q.put((nextY, nextX))
                        keySet.add(board[nextY][nextX])                            
                        board[nextY][nextX]="."

                

for t in range(T):
    count=0
    h, w=map(int, stdin.readline().split())
    board=[]
    for i in range(h):
        board.append(list(stdin.readline().rstrip()))
    key=list(stdin.readline().rstrip())
    keySet=set()
    if key!=0:
        for k in key:
            keySet.add(k)
    
    while True:
        temp=deepcopy(board)
        for i in range(h):
            for k in keySet:
                kDoor=k.upper()
                kCount=board[i].count(kDoor)
                for j in range(kCount):
                    board[i][board[i].index(kDoor)]="."
        
        check=[[False for i in range(w)] for j in range(h)]
        for i in range(h):
            if i==0 or i==h-1:
                for j in range(w):
                    if not check[i][j] and board[i][j]!="*":
                        bfs(i, j)
            else:
                if not check[i][0] and board[i][0]!="*":
                    bfs(i, 0)
                if not check[i][w-1] and board[i][w-1]!="*":
                    bfs(i, w-1)
        
        # print()
        # print("+++++++++++++++++++++++++++++++++++++++++++++++++++")
        # for line in board:
        #     print("".join(line))
        # print("+++++++++++++++++++++++++++++++++++++++++++++++++++")
        # print(keySet)
        if temp==board:
            break
    result.append(str(count))
result="\n".join(result)
print(result)
    
