from lib2to3.pgen2.token import OP
from queue import PriorityQueue
from sys import stdin        

n, m=map(int, stdin.readline().split())
dir=[(1, 0), (0, 1), (-1, 0), (0, -1)]
board=[]
rPos=[]
bPos=[]
oPos=[]
for i in range(n):
    board.append(list(stdin.readline().rstrip()))
    if "R" in board[i]:
        rPos.append(i)
        rPos.append(board[i].index("R"))
    if "B" in board[i]:
        bPos.append(i)
        bPos.append(board[i].index("B"))
    if "O" in board[i]:
        oPos.append(i)
        oPos.append(board[i].index("O"))

class Pos:
    def __init__(self, rY, rX, bY, bX, count):
        self.rY=rY
        self.rX=rX
        self.bY=bY
        self.bX=bX
        self.count=count
    def __lt__(self, other):
        return self.count<other.count
    def __str__(self):
        return "rPos: "+str(self.rY)+", "+str(self.rX)+" bPos: "+str(self.bY)+", "+str(self.bX)+" Count: "+str(self.count)

def move(curPos, dirIdx):
    order=[]
    if dirIdx==0 and curPos.rX==curPos.bX:
        if curPos.rY>curPos.bY:
            order.append("R")
            order.append("B")
        else:
            order.append("B")
            order.append("R")
    elif dirIdx==1 and curPos.rY==curPos.bY:
        if curPos.rX>curPos.bX:
            order.append("R")
            order.append("B")
        else:
            order.append("B")
            order.append("R")
    elif dirIdx==2 and curPos.rX==curPos.bX:
        if curPos.rY>curPos.bY:
            order.append("B")
            order.append("R")
        else:
            order.append("R")
            order.append("B")
    elif dirIdx==3 and curPos.rY==curPos.bY:
        if curPos.rX>curPos.bX:
            order.append("B")
            order.append("R")
        else:
            order.append("R")
            order.append("B")
    else:
        order.append("R")
        order.append("B")

    if order[0]=="R":
        curRY=curPos.rY
        curRX=curPos.rX
        while True:
            nextRY=curRY+dir[dirIdx][0]
            nextRX=curRX+dir[dirIdx][1]
            if nextRY>=0 and nextRY<n and nextRX>=0 and nextRX<m:
                if board[nextRY][nextRX]=="O":
                    curRY=nextRY
                    curRX=nextRX
                    break
                elif board[nextRY][nextRX]=="#":
                    break
                else:
                    curRY=nextRY
                    curRX=nextRX
            else:
                break
        curBY=curPos.bY
        curBX=curPos.bX
        while True:
            nextBY=curBY+dir[dirIdx][0]
            nextBX=curBX+dir[dirIdx][1]
            if nextBY>=0 and nextBY<n and nextBX>=0 and nextBX<m:
                if nextBY==curRY and nextBX==curRX:
                    if board[nextBY][nextBX]=="O":
                        curBY=nextBY
                        curBX=nextBX
                    break

                if board[nextBY][nextBX]=="O":
                    curBY=nextBY
                    curBX=nextBX
                    break
                elif board[nextBY][nextBX]=="#":
                    break
                else:
                    curBY=nextBY
                    curBX=nextBX
            else:
                break
    else:
        curBY=curPos.bY
        curBX=curPos.bX
        while True:
            nextBY=curBY+dir[dirIdx][0]
            nextBX=curBX+dir[dirIdx][1]
            if nextBY>=0 and nextBY<n and nextBX>=0 and nextBX<m:
                if board[nextBY][nextBX]=="O":
                    curBY=nextBY
                    curBX=nextBX
                    break
                elif board[nextBY][nextBX]=="#":
                    break
                else:
                    curBY=nextBY
                    curBX=nextBX
            else:
                break
        curRY=curPos.rY
        curRX=curPos.rX
        while True:
            nextRY=curRY+dir[dirIdx][0]
            nextRX=curRX+dir[dirIdx][1]
            if nextRY>=0 and nextRY<n and nextRX>=0 and nextRX<m:
                if nextRY==curBY and nextRX==curBX:
                    if board[nextRY][nextRX]=="O":
                        curRY=nextRY
                        curRX=nextRX
                    break

                if board[nextRY][nextRX]=="O":
                    curRY=nextRY
                    curRX=nextRX
                    break
                elif board[nextRY][nextRX]=="#":
                    break
                else:
                    curRY=nextRY
                    curRX=nextRX
            else:
                break
    return Pos(curRY, curRX, curBY, curBX, curPos.count+1)
    
def bfs():
    q=PriorityQueue()

    q.put(Pos(rPos[0], rPos[1], bPos[0], bPos[1], 0))

    while not q.empty():
        curPos=q.get()
        # print(curPos)
        if curPos.rY==oPos[0] and curPos.rX==oPos[1]:
            if curPos.bY!=oPos[0] or curPos.bX!=oPos[1]:
                print(curPos.count)
                exit(0)
            else:
                continue
        for i in range(4):
            nextPos=move(curPos, i)
            if (curPos.rY!=nextPos.rY or curPos.rX!=nextPos.rX or curPos.bY!=nextPos.bY or curPos.bX!=nextPos.bX) and nextPos.count<=10 and (nextPos.bY!=oPos[0] or nextPos.bX!=oPos[1]):
                q.put(nextPos)

bfs()
print(-1)
# nextPos=move(Pos(rPos[0], rPos[1], bPos[0], bPos[1], 0), 3)
# print(move(nextPos, 0))
