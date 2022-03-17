n, m=input().split()
n=int(n)
m=int(m)
if n>m:
    length=m
else:
    length=n

lectangle=[]
for i in range(n):
    lectangle.append(input())

def check(y, x ,length):
    return lectangle[y][x]==lectangle[y][x+length-1]==lectangle[y+length-1][x]==lectangle[y+length-1][x+length-1]

Max=1
for i in range(n):
    for j in range(m):
        for k in range(length):
            if i+k<n and i+k>=0 and j+k<m and j+k>=0:
                if check(i, j, k+1):
                    Max=max(Max, (k+1)*(k+1))

print(Max)
