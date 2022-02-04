from sys import stdin


num=int(input())

check=[-1 for i in range(0, 11)]

count=0
for i in range(num):
    inputList=list(map(int, stdin.readline().split()))
    
    if(check[inputList[0]]==-1):
        check[inputList[0]]=inputList[1]
    else:
        if(check[inputList[0]]!=inputList[1]):
            count+=1
        check[inputList[0]]=inputList[1]


print(count)

