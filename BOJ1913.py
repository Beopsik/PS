num=int(input())
pos=input()

table=[[0 for j in range(num)] for i in range(num)]

y=0
x=0
dirY=1
dirX=0
for count in range(num*num, 0, -1):
    table[y][x]=str(count)

    if y+dirY<0 or y+dirY>=num or x+dirX<0 or x+dirX>=num or table[y+dirY][x+dirX]!=0:
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
    
resY=0
resX=0    
resStr=""
for list in table:
    resStr+=" ".join(list)+"\n"
    if pos in list:
        resX=list.index(pos)
        resY=table.index(list)

print(resStr, end="")
print(resY+1, resX+1)
