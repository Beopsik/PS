from sys import stdin

n=int(stdin.readline())
column=[]
for i in range(n):
    column.append(tuple(map(int, stdin.readline().split())))
    column.sort()
reverseColumn=list(reversed(column))

left=0
right=1
result=[]
while right<n:
    while right<n and column[left][1]>=column[right][1]:
        right+=1

    if right>=n:
        break
    result.append((column[left][1], column[right][0]-column[left][0]))
    left=right
    right+=1

left=0
right=1
while right<n:
    while right<n and reverseColumn[left][1]>reverseColumn[right][1]:
        right+=1
    
    if right>=n:
        break
    result.append((reverseColumn[left][1], reverseColumn[left][0]-reverseColumn[right][0]))
    left=right
    right+=1

area=reverseColumn[left][1]
# print(result)
for e in result:
    area+=e[0]*e[1]
print(area)
