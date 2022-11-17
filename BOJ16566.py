from sys import stdin        
input=stdin.readline 

n, m, k=map(int, input().split())
blue=list(map(int, input().split()))
red=list(map(int, input().split()))
blue.sort()

def binarySearch(value):
    left=0
    right=len(blue)-1
    idx=0
    while left<=right:
        mid=(left+right)//2
        if value>blue[mid]:
            left=mid+1
            idx=left
        elif value<blue[mid]:
            right=mid-1
            idx=left
        else:
            idx=mid+1
            break
    return idx

result=[]
root=[0 for _ in range(n+1)]
belongSet=[[] for _ in range(n+1)]
for b in blue:
    root[b]=b
    belongSet[b].append(b)
blueNext=[0 for _ in range(n+1)]
for i in range(len(blue)-1):
    blueNext[blue[i]]=blue[i+1]
blueNext[blue[-1]]=0
# print(root)
# print(belongSet)
# print()
for r in red:
    idx=binarySearch(r)
    result.append(str(root[blue[idx]]))
    curRoot=root[blue[idx]]
    nextRoot=root[blueNext[curRoot]]
    for e in belongSet[curRoot]:
        root[e]=nextRoot
        belongSet[nextRoot].append(e)
    belongSet[curRoot]=[]
    # print(root)
    # print(belongSet)
    # print()
print("\n".join(result))
    
