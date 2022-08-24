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
        intersect=(x3, y3) <= (x2, y2) and (x1, y1) <= (x4, y4)
        if intersect:
            if x1==x2 or x3==x4 or ((y2-y1)/(x2-x1))==((y4-y3)/(x4-x3)):
                if (x3, y3) == (x2, y2):
                    return (intersect, True, (x2, y2))
                elif (x1, y1) == (x4, y4):
                    return (intersect, True, (x1, y1))
                else:
                    return (intersect, False)
            else:
                return (intersect, True, intersectionPoint(x1, y1, x2, y2, x3, y3, x4, y4))        
        return (intersect, )
    intersect=l1<=0 and l2<=0
    if intersect:
        return (intersect, True, intersectionPoint(x1, y1, x2, y2, x3, y3, x4, y4))
    return (intersect, )
def intersectionPoint(x1, y1, x2, y2, x3, y3, x4, y4):
    if x1==x2:
        x=x1
        y=(y4-y3)/(x4-x3)*(x1-x3)+y3
        return (x, y)
    elif x3==x4:
        x=x3
        y=(y2-y1)/(x2-x1)*(x3-x1)+y1
        return (x, y)
    else:
        a1=(y2-y1)/(x2-x1)
        a2=(y4-y3)/(x4-x3)
    
        b1=-x1*(a1)+y1
        b2=-x3*(a2)+y3

        x=(-(b2-b1))/(a2-a1)
        y=a1*(x-x1)+y1
        return (x, y)
result=check(x1, y1, x2, y2, x3, y3, x4, y4)
if result[0]:
    print(1)
    if result[1]:
        print(*result[2])
else:
    print(0)
