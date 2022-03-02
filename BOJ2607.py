from sys import stdin


def check(str:str):
    strList=[]
    for s in str:
        if s!="\n":
            strList.append(s)
    strList.sort()
    return strList

num=int(stdin.readline())

str=str(stdin.readline())
strList=check(str)
resCount=0
for i in range(num-1):
    tempStr=stdin.readline()
    
    if abs(len(str)-len(tempStr)<=1):
        tempStrList=check(tempStr)

        if strList==tempStrList:
            resCount+=1
        else:
            set1=set(strList)
            set2=set(tempStrList)

            tempSet=set1.union(set2)
            count=0
            diff=[]
            for e in tempSet:
                if abs(strList.count(e)-tempStrList.count(e))!=0:
                    diff.append(e)

            if len(diff)<=1:
                resCount+=1
            elif len(diff)==2:
                if strList.count(diff[0])-tempStrList.count(diff[0])==1 and tempStrList.count(diff[1])-strList.count(diff[1])==1:
                    resCount+=1
                elif strList.count(diff[1])-tempStrList.count(diff[1])==1 and tempStrList.count(diff[0])-strList.count(diff[0])==1:
                    resCount+=1
print(resCount)

