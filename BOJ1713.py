from re import S
from sys import stdin

n = int(stdin.readline())
k = int(stdin.readline())
recommendation=list(map(int, stdin.readline().split()))

pictureFrame=[]
recommendationNum={}

for student in recommendation:
    if student not in pictureFrame and len(pictureFrame)<n:
        pictureFrame.append(student)
        recommendationNum[student]=1
    elif student in pictureFrame:
        recommendationNum[student]+=1
    elif student not in pictureFrame and len(pictureFrame)>=n:
        recommendationNum=dict(sorted(recommendationNum.items(), key=lambda x:x[1]))
        temp=list(recommendationNum.keys())
        i=0
        while i<n-1 and recommendationNum[temp[i]]==recommendationNum[temp[i+1]]:
            i+=1
        temp=temp[:i+1]

        late=n+1
        toRemove=0
        for i in temp:
            if pictureFrame.index(i)<late:
                late=pictureFrame.index(i)
                toRemove=i
        
        pictureFrame.remove(toRemove)
        del recommendationNum[toRemove]

        pictureFrame.append(student)
        recommendationNum[student]=1
    # print(pictureFrame)
    # print(recommendationNum)
    # print()
result=list(recommendationNum.keys())
result.sort()
print(*result)


        


