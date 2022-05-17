from sys import stdin

n, m, b = map(int, stdin.readline().split())
land=[0 for i in range(257)]
Min=257
Max=0
for i in range(n):
    temp = list(map(int, stdin.readline().split()))
    for j in temp:
        Min=min(Min, j)
        Max=max(Max, j)
        land[j]+=1

time=1000000000
height=0
for i in range(Min, Max+1):
    tempTime=0
    tempBlock=b
    possible=True
    for j in range(Max, Min-1, -1):
        if j<i:
            if tempBlock>=(i-j)*land[j]:
                tempBlock-=(i-j)*land[j]
                tempTime+=(i-j)*land[j]*1
            else:
                possible=False
                break
        elif j>i:
            tempTime+=(j-i)*land[j]*2
            tempBlock+=(j-i)*land[j]

    if possible:
        if time>=tempTime:
            time=tempTime
            height=max(height, i)
print(time, height)
