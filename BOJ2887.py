from sys import stdin        
input=stdin.readline 

n=int(input())
xList=[]
yList=[]
zList=[]
for i in range(n):
    x, y, z=map(int, input().split())
    xList.append((x, i))
    yList.append((y, i))
    zList.append((z, i))
xList.sort()
yList.sort()
zList.sort()

edge=[]
for curList in xList, yList, zList:
    for i in range(1, n):
        p1, a=curList[i-1]
        p2, b=curList[i]
        edge.append((abs(p1-p2), a, b))
edge.sort()

root=[i for i in range(n)]
belongSet={i: [i] for i in range(n)}

result=0
for e in edge:
    if len(belongSet[0])==n:
        break

    cost=e[0]
    p1=e[1]
    p2=e[2]

    root1=root[p1]
    root2=root[p2]
    if root1!=root2:
        result+=cost
        if root1>root2:
            root1, root2=root2, root1
        
        for b in belongSet[root2]:
            root[b]=root1
        belongSet[root1]+=belongSet[root2]
        
        belongSet[root2]={}
# print(belongSet)
print(result)
