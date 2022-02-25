import copy

def check(orderList:list, lenList:list, length:int)->int:
    idx=orderList.index(length)
    leftIdx=-1
    rightIdx=-1
    if idx-1<0:
        leftIdx=len(orderList)-1
        rightIdx=idx+1
    elif idx+1>=len(orderList):
        leftIdx=idx-1
        rightIdx=0
    else:
        leftIdx=idx-1
        rightIdx=idx+1
    
    for list in lenList:
        if len(list)!=2:
            continue

        if orderList[leftIdx] in list:
            list.remove(orderList[leftIdx])
            return list[0]
        
        if orderList[rightIdx] in list:
            list.remove(orderList[rightIdx])
            return list[0]
    return -1

count=int(input())
lenList=[[] for i in range(5)]
orderList=[]

for i in range(6):
    dir, length=input().split()
    dir=int(dir)
    length=int(length)
    lenList[dir].append(length)
    orderList.append(length)

MaxLen=[]
CutLen=[]
for list in lenList:
    if len(list)!=1:
        continue
    MaxLen.append(list[0])
    CutLen.append(check(copy.deepcopy(orderList), copy.deepcopy(lenList), list[0]))

print((MaxLen[0]*MaxLen[1]-CutLen[0]*CutLen[1])*count)

