from sys import stdin
import copy
n = int(stdin.readline())

def checkLen(board:list, n):
    c="C"*n
    p="P"*n
    z="Z"*n
    y="Y"*n
    reverse_board=list(map(list, zip(*board)))

    i=n
    while i>=1:
        for j in range(n):
            temp1="".join(board[j])
            temp2="".join(reverse_board[j])
            if c in temp1 or p in temp1 or z in temp1 or y in temp1 or c in temp2 or p in temp2 or z in temp2 or y in temp2:
                return i
        c=c[:-1]
        p=p[:-1]
        z=z[:-1]
        y=y[:-1]
        i-=1    

board=[]
for i in range(n):
    temp = str(stdin.readline())
    temp=temp[:-1]
    board.append(list(temp))
reverse_board=list(map(list, zip(*board)))

Max=0
Max=max(Max, checkLen(board, n))
for i in range(n):
    for j in range(n):
        if j+1<n and board[i][j]!=board[i][j+1]:
            temp=board[i][j]
            board[i][j]=board[i][j+1]
            board[i][j+1]=temp
            Max=max(Max, checkLen(board, n))
            temp=board[i][j]
            board[i][j]=board[i][j+1]
            board[i][j+1]=temp

        if i+1<n and board[i][j]!=board[i+1][j]:
            temp=board[i][j]
            board[i][j]=board[i+1][j]
            board[i+1][j]=temp
            Max=max(Max, checkLen(board, n))
            temp=board[i][j]
            board[i][j]=board[i+1][j]
            board[i+1][j]=temp        
print(Max)
