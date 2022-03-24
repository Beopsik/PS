from sys import stdin

def roll(string, n):
    return string[n:]+string[:n]

clockNumList=[]
for num in range(1111, 10000):
    numStr=str(num)
    if "0" in numStr:
        continue
    tempList=[]
    tempList.append(num)
    for i in range(1, 4):
        tempStr=roll(numStr, i)
        tempList.append(int(tempStr))
    clockNumList.append(min(tempList))
clockNumList=set(clockNumList)
clockNumList=list(clockNumList)
clockNumList.sort()

value=list(map(str, stdin.readline().split()))
temp="".join(value)
tempList=[]
tempList.append(int(temp))
for i in range(1, 4):
    tempStr=roll(temp, i)
    tempList.append(int(tempStr))
clockNum=min(tempList)
print(clockNumList.index(clockNum)+1)

