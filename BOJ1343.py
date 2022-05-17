board=input()

if board.count('X')%2!=0:
    print(-1)
else:
    while 'XXXX' in board:
        board=board.replace('XXXX', 'AAAA')
    while 'XX' in board:
        board=board.replace('XX', 'BB')
    
    if 'X' in board:
        print(-1)
    else:
        print(board)

