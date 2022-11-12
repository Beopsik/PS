from sys import stdin        
input=stdin.readline 

N=8
d=int(input())

count={}
count[1]=[
    [0, 1, 0, 0, 0, 0, 0, 1],
    [1, 0, 1, 0, 0, 0, 0, 1],
    [0, 1, 0, 1, 0, 0, 1, 1],
    [0, 0, 1, 0, 1, 0, 1, 0],
    [0, 0, 0, 1, 0, 1, 0, 0],
    [0, 0, 0, 0, 1, 0, 1, 0],
    [0, 0, 1, 1, 0, 1, 0, 1],
    [1, 1, 1, 0, 0, 0, 1, 0],
]

def devide(d, From, To):
    if d<=1:
        return count[d][From][To]

    count.setdefault(d, [[0 for _ in range(N)] for _ in range(N)])
    if count[d][From][To]:
        return count[d][From][To]
    
    half=d//2
    other=half+1 if d%2 else half

    for mid in range(N):
        count[d][From][To]+=devide(half, From, mid)*devide(other, mid, To)
        count[d][From][To]%=1000000007
    
    return count[d][From][To]

print(devide(d, 0, 0))
