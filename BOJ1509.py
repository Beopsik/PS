from sys import stdin      
input=stdin.readline

string=list(input().rstrip())
n=len(string)

dp=[[0 for _ in range(n+1)] for _ in range(n+1)]
result=[1000000000]*(n+1)
result[0]=0

for i in range(1, n+1):
    dp[i][i]=1

for i in range(1, n):
    if string[i-1]==string[i]:
        dp[i][i+1]=1

for size in range(2, n):
    for startIdx in range(1, n+1-size):
        if string[startIdx-1]==string[startIdx+size-1] and dp[startIdx+1][startIdx+size-1]==1:
            dp[startIdx][startIdx+size]=1

for i in range(1, n+1):
    result[i]=min(result[i], result[i-1]+1)
    for j in range(i, n+1):
        if dp[i][j]!=0:
            result[j]=min(result[j], result[i-1]+1)

print(result[n])
