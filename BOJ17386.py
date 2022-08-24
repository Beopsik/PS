from sys import stdin        
        
x1, y1, x2, y2=map(int, stdin.readline().split())
x3, y3, x4, y4=map(int, stdin.readline().split())

def ccw(x1, y1, x2, y2, x3, y3):
    op=x1*y2+x2*y3+x3*y1
    op-=(y1*x2+y2*x3+y3*x1)
    if op > 0:
        return 1
    elif op==0:
        return 0
    else:
        return -1

def check(x1, y1, x2, y2, x3, y3, x4, y4):
    l1=ccw(x1, y1, x2, y2, x3, y3)*ccw(x1, y1, x2, y2, x4, y4)
    l2=ccw(x3, y3, x4, y4, x1, y1)*ccw(x3, y3, x4, y4, x2, y2)
    if l1==0 and l2==0:
        if  (x1, y1) > (x2, y2):
            temp=x1
            x1=x2
            x2=temp

            temp=y1
            y1=y2
            y2=temp
        if  (x3, y3) > (x4, y4):
            temp=x3
            x3=x4
            x4=temp

            temp=y3
            y3=y4
            y4=temp
        return (x3, y3) <= (x2, y2) and (x1, y1) <= (x4, y4)
    return l1<=0 and l2<=0
if check(x1, y1, x2, y2, x3, y3, x4, y4):
    print(1)
else:
    print(0)
