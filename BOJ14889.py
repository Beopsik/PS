import itertools
from sys import stdin

n=int(stdin.readline())
board=[]
for i in range(n):
    board.append(list(map(int, stdin.readline().split())))

startList=list(itertools.combinations([i for i in range(n)], n//2))
Min=1000000000
for start in startList:
    startValue=0
    for s in list(itertools.permutations(start, 2)):
        startValue+=board[s[0]][s[1]]
    
    linkValue=0
    link=list(set([i for i in range(n)]).difference(set(start)))
    for l in list(itertools.permutations(link, 2)):
        linkValue+=board[l[0]][l[1]]
    
    Min=min(Min, abs(startValue-linkValue))
print(Min)
