from sys import stdin

n, m=map(int, stdin.readline().split())
nSet=set()
for i in range(n):
    nSet.add(stdin.readline().rstrip())
mList=[]
for i in range(m):
    mList.append(stdin.readline().rstrip())    

result=0
for word in mList:
    if word in nSet:
        result+=1
print(result)

    
