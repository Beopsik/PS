from sys import stdin

n = int(stdin.readline())

enterTunnel=[]
outTunnel=[]
for i in range(n):
    enterTunnel.append(stdin.readline().rstrip())
for i in range(n):
    outTunnel.append(stdin.readline().rstrip())

overtaking=[]
enter=0
out=0
while out<len(outTunnel):
    if enterTunnel[enter] in overtaking:
        enter+=1
    elif  enterTunnel[enter]!=outTunnel[out]:
        overtaking.append(outTunnel[out])
        out+=1
    else:
        enter+=1
        out+=1
print(len(overtaking))
