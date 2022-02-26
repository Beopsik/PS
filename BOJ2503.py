from itertools import permutations
import string
permu=[]
for i in permutations([1, 2, 3, 4, 5, 6, 7, 8, 9], 3):
    permu.append(i)
# print(permu)

def check(ques:string, pernumElement:tuple):
    strike=0
    ball=0
    for i in range(len(ques)):
        if int(ques[i]) in pernumElement:
            if pernumElement.index(int(ques[i]))==i:
                strike+=1
            else:
                ball+=1
    return [strike, ball]

n=int(input())

for i in range(n):
    ques, strike, ball=input().split()
    strike=int(strike)
    ball=int(ball)
    removeList=[]
    for t in permu:
        tempList=check(ques, t)
        if tempList[0]!=strike or tempList[1]!=ball:
            removeList.append(t)
    
    for t in removeList:
        permu.remove(t)

print(len(permu))
