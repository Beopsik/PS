import itertools
from sys import stdin

n=int(stdin.readline())
ingredients=[]
for i in range(n):
    ingredients.append(tuple(map(int, stdin.readline().split())))

case=[i for i in range(n)]
Min=1000000000
for c in range(1, n+1):
    ingredientIdxs=list(itertools.combinations(case, c))

    for idxs in ingredientIdxs:
        s=1
        b=0
        for idx in idxs:
            s*=ingredients[idx][0]
            b+=ingredients[idx][1]
        Min=min(Min, abs(s-b))
print(Min)
