from sys import stdin        
import sys
limit_number = 15000000
sys.setrecursionlimit(limit_number)

n=int(stdin.readline())
star=[[' ' for i in range(n*2)] for j in range(n+1)]

def draw(y, x):
    star[y][x]='*'
    star[y+1][x-1]='*'
    star[y+1][x+1]='*'
    for i in range(3):
        star[y+2][x+i]='*'
        star[y+2][x-i]='*'
def recur(y, x, length):
    if length==1:
        draw(y, x)
        return
    
    y1=y
    x1=x
    y2=y+length
    x2=x-length
    y3=y+length
    x3=x+length
    
    recur(y1, x1, length//2)
    recur(y2, x2, length//2)
    recur(y3, x3, length//2)

recur(1, n, n//2)
result=""
for i in range(1, n+1):
    result+="".join(star[i][1:])
    result+="\n"
print(result)
