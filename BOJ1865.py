from sys import stdin

def bellman_ford(start):
    minLen[start]=0

    for i in range(n):
        for j in range(len(edge)):
            cur=edge[j][0]
            next=edge[j][1]
            time=edge[j][2]
            if minLen[next]>minLen[cur]+time:
                minLen[next]=minLen[cur]+time
                if i==n-1:
                    return True
    return False

tc=int(stdin.readline())
for i in range(tc):
    n, m, w=map(int, stdin.readline().split())
    edge=[]
    for j in range(m):
        s, e, t=map(int, stdin.readline().split())
        edge.append((s, e, t))
        edge.append((e, s, t))
    for j in range(w):
        s, e, t=map(int, stdin.readline().split())
        edge.append((s, e, -t))

    minLen=[1000000000 for i in range(n+1)]
    cycle=bellman_ford(1)
    print(*minLen[1:])
    if not cycle:
        print("NO")
    else:
        print("YES")
