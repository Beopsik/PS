from sys import stdin

woollim=list(map(int, stdin.readline().split()))
starlink=list(map(int, stdin.readline().split()))

wPoint=0
sPoint=0
for i in range(9):
    wPoint+=woollim[i]
    
    if(wPoint>sPoint):
        print("Yes")
        exit(0)
    
    sPoint+=starlink[i]

print("No")
