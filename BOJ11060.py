from sys import stdin
import sys
limit_number = 15000
sys.setrecursionlimit(limit_number)

n = int(stdin.readline())
maze = list(map(int, stdin.readline().split()))
if n==1:
    print(0)
    exit(0)

dp=[1001 for i in range(n)]
def dfs(maze, idx):
    if idx==n-1:
        return 0
    if idx>n-1:
        return 1001
    if dp[idx]!=1001:
        return dp[idx]

    for i in range(1, maze[idx]+1):
        dp[idx]=min(dp[idx], dfs(maze, idx+i)+1)
    
    return dp[idx]

dfs(maze, 0)
if dp[0]==1001:
    print(-1)
else:
    print(dp[0])
