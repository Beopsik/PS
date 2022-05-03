from itertools import combinations_with_replacement
n=int(input())
numList=[1, 5, 10, 50]
numSet=set()
for combList in list(combinations_with_replacement(numList, n)):
    numSet.add(sum(combList))
print(len(numSet))
