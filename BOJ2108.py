from sys import stdin
import decimal

n=int(stdin.readline())

Min=4001
Max=-4001
sum=0
numList=[]
plusNumCount=[0 for i in range(4001)]
minusNumCount=[0 for i in range(4001)]
for i in range(n):
    temp=int(stdin.readline())
    sum+=temp
    numList.append(temp)
    if temp<0:
        minusNumCount[-temp]+=1
    else: 
        plusNumCount[temp]+=1
    Min=min(Min, temp)
    Max=max(Max, temp)
numList.sort()

print(round(decimal.Decimal(sum/n)))
print(numList[n//2])
minusCountMax=max(minusNumCount)
plusCountMax=max(plusNumCount)
if minusCountMax>plusCountMax:
    if minusNumCount.count(minusCountMax)>1:
        minusNumCount.reverse()
        minusNumCount[minusNumCount.index(minusCountMax)]=0
        print(-(4000-minusNumCount.index(minusCountMax)))
    else:
        print(-minusNumCount.index(minusCountMax))
elif minusCountMax<plusCountMax:
    if plusNumCount.count(plusCountMax)>1:
        plusNumCount[plusNumCount.index(plusCountMax)]=0
        print(plusNumCount.index(plusCountMax))
    else:
        print(plusNumCount.index(plusCountMax))
else:
    if minusNumCount.count(minusCountMax)==1:
        print(plusNumCount.index(plusCountMax))
    else:
        if minusNumCount.count(minusCountMax)>1:
            minusNumCount.reverse()
            minusNumCount[minusNumCount.index(minusCountMax)]=0
            print(-(4000-minusNumCount.index(minusCountMax)))
        else:
            print(-minusNumCount.index(minusCountMax))

print(Max-Min)
