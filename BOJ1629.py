from sys import stdin        

a, b, c=map(int, stdin.readline().split())

binaryB=str(format(b, 'b'))
squareList=[]
for i in range(len(binaryB)):
    if binaryB[i]=='1':
        squareList.append(2**(len(binaryB)-1-i))
squareList.sort()

dp={}
dp[1]=a%c
dp[2]=(a**2)%c
dp[4]=(a**4)%c
dp[8]=(a**8)%c
result=1
def recur(idx):
    if idx in dp:
        return dp[idx]
    dp[idx]=(recur(idx//2)*recur(idx//2))%c
    return dp[idx]

    
for i in squareList:
    result*=(recur(i)%c)
print(result%c)
