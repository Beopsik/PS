from sys import stdin        

v=int(stdin.readline())
graph=[]
checkRoot=[i for i in range(v+1)]
belongSet=[[i] for i in range(v+1)]
mstSet=set()
for i in range(v):
    cost = list(map(int, stdin.readline().split()))
    for j in range(v):
        if i==j:
            continue
        graph.append([cost[j], i, j])
graph.sort()
# print(graph)
i=0
cost=0
while True:
    # print("Root:",checkRoot)
    # print("Belongs:",belongSet)
    # print()
    if i==len(graph) or len(mstSet)+1==v:
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
