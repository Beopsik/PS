classNum=int(input())

stringForm="Max %d, Min %d, Largest gap %d"
result=""
for i in range(classNum):
    scoreList=list(map(int, input().split()))
    scoreList.remove(scoreList[0])
    scoreList.sort()
    tempList=[]
    for j in range(len(scoreList)-1):
        tempList.append(scoreList[j+1]-scoreList[j])
    result+="Class %d"%(i+1)+"\n"+stringForm%(scoreList[-1], scoreList[0], max(tempList))+"\n"    

print(result)
