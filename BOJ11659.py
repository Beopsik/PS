from sys import stdin

n, m=map(int, stdin.readline().split())
numList=list(map(int ,stdin.readline().split()))
sumList=[0 for i in range(n+1)]
for i in range(1, n+1):
    sumList[i]=sumList[i-1]+numList[i-1]
# print(sumList)
result=[]
for i in range(m):
    left, right=map(int, stdin.readline().split())
    result.append(str(sumList[right]-sumList[left-1]))
print("\n".join(result))
