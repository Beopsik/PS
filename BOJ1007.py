from math import sqrt
import itertools
from sys import stdin

T=int(stdin.readline())
result=[]

for t in range(T):
    n=int(stdin.readline())
    pos=[]

    yTotal=0
    xTotal=0
    for i in range(n):
        y, x=map(int, stdin.readline().split())
        yTotal+=y
        xTotal+=x
        pos.append((y, x))
    
    Min=1000000000
    pair=list(itertools.combinations(pos, n//2))
    half=len(pair)//2
    for p in pair[:half]:
        p=list(p)

        y1Total=0
        x1Total=0
        for y, x in p:
            y1Total+=y
            x1Total+=x
        
        y2Total=yTotal-y1Total
        x2Total=xTotal-x1Total

        Min=min(Min, sqrt(pow(y1Total-y2Total, 2)+pow(x1Total-x2Total, 2)))
    
    result.append(str(Min))

print("\n".join(result))
    
