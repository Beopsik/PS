from sys import stdin

romaNumValue={"I": 1, "V":5, "X":10, "L":50, "C":100, "D":500, "M": 1000, "IV": 4, "IL":9, "XL":40, "XC":90, "CD":400, "CM":900}
romaNumList=romaNumValue.keys()
num1=stdin.readline().rstrip()
num2=stdin.readline().rstrip()

def toArabic(num: str):
    result=0
    
    result+=num.count("IV")*4
    num=num.replace("IV", "")
    
    result+=num.count("IX")*9
    num=num.replace("IX", "")
    
    result+=num.count("XL")*40
    num=num.replace("XL", "")

    result+=num.count("XC")*90
    num=num.replace("XC", "")
    
    result+=num.count("CD")*400
    num=num.replace("CD", "")
    
    result+=num.count("CM")*900
    num=num.replace("CM", "")
    

    result+=num.count("I")*1
    num=num.replace("I", "")
    
    result+=num.count("V")*5
    num=num.replace("V", "")
    
    result+=num.count("X")*10
    num=num.replace("X", "")
    
    result+=num.count("L")*50
    num=num.replace("L", "")
    
    result+=num.count("C")*100
    num=num.replace("C", "")
    
    result+=num.count("D")*500
    num=num.replace("D", "")
    
    result+=num.count("M")*1000
    num=num.replace("M", "")
    
    return result

def toRoman(num):
    result=""

    if num//1000!=0:
        temp=num//1000
        if temp<=3:
            result+="M"*(temp)
            num%=1000
        else:
            result+="M"*3
            num-=3000
    if num//900!=0:
        result+="CM"*(num//900)
        num%=900
    if num//500!=0:
        result+="D"*1
        num-=500
    if num//400!=0:
        result+="CD"*(num//400)
        num%=400
    if num//100!=0:
        temp=num//100
        if temp<=3:
            result+="C"*(num//100)
            num%=100
        else:
            result+="C"*3
            num-=300
    if num//90!=0:
        result+="XC"*(num//90)
        num%=90
    if num//50!=0:
        result+="L"*1
        num-=50
    if num//40!=0:
        result+="XL"*(num//40)
        num%=40
    if num//10!=0:
        temp=num//10
        if temp<=3:
            result+="X"*(temp)
            num%=10
        else:
            result+="X"*3
            num-=30
    if num//9!=0:
        result+="IX"*(num//9)
        num%=9
    if num//5!=0:
        result+="V"*1
        num-=5
    if num//4!=0:
        result+="IV"*(num//4)
        num%=4
    if num//1!=0:
        temp=num//1
        if temp<=3:
            result+="I"*(temp)
            num%=1
        else:
            result+="I"*3
            num-=3

    return result

result=toArabic(num1)+toArabic(num2)
print(result)
print(toRoman(result))
