import math
import decimal

num=float(input())
temp=math.sqrt(num)
result=math.ceil(temp)
if result**2<num:
    result+=1
print(result)
