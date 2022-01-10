num=int(input())

inputList=[]
for i in range(0, num):
    tempList=list(map(int, input().split()))
    inputList.append(tempList)


score=[]
for List in inputList:
    Max=-1
    for i in range(5):
        for j in range(i+1, 5):
            for k in range(j+1, 5):
                value=(List[i]+List[j]+List[k])%10

                if value>=Max:
                    Max=value
    score.append(Max)

for i in range(num-1, -1, -1):
    if score[i]==max(score):
        print(i+1)
        break
