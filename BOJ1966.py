from sys import stdin

tc=int(stdin.readline())

result=""
for i in range(tc):
    n, m= map(int, stdin.readline().split())
    q = list(map(int, stdin.readline().split()))
    if n==1:
        result+=str(1)+"\n"
        continue

    order=0
    while m>=0:
        if q[0]!=max(q):
            q=q[1:]+q[:1]
            if m==0:
                m=len(q)-1
            else:
                m-=1
        else:
            del q[0]
            order+=1
            m-=1
    result+=str(order)+"\n"   
print(result)
