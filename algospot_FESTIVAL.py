c=int(input())
result=""
for i in range(0, c):
    n, l=input().split()
    n=int(n)
    l=int(l)
    cost=list(map(int, input().split()))
    cost.append(0)
    Min=1000001
    for len in range(l, n+1):
        sumCost=sum(cost[:len])
        for idx in range(0, n+1-len):
            average=sumCost/len
            Min=min(average, Min)
            sumCost-=cost[idx]
            sumCost+=cost[len+idx]
    Str="{:.10f}".format(Min)
    result+=Str+"\n"

print(result)
