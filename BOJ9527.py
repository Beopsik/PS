from sys import stdin        

a, b=map(int, stdin.readline().split())
cumulativeSum=[0 for i in range(60)]

for i in range(1, 60):
    cumulativeSum[i]=2**(i-1)+2*cumulativeSum[i-1]

def count(num):
    result=0
    binNum=bin(num)[2:]
    length=len(binNum)

    for i in range(length):
        if binNum[i]=="1":
            pow=length-i-1
            result+=cumulativeSum[pow]
            result+=(num-2**pow+1)
            num=num-2**pow
    return result
print(count(b)-count(a-1))
