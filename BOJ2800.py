from collections import deque
from copy import deepcopy
from sys import stdin

expression=stdin.readline().rstrip()
pair=[]
stack=deque()
for i in range(len(expression)):
    if expression[i]=="(":
        stack.append(i)
    elif expression[i]==")":
        pair.append((stack.pop(), i))

result=[]
def dfs(expression, i):
    if i>=len(pair):
        return
    idx=pair[i]
    temp=list(expression)
    temp[idx[0]]="!"
    temp[idx[1]]="!"
    nextExp="".join(temp)
    if nextExp not in result:
        result.append(nextExp)
        dfs(nextExp, i+1)

    dfs(expression, i+1)

dfs(expression, 0)
for i in range(len(result)):
    result[i]=result[i].replace("!", "")
result=list(set(result))
result.sort()
print("\n".join(result))
