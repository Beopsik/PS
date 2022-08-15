from sys import stdin        

sudoku=[]
candidateNum=["1", "2", "3", "4", "5", "6", "7", "8", "9"]
coordi=[]

def removeCandidateNum(y, x):
    result=candidateNum[:]
    posY=(y//3)*3
    posX=(x//3)*3
    for i in range(9):
        if sudoku[y][i] in result:
            result.remove(sudoku[y][i])
        if sudoku[i][x] in result:
            result.remove(sudoku[i][x])
    for i in range(3):
        for j in range(3):
            if sudoku[posY+i][posX+j] in result:
                result.remove(sudoku[posY+i][posX+j])
    return result

for i in range(9):
    sudoku.append(list(stdin.readline().rstrip()))
    for j in range(9):
        if sudoku[i][j]=='0':
            coordi.append((i, j))
        
def backtraking(i):
    if len(coordi)==i:
        for line in sudoku:
            print("".join(line))
        exit(0)
    y=coordi[i][0]
    x=coordi[i][1]
    c=removeCandidateNum(y, x)
    for strNum in c:
        sudoku[y][x]=strNum
        backtraking(i+1)
    sudoku[y][x]="0"

backtraking(0)
