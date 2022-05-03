from sys import stdin

k, l=input().split()
k=int(k)
l=int(l)

dic={}
for i in range(l):
    studentId=stdin.readline().rstrip()
    if studentId in dic:
        del dic[studentId]
        dic[studentId]=1
    else:
        dic[studentId]=1
waitingList=list(dic.keys())

if k>len(dic):
    k=len(dic)
for i in range(k):
    print(waitingList[i])
