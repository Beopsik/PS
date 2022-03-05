n1, n2=input().split()
n1=int(n1)
n2=int(n2)

firstGroup=input()
secondGroup=input()

t=int(input())

load=[]
for i in range(len(firstGroup)-1, -1, -1):
    load.append([firstGroup[i], 1])
for e in secondGroup:
    load.append([e, -1])

for i in range(t):
    jumpList=[]
    for j in range(len(load)-1):
        if load[j][1]-load[j+1][1]==2:
            jumpList.append([j, j+1])
    for e in jumpList:
        temp=load[e[0]]
        load[e[0]]=load[e[1]]
        load[e[1]]=temp

result=""
for e in load:
    result+=e[0]
print(result)
