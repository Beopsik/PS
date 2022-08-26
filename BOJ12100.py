from copy import deepcopy
from itertools import product
from sys import stdin        

n=int(stdin.readline())
board=[]
for i in range(n):
    board.append(list(map(int, stdin.readline().split())))

def move(dir, board):
    if dir==0:
        for j in range(n):
            ptr1=0
            ptr2=0
            idx=0
            while ptr1<n and ptr2<n:
                while ptr1<n:
                    if board[ptr1][j]!=0:
                        break
                    ptr1+=1
                if ptr1>=n:
                    break

                ptr2=ptr1+1
                while ptr2<n:
                    if board[ptr2][j]!=0:
                        break
                    ptr2+=1
                if ptr2>=n:
                    temp=board[ptr1][j]
                    board[ptr1][j]=0
                    board[idx][j]=temp
                    break

                if board[ptr1][j]==board[ptr2][j]:
                    temp=board[ptr1][j]
                    board[ptr1][j]=0
                    board[ptr2][j]=0
                    board[idx][j]=temp*2
                    idx+=1
                    ptr1=ptr2+1
                else:
                    temp=board[ptr1][j]
                    board[ptr1][j]=0
                    board[idx][j]=temp
                    idx+=1

                    temp=board[ptr2][j]
                    board[ptr2][j]=0
                    board[idx][j]=temp
                    ptr1=idx
    elif dir==1:
        for i in range(n):
            ptr1=n-1
            ptr2=n-1
            idx=n-1
            while ptr1>=0 and ptr2>=0:
                while ptr1>=0:
                    if board[i][ptr1]!=0:
                        break
                    ptr1-=1
                if ptr1<0:
                    break

                ptr2=ptr1-1
                while ptr2>=0:
                    if board[i][ptr2]!=0:
                        break
                    ptr2-=1
                if ptr2<0:
                    temp=board[i][ptr1]
                    board[i][ptr1]=0
                    board[i][idx]=temp
                    break

                if board[i][ptr1]==board[i][ptr2]:
                    temp=board[i][ptr1]
                    board[i][ptr1]=0
                    board[i][ptr2]=0
                    board[i][idx]=temp*2
                    idx-=1
                    ptr1=ptr2-1
                else:
                    temp=board[i][ptr1]
                    board[i][ptr1]=0
                    board[i][idx]=temp
                    idx-=1

                    temp=board[i][ptr2]
                    board[i][ptr2]=0
                    board[i][idx]=temp
                    ptr1=idx
    elif dir==2:
        for j in range(n):
            ptr1=n-1
            ptr2=n-1
            idx=n-1
            while ptr1>=0 and ptr2>=0:
                while ptr1>=0:
                    if board[ptr1][j]!=0:
                        break
                    ptr1-=1
                if ptr1<0:
                    break

                ptr2=ptr1-1
                while ptr2>0:
                    if board[ptr2][j]!=0:
                        break
                    ptr2-=1
                if ptr2<0:
                    temp=board[ptr1][j]
                    board[ptr1][j]=0
                    board[idx][j]=temp
                    break

                if board[ptr1][j]==board[ptr2][j]:
                    temp=board[ptr1][j]
                    board[ptr1][j]=0
                    board[ptr2][j]=0
                    board[idx][j]=temp*2
                    idx-=1
                    ptr1=ptr2-1
                else:
                    temp=board[ptr1][j]
                    board[ptr1][j]=0
                    board[idx][j]=temp
                    idx-=1

                    temp=board[ptr2][j]
                    board[ptr2][j]=0
                    board[idx][j]=temp
                    ptr1=idx
    elif dir==3:
        for i in range(n):
            ptr1=0
            ptr2=0
            idx=0
            while ptr1<n and ptr2<n:
                while ptr1<n:
                    if board[i][ptr1]!=0:
                        break
                    ptr1+=1
                if ptr1>=n:
                    break

                ptr2=ptr1+1
                while ptr2<n:
                    if board[i][ptr2]!=0:
                        break
                    ptr2+=1
                if ptr2>=n:
                    temp=board[i][ptr1]
                    board[i][ptr1]=0
                    board[i][idx]=temp
                    break

                if board[i][ptr1]==board[i][ptr2]:
                    temp=board[i][ptr1]
                    board[i][ptr1]=0
                    board[i][ptr2]=0
                    board[i][idx]=temp*2
                    idx+=1
                    ptr1=ptr2+1
                else:
                    temp=board[i][ptr1]
                    board[i][ptr1]=0
                    board[i][idx]=temp
                    idx+=1

                    temp=board[i][ptr2]
                    board[i][ptr2]=0
                    board[i][idx]=temp
                    ptr1=idx
    return board

Max=0
for dirOrder in product([0, 1, 2, 3], repeat=5):
    # print(dirOrder)
    tempBoard=deepcopy(board)
    for dir in dirOrder:
        tempBoard=move(dir, tempBoard)
        for line in tempBoard:
            Max=max(Max, max(line))
        # for line in result:
        #     print(*line)
        # print()
# print()
# result=move(1, deepcopy(board))
# for line in result:
#     print(*line)
# print()

print(Max)
