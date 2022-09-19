from sys import stdin

word=stdin.readline().rstrip()
wordLength=len(word)
wordList=[]
def backtracking(idx, devide):
    if len(devide)>=3:
        temp=[]
        for i in range(3):
            temp.append(devide[i][::-1])
        wordList.append("".join(temp))
        return
    
    for i in range(idx+1, wordLength+1):
        if len(devide)<2:
            devide.append(word[idx:i])
            backtracking(i, devide)
        else:
            devide.append(word[idx:])
            backtracking(i, devide)
        del devide[-1]

backtracking(0, [])
wordList.sort()
print(wordList[0])
    
