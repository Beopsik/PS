from sys import stdin

T=int(stdin.readline())
for i in range(T):
    y=0
    x=0
    dY=-1
    dX=0
    move=stdin.readline().rstrip()
    area=set()
    area.add((y, x))
    for control in move:
        if control=="F":
            y+=dY
            x+=dX
            area.add((y, x))
        elif control=="B":
            y-=dY
            x-=dX
            area.add((y, x))
        elif control=="L":
            temp=dY
            dY=-dX
            dX=temp
        elif control=="R":
            temp=dY
            dY=dX
            dX=-temp
    area=list(area)
    top=501
    bottom=-501
    left=501
    right=-501
    for point in area:
        top=min(top, point[0])
        bottom=max(bottom, point[0])
        left=min(left, point[1])
        right=max(right, point[1])
    print((bottom-top)*(right-left))



