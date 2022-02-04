from sys import stdin


num=int(input())

Set=[False for i in range(0, 21)]

result=""
for i in range(num):
    inputList=list(map(str, stdin.readline().split()))
    if(len(result)>=4000000):
        print(result, end="")
        result=""

    if inputList[0]=="add" and Set[int(inputList[1])]==False:
        Set[int(inputList[1])]=True
    elif inputList[0]=="remove" and Set[int(inputList[1])]==True:
        Set[int(inputList[1])]=False
    elif inputList[0]=="check":
        if Set[int(inputList[1])]==True:
            result+="1\n"
        else:
            result+="0\n"
    elif inputList[0]=="toggle":
        if Set[int(inputList[1])]==True:
            Set[int(inputList[1])]=False
        else:
            Set[int(inputList[1])]=True
    elif inputList[0]=="all":
        Set=[True for i in range(0, 21)]
    elif inputList[0]=="empty":
        Set=[False for i in range(0, 21)]

print(result)

