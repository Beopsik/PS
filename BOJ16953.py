from queue import PriorityQueue
from sys import stdin        

a, b=map(int, stdin.readline().split())
count=0
while True:
    if b<a:
        print(-1)
        exit(0)
    if b==a:
        count+=1
        break
    bStr=str(b)
    if bStr[-1]=="1":
        count+=1
        b=int(bStr[:-1])
        continue
    else:
        if b%2==0:
            count+=1
            b//=2
            continue
        else:
            print(-1)
            exit(0)
print(count)
