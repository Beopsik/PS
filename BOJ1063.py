from re import S
from sys import stdin

inputStr=stdin.readline()
inputStr=inputStr.split()

king=inputStr[0]
stone=inputStr[1]
num=int(inputStr[2])

move=[]
for i in range(num):
    move.append(input())

for m in move:
    if m=="R":
        if ord(king[0])+1<=ord('H'):
            temp=chr(ord(king[0])+1)+king[1]
            if stone==temp:
                if ord(stone[0])+1<=ord('H'):
                    king=temp
                    stone=chr(ord(stone[0])+1)+stone[1]
            else:
                king=temp
    elif m=="L":
        if ord(king[0])-1>=ord('A'):
            temp=chr(ord(king[0])-1)+king[1]
            if stone==temp:
                if ord(stone[0])-1>=ord('A'):
                    king=temp
                    stone=chr(ord(stone[0])-1)+stone[1]
            else:
                king=temp
    elif m=="B":
        if int(king[1])-1>=1:
            temp=king[0]+str(int(king[1])-1)
            if stone==temp:
                if int(stone[1])-1>=1:
                    king=temp
                    stone=stone[0]+str(int(stone[1])-1)
            else:
                king=temp
    elif m=="T":
        if int(king[1])+1<=8:
            temp=king[0]+str(int(king[1])+1)
            if stone==temp:
                if int(stone[1])+1<=8:
                    king=temp
                    stone=stone[0]+str(int(stone[1])+1)
            else:
                king=temp
    elif m=="RT":
        if ord(king[0])+1<=ord('H') and int(king[1])+1<=8:
            temp=chr(ord(king[0])+1)+str(int(king[1])+1)
            if stone==temp:
                if ord(stone[0])+1<=ord('H') and int(stone[1])+1<=8:
                    king=temp
                    stone=chr(ord(stone[0])+1)+str(int(stone[1])+1)
            else:
                king=temp
    elif m=="LT":
        if ord(king[0])-1>=ord('A') and int(king[1])+1<=8:
            temp=chr(ord(king[0])-1)+str(int(king[1])+1)
            if stone==temp:
                if ord(stone[0])-1>=ord('A') and int(stone[1])+1<=8:
                    king=temp
                    stone=chr(ord(stone[0])-1)+str(int(stone[1])+1)
            else:
                king=temp
    elif m=="RB":
        if ord(king[0])+1<=ord('H') and int(king[1])-1>=1:
            temp=chr(ord(king[0])+1)+str(int(king[1])-1)
            if stone==temp:
                if ord(stone[0])+1<=ord('H') and int(stone[1])-1>=1:
                    king=temp
                    stone=chr(ord(stone[0])+1)+str(int(stone[1])-1)
            else:
                king=temp
    elif m=="LB":
        if ord(king[0])-1>=ord('A') and int(king[1])-1>=1:
            temp=chr(ord(king[0])-1)+str(int(king[1])-1)
            if stone==temp:
                if ord(stone[0])-1>=ord('A') and int(stone[1])-1>=1:
                    king=temp
                    stone=chr(ord(stone[0])-1)+str(int(stone[1])-1)
            else:
                king=temp

    
print(king)
print(stone)
    



    

    
    

