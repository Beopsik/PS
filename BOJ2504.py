from sys import stdin

bracket=stdin.readline().rstrip()

if len(bracket)%2!=0:
    print(0)
else:
    squareCount=0
    basicCount=0
    if bracket[0]=='(':
        basicCount+=1
    elif bracket[0]=='[':
        squareCount+=1

    for i in range(1, len(bracket)):
        if bracket[i]=='(':
            basicCount+=1
        elif bracket[i]==")":
            basicCount-=1
            if basicCount<0 or bracket[i-1]=='[':
                break
        elif bracket[i]=='[':
            squareCount+=1
        elif bracket[i]==']':
            squareCount-=1
            if squareCount<0 or bracket[i-1]=='(':
                break

    if basicCount!=0 or squareCount !=0:
        print(0)
    else:
        result=""
        if bracket[0]=='(':
            result+='2*('
        elif bracket[0]=='[':
            result+='3*('

        for i in range(1, len(bracket)):
            if (bracket[i-1]=='(' or bracket[i-1]=='[') and bracket[i]=='(':
                result+='2*('
            elif (bracket[i-1]==')' or bracket[i-1]==']') and bracket[i]=='(':
                result+='+2*('
            elif (bracket[i-1]=='(' or bracket[i-1]=='[') and bracket[i]=='[':
                result+='3*('
            elif (bracket[i-1]==')' or bracket[i-1]==']') and bracket[i]=='[':
                result+='+3*('
            elif (bracket[i-1]=='(' or bracket[i-1]=='[') and (bracket[i]==')' or bracket[i]==']'):
                result+='1)'
            elif (bracket[i-1]==')' or bracket[i-1]==']') and (bracket[i]==')' or bracket[i]==']'):
                result+=')'
        print(eval(result))

