from sys import stdin        
import sys
sys.setrecursionlimit(150000)

n, m=map(int, stdin.readline().split())
compare=[[] for i in range(n+1)]

for i in range(m):
    temp = list(map(int, stdin.readline().split()))
    for i in range(temp[0], 1, -1):
        compare[temp[i]].append(temp[i-1])

check=[False for i in range(n+1)]
result=[]
def dfs(singer, belongs):
    
    check[singer]=True

    for i in compare[singer]:
        if i in belongs:
            print(0)
            exit(0)

        if not check[i]:
            belongs.append(singer)
            dfs(i, belongs)
            belongs.remove(singer)
    result.append(singer)

for i in range(len(compare)):
    if len(compare[i])!=0 and not check[i]:
        dfs(i, [])   
rest=set([i for i in range(1, n+1)])-set(result)       
result+=list(rest) 
for i in result:
    print(i)
