from collections import deque
from sys import stdin
input=stdin.readline 

n=int(input())
card=deque([i for i in range(1, n+1)])
while len(card)!=1:
    card.popleft()
    card.rotate(-1)
print(card.pop())
