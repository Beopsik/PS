from sys import stdin
from tabnanny import check

dy=[1, 0, -1, 0]
dx=[0, 1, 0, -1]
board=[]
for i in range(5):
    board.append(list(stdin.readline().split()))

def dfs(y, x, num):
    if len(num)>=6:
        result.add("".join(num))
        return

    for i in range(4):
        nextY=y+dy[i]
        nextX=x+dx[i]
        if nextY>=0 and nextY<5 and nextX>=0 and nextX<5:
            num.append(board[nextY][nextX])
            dfs(nextY, nextX, num)
            del num[-1]

result=set()
for i in range(5):
    for j in range(5):
        dfs(i, j, [])

print(len(result))






