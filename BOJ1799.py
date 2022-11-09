from sys import stdin
from collections import deque
input=stdin.readline 

n=int(input())
white=deque()
black=deque()

board=[[0 for _ in range(n)] for _ in range(n)]
for i in range(n):
    for j in range(n):
        if (i+j)%2==0:
            board[i][j]=1

for i in range(n):
    temp=list(input().split())
    for j in range(n):
        if temp[j]=="1":
            if board[i][j]==1:
                white.append((i,j))
            else:
                black.append((i,j))

def backtracking(color, idx):
    global Max
    global bishop
    if idx>=len(color):
        Max=max(Max, len(bishop))
        return
    
    for i in range(idx, len(color)):
        check=True
        for b in bishop:
            if abs(color[i][0]-b[0])==abs(color[i][1]-b[1]):
                check=False
                break
        if check:
            bishop.append(color[i])
            backtracking(color, i+1)
            bishop.pop()

result=0

Max=0
bishop=deque()
backtracking(white, 0)
result+=Max
Max=0
bishop=deque()
backtracking(black, 0)
result+=Max

print(result)
