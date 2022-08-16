from queue import PriorityQueue
from sys import stdin        

n=int(stdin.readline())
operation=PriorityQueue()
result=[]

for i in range(n):
    value=int(stdin.readline())
    if value==0:
        if operation.empty():
            result.append("0")
        else:
            result.append(str(operation.get()))
    else:
        operation.put(value)

result="\n".join(result)
print(result)
