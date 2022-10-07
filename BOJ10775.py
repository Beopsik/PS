from sys import stdin        

g=int(stdin.readline())
p=int(stdin.readline())
gate=[0 for i in range(g+1)]
count=[0 for i in range(g+1)]
result=0
finish=False
for i in range(1, p+1):
    gi=int(stdin.readline())
    if not finish:
        check=False
        for j in range(gi-count[gi], 0, -1):
            count[gi]+=1
            if gate[j]==0:
                gate[j]=i
                result+=1
                check=True
                break
        if not check:
            finish=True
print(result)
