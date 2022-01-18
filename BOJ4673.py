list=[i for i in range(10001)]

def d(num):
    result=num

    numStr=str(num)

    for i in numStr:
        result+=int(i)

    return result

for num in list:
    if num==0:
        continue
    ret=num
    while True:
        ret=d(ret)

        if ret>10000:
            break

        if list[ret]!=0:
            list[ret]=0


result="\n".join(str(e) for e in list if e!=0)
print(result)

