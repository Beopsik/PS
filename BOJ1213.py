str=input()

strList=[]
for e in str:
    strList.append(e)

strList.sort()

frontStr=""
midleStr=""
backStr=""
while True:
    alphabet=strList[0]
    idx=strList.index(alphabet)
    count=strList.count(alphabet)
    if count%2==0:
        tempStr="".join(s for s in strList[0:count//2])
        frontStr+=tempStr
        backStr=tempStr+backStr
    else:
        if midleStr!="":
            print("I'm Sorry Hansoo")
            exit()
        tempStr="".join(s for s in strList[0:count//2])
        frontStr+=tempStr
        backStr=tempStr+backStr
        midleStr+=strList[0]
    
    if len(strList)!=count:
        strList=strList[count:]
    else:
        break

print(frontStr+midleStr+backStr)

