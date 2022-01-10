countryNum=int(input())

resultTable=[]

for i in range(0, countryNum):
    studentResult=list(map(int, input().split()))
    resultTable.append(studentResult)

resultTable.sort(key=lambda x:x[2], reverse=True)

check=[0 for i in range(0, countryNum)]
medal=0
for i in range(0, countryNum):
    if medal==3:
        break
    
    if check[resultTable[i][0]]<2:
        print(resultTable[i][0], resultTable[i][1])
        check[resultTable[i][0]]+=1
        medal+=1
