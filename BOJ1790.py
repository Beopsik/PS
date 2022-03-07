n, k=input().split()
n=int(n)
k=int(k)

find=0
num=1
length=1
digitNum=0
while True:
    digitNum+=(10*num-num)*length
    if digitNum>=k:
        digitNum-=(10*num-num)*length
        break
    elif num>=n:
        print(-1)
        exit()
    else:
        num*=10
        length+=1

start=pow(10, length-1)
target=(k-digitNum-1)//length
pivot=(k-digitNum-1)%length

if start+target>n:
    print(-1)
else:
    print(str(start+target)[pivot])
