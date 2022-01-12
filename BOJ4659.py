vowel=["a", "e", "i", "o", "u"]

inputStr=""
resultStr=""


while True:
    firstCondition=False
    secondCondition=True
    thirdCondition=True

    inputStr=input()
    if inputStr=="end":
        break
    
    for spelling in vowel:
        if inputStr.count(spelling)>0:
            firstCondition=True
            break
    
    if firstCondition==False:
        resultStr+="<%s> is not acceptable.\n"%inputStr
        continue

    count=1
    for idx in range(len(inputStr)-1):
        if inputStr[idx] in vowel and inputStr[idx+1] in vowel:
            count+=1
        elif inputStr[idx] not in vowel and inputStr[idx+1] not in vowel:
            count+=1
        else:
            count=1

        if count>=3:
            secondCondition=False
            break
    
    if secondCondition==False:
        resultStr+="<%s> is not acceptable.\n"%inputStr
        continue

    count=1
    for idx in range(len(inputStr)-1):
        if inputStr[idx]==inputStr[idx+1]:
            count+=1
        else:
            count=1
        
        if count>=2:
            if inputStr[idx]!="e" and inputStr[idx]!="o":
                thirdCondition=False
                break
    
    if thirdCondition==False:
        resultStr+="<%s> is not acceptable.\n"%inputStr
        continue

    resultStr+="<%s> is acceptable.\n"%inputStr

print(resultStr)



    
    
