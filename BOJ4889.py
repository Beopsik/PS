from collections import deque
from sys import stdin

list=[]
while True:
    temp=stdin.readline().rstrip()
    if temp.count("-")>=1:
        break
    list.append(temp)

stack=deque()
result=[]
idx=1
for s in list:
    for e in s:
        if e=="{":
            stack.append("{")
        else:
            if len(stack)!=0 and stack[-1]=="{":
                stack.pop()
            else:
                stack.append("}")
    
    opCount=0
    if len(stack)==0:
        result.append(str(idx)+". 0\n")
    else:
        temp=deque()
        for e in stack:
            if e=="{":
                if len(temp)!=0 and temp[-1]=="{":
                    temp.pop()
                    opCount+=1
                else:
                    temp.append("{")
            else:
                if len(temp)!=0 and temp[-1]=="{":
                    temp.pop()
                else:
                    temp.append("{")
                    opCount+=1
        result.append(str(idx)+". "+str(opCount)+"\n")
    stack.clear()
    idx+=1
print("".join(result))
    

    
