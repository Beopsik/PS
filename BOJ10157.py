c, r=input().split()
c=int(c)
r=int(r)
pos=int(input())

table=[[0 for j in range(c)] for i in range(r)]

y=0
x=0
dirY=1
dirX=0
if pos>c*r:
    print(0)
else:
    for count in range(1, c*r+1):
        if count==pos:
            break
        table[y][x]=count

        if y+dirY<0 or y+dirY>=r or x+dirX<0 or x+dirX>=c or table[y+dirY][x+dirX]!=0:
            if dirY==1 and dirX==0:
                dirY=0
                dirX=1
            elif dirY==0 and dirX==1:
                dirY=-1
                dirX=0
            elif dirY==-1 and dirX==0:
                dirY=0
                dirX=-1
            elif dirY==0 and dirX==-1:
                dirY=1
                dirX=0
        y+=dirY
        x+=dirX

    print(x+1, y+1)  
