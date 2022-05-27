from sys import stdin

m, n = map(int, stdin.readline().split())
k = int(stdin.readline())
market=[]
counterClockwise=[0, 3, 4, 2, 1]
for i in range(k):
    market.append(list(map(int, stdin.readline().split())))
guard=list(map(int, stdin.readline().split()))

result=0
for e in market:

    distance=0
    if guard[0]==1 or guard[0]==4:
        distance+=guard[1]
    elif guard[0]==2:
        distance+=m-guard[1]
    elif guard[0]==3:
        distance+=n-guard[1]
    
    next=counterClockwise[guard[0]]
    while True:
        if next==e[0]:
            if next==1:
                distance+=m-e[1]
            elif next==2:
                distance+=e[1]
            elif next==3:
                distance+=e[1]
            elif next==4:
                distance+=n-e[1]
            break
        else:
            if next==1 or next==2:
                distance+=m
            else:
                distance+=n
        next=counterClockwise[next]
    
    if distance>(2*n+2*m):
        distance-=(2*n+2*m)
    result+=min(distance, (2*n+2*m)-distance)
print(result)
