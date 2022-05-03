n=int(input())
numList=list(map(int, input().split()))

preIdx=0
for i in range(n-1, 0, -1):
    if numList[i-1]>numList[i]:
        preIdx=i
        break
if preIdx==0:
    print(-1)
else:
    postIdx=n-1
    while(numList[preIdx-1]<numList[postIdx]):
        postIdx-=1

    temp=numList[preIdx-1]
    numList[preIdx-1]=numList[postIdx]
    numList[postIdx]=temp

    numList[preIdx:]=sorted(numList[preIdx:], reverse=True)
    result=""
    for i in numList:
        result+=str(i)+" "
    print(result)
