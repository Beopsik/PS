from sys import stdin        

n, m=map(int, stdin.readline().split())
checkRoot=[i for i in range(n+1)]
belongRoot=[[i] for i in range(n+1)]

result=0
for i in range(m):
    point1, point2=map(int, stdin.readline().split())
    if checkRoot[point1]==checkRoot[point2]:
        result=i+1
        break
    else:
        point1Root=checkRoot[point1]
        point2Root=checkRoot[point2]
        if point1Root>point2Root:
            temp=point1Root
            point1Root=point2Root
            point2Root=temp
        for point in belongRoot[point2Root]:
            checkRoot[point]=point1Root
            belongRoot[point1Root].append(point)
        belongRoot[point2Root]=[]
print(result)
