n=int(input())

students=[]

def getBirth(birth):
    result=""
    result+=birth[2]
    if(int(birth[1])<10):
        result+="0"+birth[1]
    else:
        result+=birth[1]
    if(int(birth[0])<10):
        result+="0"+birth[0]
    else:
        result+=birth[0]    
    
    return result
    
for i in range(n):
    student=list(map(str, input().split()))
    birth=getBirth(student[1:])
    student=[student[0], birth]
    students.append(student)
students.sort(key=lambda student:(student[1]))

print(students[-1][0])
print(students[0][0])
