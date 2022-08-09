from sys import stdin

fibonacci={0:0, 1:1, 2:1, 3:2, 4:3, 5:5, 6:8, 7:13, 8:21, 9:34, 10:55}
mod=1000000007
def fibo(n):
    global mod
    check=fibonacci.get(n, -1)
    if check!=-1:
        return check

    temp=n
    m=temp//2
    n-=m

    result=((fibo(m-1)*fibo(n))%mod+(fibo(m)*fibo(n+1))%mod)%mod
    fibonacci[temp]=result
    return result


n=int(stdin.readline())
print(fibo(n))
