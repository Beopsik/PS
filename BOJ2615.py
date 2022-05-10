from string import whitespace
from sys import stdin

omok=[]
for i in range(19):
    omok.append(list(map(int, stdin.readline().split())))

dX=[1, 1, 0, -1]
dY=[0, 1, 1, 1]
def check(y, x):
    result=False
    resultPos=[-1, -1]
    for i in range(4):
        win=True
        # print(omok[y][x], omok[y+dY[i]][x+dX[i]], omok[y+2*dY[i]][x+2*dX[i]], omok[y+3*dY[i]][x+3*dX[i]], omok[y+4*dY[i]][x+4*dX[i]], omok[y+5*dY[i]][x+5*dX[i]])
        # if y+5*dY[i]<19 and y+5*dY[i]>=0 and x+5*dX[i]<19 and x+5*dX[i]>=0:
        #     if omok[y][x]==omok[y+dY[i]][x+dX[i]] and omok[y+dY[i]][x+dX[i]]==omok[y+2*dY[i]][x+2*dX[i]] and omok[y+2*dY[i]][x+2*dX[i]]==omok[y+3*dY[i]][x+3*dX[i]] and omok[y+3*dY[i]][x+3*dX[i]]==omok[y+4*dY[i]][x+4*dX[i]] and omok[y+4*dY[i]][x+4*dX[i]] != omok[y+5*dY[i]][x+5*dX[i]]:
        #         if y-dY[i]>=0 and y-dY[i]<19 and x-dX[i]>=0 and x-dX[i]<19:
        #         win=True
        #         break
        # elif y+4*dY[i]<19 and y+4*dY[i]>=0 and x+4*dX[i]<19 and x+4*dX[i]>=0:
        #     if omok[y][x]==omok[y+dY[i]][x+dX[i]] and omok[y+dY[i]][x+dX[i]]==omok[y+2*dY[i]][x+2*dX[i]] and omok[y+2*dY[i]][x+2*dX[i]]==omok[y+3*dY[i]][x+3*dX[i]] and omok[y+3*dY[i]][x+3*dX[i]]==omok[y+4*dY[i]][x+4*dX[i]]:
        #         win=True
        #         break
        for j in range(1, 5):
            if y+j*dY[i]>=19 or y+j*dY[i]<0 or x+j*dX[i]>=19 or x+j*dX[i]<0:
                win=False
                break
            if omok[y][x]!=omok[y+j*dY[i]][x+j*dX[i]]:
                win=False
                break
        if win:
            if y+5*dY[i]<19 and y+5*dY[i]>=0 and x+5*dX[i]<19 and x+5*dX[i]>=0:
                if omok[y][x]==omok[y+5*dY[i]][x+5*dX[i]]:
                    win=False
            if y-dY[i]<19 and y-dY[i]>=0 and x-dX[i]<19 and x-dX[i]>=0:
                if omok[y][x]==omok[y-dY[i]][x-dX[i]]:
                    win=False
        
        if win:
            result=win
            if i!=3:
                resultPos=[y, x]
            else:
                resultPos=[y+4*dY[i], x+4*dX[i]]
    return result, resultPos

blackWin=False
blackWinPos=[]
whiteWin=False
whiteWinPos=[]
for y in range(19):
    for x in range(19):
        if not blackWin and omok[y][x]==1:
            blackWin, pos=check(y ,x)
            # if blackWin:
            #     print(y+1, x+1)
            if len(blackWinPos)==0 and blackWin:
                blackWinPos.append(pos[0]+1)
                blackWinPos.append(pos[1]+1)
        elif not whiteWin and omok[y][x]==2:
            whiteWin, pos=check(y, x)
            # if whiteWin:
            #     print(y+1, x+1)
            if len(whiteWinPos)==0 and whiteWin:
                whiteWinPos.append(pos[0]+1)
                whiteWinPos.append(pos[1]+1)
# print(blackWin, whiteWin)
if blackWin and not whiteWin:
    print(1)
    print(*blackWinPos)
elif not blackWin and whiteWin:
    print(2)
    print(*whiteWinPos)
else:
    print(0)

        


