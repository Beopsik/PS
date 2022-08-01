from sys import stdin        

v, e=map(int, stdin.readline().split())
graph=[]
checkRoot=[i for i in range(v+1)]
belongSet=[[i] for i in range(v+1)]
mstSet=set()
for i in range(e):
    v1, v2, c=map(int, stdin.readline().split())
    graph.append([c, v1, v2])
graph.sort()

i=0
cost=0
while True:
    # print("Root:",checkRoot)
    # print("Belongs:",belongSet)
    # print()
    if i==e or len(mstSet)==e:
        break

    c, v1, v2=map(int, graph[i])
    if checkRoot[v1] != checkRoot[v2]:
        cost+=c
        v1Root=checkRoot[v1]
        v2Root=checkRoot[v2]
        if v1Root>v2Root:
            temp=v1Root
            v1Root=v2Root
            v2Root=temp
        
        for s in belongSet[v2Root]:
            checkRoot[s]=v1Root
            belongSet[v1Root].append(s)
        belongSet[v2Root]=[]
        mstSet.add((c, v1, v2))
    i+=1

print(cost)
