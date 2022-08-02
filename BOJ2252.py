from sys import stdin        
import sys
sys.setrecursionlimit(150000)

n, m=map(int, stdin.readline().split())
compare=[[] for i in range(n+1)]

for i in range(m):
    a, b=map(int, stdin.readline().split())
    compare[b].append(a)

check=[False for i in range(n+1)]
result=[]
def dfs(student):
    
    check[student]=True

    for i in compare[student]:
        if not check[i]:
            dfs(i)
    result.append(student)

for i in range(len(compare)):
    if len(compare[i])!=0 and not check[i]:
        dfs(i)
rest=set([i for i in range(1, n+1)])-set(result)
result+=list(rest)
print(*result)
