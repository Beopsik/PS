from sys import stdin
from math import dist
from math import fsum

tempA=list(map(int, stdin.readline().split()))
a1=tempA[0:2]
a2=tempA[2:]
tempB=list(map(int, stdin.readline().split()))
b1=tempB[0:2]
b2=tempB[2:]

x=set([a1[0], a2[0], b1[0], b2[0]])
y=set([a1[1], a2[1], b1[1], b2[1]])

lenX=len(x)
lenY=len(y)
tempX=list(x)
tempX.sort()
tempY=list(y)
tempY.sort()
if a2[0]<b1[0] or a2[1]<b1[1] or b2[0]<a1[0] or b2[1]<a1[1]:
        print("NULL")
elif lenX==3 and lenY==3:
    if (tempX[1]==a2[0] and tempX[1]==b1[0] and tempY[1]==a2[1] and tempY[1]==b1[1]) or (tempX[1]==a1[0] and tempX[1]==b2[0] and tempY[1]==a1[1] and tempY[1]==b2[1]) or (tempX[1]==a2[0] and tempX[1]==b1[0] and tempY[1]==a1[1] and tempY[1]==b2[1]) or (tempX[1]==b2[0] and tempX[1]==a1[0] and tempY[1]==b1[1] and tempY[1]==a2[1]):
        print("POINT")
    elif (tempX[1]==a2[0] and tempX[1]==b1[0]) or (tempY[1]==a2[1] and tempY[1]==b1[1]) or (tempX[1]==a1[0] and tempX[1]==b2[0]) or (tempY[1]==a1[1] and tempY[1]==b2[1]):
        print("LINE")
    else:
        print("FACE")
elif (lenX==2 and lenY==4) or (lenX==4 and lenY==2) or (lenX==2 and lenY==2):
    print("FACE")
elif (lenX==2 and lenY==3) or (lenX==4 and lenY==3):
    if (tempY[1]==a2[1] and tempY[1]==b1[1]) or (tempY[1]==a1[1] and tempY[1]==b2[1]):
        print("LINE")
    else:
        print("FACE")
elif (lenX==3 and lenY==2) or (lenX==3 and lenY==4):
    if (tempX[1]==a2[0] and tempX[1]==b1[0]) or (tempX[1]==a1[0] and tempX[1]==b2[0]):
        print("LINE")
    else:
        print("FACE")
elif lenX==4 and lenY==4:
        print("FACE")
