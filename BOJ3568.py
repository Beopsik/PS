import re
from sys import stdin

p=re.compile('\[]|\*|&')
value=list(stdin.readline().split())
for i in range(len(value)):
    if "," in value[i]:
        value[i]=value[i].replace(",", "")
    if ";" in value[i]:
        value[i]=value[i].replace(";", "")
result=[]
for i in range(1, len(value)):
    f=p.findall(value[i])
    f=f[::-1]
    s=p.search(value[i])
    temp=""
    if s!=None:
        temp=value[0]+"".join(f)+" "+value[i][:s.span()[0]]
    else:
        temp=value[0]+"".join(f)+" "+value[i]
    result.append(temp)
    result.append(";\n")
print("".join(result))
