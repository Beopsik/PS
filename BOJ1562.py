from sys import stdin       
input=stdin.readline 

Max=(1<<10)-1

n=int(input())

dp=[[0]*(Max+1) for _ in range(10)]
for i in range(1, 10):
    dp[i][1<<i]=1
for _ in range(2, n+1):
    nextDp=[[0]*(Max+1) for _ in range(10)]
    
    for i in range(10):
        for j in range(Max+1):
            if i>0:
                nextDp[i][j|(1<<i)]=(nextDp[i][j|(1<<i)]+dp[i-1][j])%1000000000
            if i<9:
                nextDp[i][j|(1<<i)]=(nextDp[i][j|(1<<i)]+dp[i+1][j])%1000000000
    dp=nextDp

result=0
for i in range(10):
    result+=dp[i][Max]
print(result%1000000000)

