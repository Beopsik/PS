board=[]
for i in range(0, 5):
    line=list(map(int, input().split()))
    board.append(line)

call=[]
for i in range(0, 5):
    line=list(map(int, input().split()))
    call+=line

def checkBingo():
    result=0

    diagonal=0
    for i in range(0, 5):
        diagonal+=board[i][i]
    if diagonal==0:
        result+=1

    diagonal=0
    for i in range(0, 5):
        diagonal+=board[i][4-i]
    if diagonal==0:
        result+=1
    
    for list in board:
        if sum(list)==0:
            result+=1

    for i in range(0, 5):
        col=0
        for j in range(0, 5):
            col+=board[j][i]
        if col==0:
            result+=1
    
    return result

for num in call:
    for searchList in board:
        if num in searchList:
            searchList[searchList.index(num)]=0
            if checkBingo()>=3:
                print(call.index(num)+1)
                exit()
    

