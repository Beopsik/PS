from sys import stdin

n=int(stdin.readline())
numList=list(map(int, stdin.readline().split()))
plus, minus, mul, div=map(int, stdin.readline().split())
opList=[]
for i in range(plus):
    opList.append('+')
for i in range(minus):
    opList.append('-')
for i in range(mul):
    opList.append('*')
for i in range(div):
    opList.append('//')

Max=-1000000001
Min=1000000001
check=[False for i in range(len(opList))]
opSet=set()
def dfs(value, count, op):
    global Max
    global Min
    if(count==n-1):
        Max=max(Max, value)
        Min=min(Min, value)
        return

    for i in range(0, len(opList)):
        if check[i]:
            continue

        if opList[i]=='+':
            op+="+"
            if op not in opSet:
                check[i]=True
                opSet.add(op)
                dfs(value+numList[count+1], count+1, op)
                check[i]=False
            op=op[:-1]
        elif opList[i]=='-':
            op+="-"
            if op not in opSet:
                check[i]=True
                opSet.add(op)
                dfs(value-numList[count+1], count+1, op)
                check[i]=False
            op=op[:-1]
        elif opList[i]=='*':
            op+="*"
            if op not in opSet:
                check[i]=True
                opSet.add(op)
                dfs(value*numList[count+1], count+1, op)
                check[i]=False
            op=op[:-1]
        elif opList[i]=='//':
            op+="//"
            if op not in opSet:
                check[i]=True
                opSet.add(op)
                temp=0
                if value<0:
                    temp=(-value)//numList[count+1]
                    temp=-temp
                else:
                    temp=value//numList[count+1]
                dfs(temp, count+1, op)
                check[i]=False
            op=op[:-2]
dfs(numList[0], 0, "")
print(Max)
print(Min)

