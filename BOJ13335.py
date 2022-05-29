from sys import stdin

n, w, l=map(int, stdin.readline().split())
truck=list(map(int, stdin.readline().split()))

time=0
idx=0
onBridgeTruck=[]
distance=[0 for i in range(n+1)]
while True:
    if idx==n and len(onBridgeTruck)==0:
        break
    
    if len(onBridgeTruck) !=0 and distance[idx-len(onBridgeTruck)]==w:
        onBridgeTruck.pop(0)
    if idx<n and len(onBridgeTruck)+1<=w and sum(onBridgeTruck)+truck[idx]<=l:
        onBridgeTruck.append(truck[idx])
        idx+=1

    for i in range(idx):
        distance[i]+=1
    time+=1

print(time)
