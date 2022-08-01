from sys import stdin        

num=int(stdin.readline())
point=[]
for i in range(num):
    point.append(list(map(int, stdin.readline().split())))
point.append(point[0])

result=0
for i in range(num):
    result+=point[i][0]*point[i+1][1]
for i in range(num):
    result-=point[i][1]*point[i+1][0]
print(abs(result)/2)
