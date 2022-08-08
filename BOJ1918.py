from collections import deque
from sys import stdin

expression=stdin.readline().rstrip()
operand=[]
operator=[]
priority={"*":0, "/":0, "+":1, "-":1, "(":2, ")":2}

def calculation(pri):
    global operand
    global operator

    for e in reversed(operator):
        if priority[e]>pri:
            break
        operator=operator[:-1]
        if e=="(":
            break
        if e==")":
            continue
        operand1=operand[-1]
        operand2=operand[-2]
        operand=operand[:-2]
        operand.append(str(operand2)+str(operand1)+e)

for e in expression:
    # print(operand)
    # print(operator)
    # print()
    if e=="+":
        if len(operator)!=0 and priority[operator[-1]]<=priority[e]:
            calculation(priority[e])
        operator.append(e)
    elif e=="-":
        if len(operator)!=0 and priority[operator[-1]]<=priority[e]:
            calculation(priority[e])
        operator.append(e)
    elif e=="*":
        if len(operator)!=0 and priority[operator[-1]]==priority[e]:
            calculation(priority[e])
        operator.append(e)
    elif e=="/":
        if len(operator)!=0 and priority[operator[-1]]==priority[e]:
            calculation(priority[e])
        operator.append(e)
    elif e=="(":
        operator.append(e)
    elif e==")":
        calculation(priority[e])
    else:
        operand.append(e)
calculation(3)
print(operand[0])
