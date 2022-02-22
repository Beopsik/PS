n, newPoint, p=input().split()
n=int(n)
newPoint=int(newPoint)
p=int(p)

pointList=[]
if n!=0:
    pointList=list(map(int, input().split()))

pointList.append(newPoint)
pointList.sort(reverse=True)

count=pointList.count(newPoint)
rank=pointList.index(newPoint)+1

if rank+count-1<=p:
    print(rank)
else:
    print(-1)
