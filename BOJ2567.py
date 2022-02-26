board1=[[str(0) for i in range(101)] for j in range(101)]
board2=[[str(0) for i in range(101)] for j in range(101)]

def fill(x: int, y: int):
    global board1
    global board2

    for i in range(x, x+10):
        for j in range(y, y+10):
            board1[j][i]=str(1)
            board2[i][j]=str(1)

num=int(input())

for i in range(num):
    x, y=input().split()
    x=int(x)
    y=int(y)
    fill(x, y)

circum=0
for i in range(100):
    str1="".join(board1[i])
    str2="".join(board1[i+1])
    tempList=[ord(a)^ord(b) for a, b in zip(str1, str2)]
    circum+=sum(tempList)

for i in range(100):
    str1="".join(board2[i])
    str2="".join(board2[i+1])
    tempList=[ord(a)^ord(b) for a, b in zip(str1, str2)]
    circum+=sum(tempList)
print(circum)
