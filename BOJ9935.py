from sys import stdin        

strings=list(stdin.readline().rstrip())
explosionStr=list(stdin.readline().rstrip())
explosionLen=len(explosionStr)
stack=[]
for s in strings:
    stack.append(s)
    if len(stack) >= explosionLen and stack[len(stack)-explosionLen:]==explosionStr:
        for i in range(len(explosionStr)):
            stack.pop(len(stack)-1)
result="".join(stack)
if result=="":
    print("FRULA")
else:
    print(result)
