from sys import stdin
from collections import deque

input=stdin.readline 

n=int(input())
tower=list(map(int, input().split()))
launch=deque()
launch.append((tower[-1], n-1))

result=[0 for i in range(n)]
for i in range(n-2, -1, -1):
    while len(launch)!=0 and tower[i]>launch[0][0]:
        result[launch[0][1]]=i+1
        launch.popleft()
    launch.appendleft((tower[i], i))

print(*result)
    


