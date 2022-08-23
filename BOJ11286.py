from queue import PriorityQueue
from sys import stdin        

class absValue:
    def __init__(self, value):
        self.value=value
    def __lt__(self, other):
        if abs(self.value)<abs(other.value):
            return abs(self.value)<abs(other.value)
        elif abs(self.value)==abs(other.value):
            return self.value<other.value
        
n=int(stdin.readline())
operation=PriorityQueue()
result=[]

for i in range(n):
    value=int(stdin.readline())
    if value==0:
        if operation.empty():
            result.append("0")
        else:
            Min=operation.get()
            result.append(str(Min.value))
    else:
        operation.put(absValue(value))

result="\n".join(result)
print(result)
