woodPiece=list(map(int, input().split()))

while True:
    finish=True
    for i in range(4):
        if(woodPiece[i]>woodPiece[i+1]):
            temp=woodPiece[i]
            woodPiece[i]=woodPiece[i+1]
            woodPiece[i+1]=temp
            for e in woodPiece:
                print(e, end=" ")
            print()
            finish=False

    if finish:
        break
    
