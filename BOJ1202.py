from sys import stdin        
import heapq

bag=[]
jewelry=[]
n, k=map(int, stdin.readline().split())
for i in range(n):
    heapq.heappush(jewelry, list(map(int, stdin.readline().split())))
for i in range(k):
    bag.append(int(stdin.readline()))
bag.sort()

result=0
temp_jewelery=[]
for b in bag:
    while jewelry and b>=jewelry[0][0]:
        heapq.heappush(temp_jewelery, -heapq.heappop(jewelry)[1])
    if temp_jewelery:
        result-=heapq.heappop(temp_jewelery)
    elif not jewelry:
        break
print(result)
