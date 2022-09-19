from sys import stdin

n=int(stdin.readline())
Max=[n]
for i in range(1, n+1):
    temp=[n, i]
    while True:
        value=temp[-2]-temp[-1]
        if value>=0:
            temp.append(value)
        else:
            break
    if len(Max)<len(temp):
        Max=temp
print(len(Max))
print(*Max)
