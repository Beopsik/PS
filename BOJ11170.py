num=int(input())

result=""
for i in range(num):
    inputList=list(map(int, input().split()))
    numberList=[str(i) for i in range(inputList[0], inputList[1]+1)]
    numberList="".join(numberList)
    result+=str(numberList.count("0"))+"\n"

print(result)    
