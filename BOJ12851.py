from queue import PriorityQueue
from sys import stdin        

class Pair:
    def __init__(self, position, time):
        self.position=position
        self.time=time
    def __lt__(self, other):
        return self.time<other.time
    
n, k=map(int ,stdin.readline().split())

minLen=[1000000000 for i in range(100001)]
count=0
def bfs(start):
    global count
    q=PriorityQueue()

    q.put(Pair(start, 0))
    minLen[start]=0

    while not q.empty():
        cur=q.get()
        # print(cur.position, cur.time)
        if cur.position==k and minLen[k]==cur.time:
            count+=1
            continue

        nextPos1=cur.position-1
        nextPos2=cur.position+1
        nextPos3=cur.position*2
        nextTime=cur.time+1
        if nextTime<=minLen[k] and nextPos1>=0 and nextPos1<=100000 and minLen[nextPos1]>=nextTime:
            minLen[nextPos1]=nextTime
            q.put(Pair(nextPos1, nextTime))
        if nextTime<=minLen[k] and nextPos2>=0 and nextPos2<=100000 and minLen[nextPos2]>=nextTime:
            minLen[nextPos2]=nextTime
            q.put(Pair(nextPos2, nextTime))
        if nextTime<=minLen[k] and nextPos3>=0 and nextPos3<=100000 and minLen[nextPos3]>=nextTime:
            minLen[nextPos3]=nextTime
            q.put(Pair(nextPos3, nextTime))

bfs(n)
print(minLen[k])
print(count)
