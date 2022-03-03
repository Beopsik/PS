
numList=[0 for i in range(10)]
chList=[[] for i in range(4)]
for i in range(5):
    ch, num=input().split()
    num=int(num)
    if ch=="R":
        chList[0].append(num)
    elif ch=="B":
        chList[1].append(num)
    elif ch=="Y":
        chList[2].append(num)
    else:
        chList[3].append(num)
    numList[num]+=1
for list in chList:
    list.sort()

score=0

numListStr=""
for i in numList:
    numListStr+=str(i)
for list in chList:
    if score==0 and len(list)==5 and sum(list)==((5*(list[0]+list[-1]))//2):
        score=900+list[-1]
    elif score==0 and len(list)==5 and sum(list)!=((5*(list[0]+list[-1]))//2):
        score=600+list[-1]
for i in range(10):
    if score==0 and numList[i]==4:
        score=800+i
if score==0 and 3 in numList and 2 in numList:
    threeIdx=numList.index(3)
    twoIdx=numList.index(2)
    score=threeIdx*10+twoIdx+700
elif score==0 and 1 in numList and numListStr.rindex(str(1))-numList.index(1)==4:
    score=500+numListStr.rindex(str(1))
elif score==0 and 3 in numList:
    score=400+numList.index(3)
elif score==0 and numList.count(2)==2:
    score=numListStr.rindex(str(2))*10+numList.index(2)+300
elif score==0 and numList.count(2)==1:
    score=numList.index(2)+200
if score==0:
    idx=0
    for i in range(len(numList)-1, 0, -1):
        if numList[i]!=0:
            idx=i
            break
    score=idx+100
print(score)
    
