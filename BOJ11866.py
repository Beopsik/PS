n, k=input().split()
n=int(n)
k=int(k)

numList=[str(i) for i in range(1, n+1)]

result="<"
nextStart=0
for i in range(n):
    j=nextStart
    count=0
    while count+1<k:
        if j+1>=len(numList):
            j=0
            count+=1
        else:
            j+=1
            count+=1
    result+=numList[j]+", "
    del numList[j]
    if j>=len(numList):
        nextStart=0
    else:
        nextStart=j
result=result[:-2]+">"
print(result)
