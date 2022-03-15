from sys import stdin
k=int(stdin.readline())

numList=[]
for i in range(k):
    temp=int(stdin.readline())
    if temp==0:
        numList.pop()
    else:
        numList.append(temp)
print(sum(numList))
