switchNum=int(input())
switchList=list(map(str, input().split()))
studentNum=int(input())

for i in range(studentNum):
    s, num=input().split()
    s=int(s)
    num=int(num)
    if s==1:
        idx=num-1
        while True:
            if idx>=len(switchList):
                break
            if switchList[idx]=="0":
                switchList[idx]="1"
            else:
                switchList[idx]="0"
            idx+=num
    else:
        num-=1
        if switchList[num]=="0":
            switchList[num]="1"
        else:
            switchList[num]="0"

        left=num-1
        right=num+1
        while left>=0 and right<len(switchList):
            if switchList[left]!=switchList[right]:
                break
            else:
                if switchList[left]=="0":
                    switchList[left]="1"
                    switchList[right]="1"
                else:
                    switchList[left]="0"
                    switchList[right]="0"
                left-=1
                right+=1
result=""                
idx=0
while True:
    if idx+20>=len(switchList):
        temp=" ".join(switchList[idx:len(switchList)])
        result+=temp+"\n"        
        break
    temp=" ".join(switchList[idx:idx+20])
    result+=temp+"\n"        
    idx+=20
print(result)
