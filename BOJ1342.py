from string import ascii_lowercase
from sys import stdin

s=list(stdin.readline().rstrip())
n=len(s)
dic={}
for alpha in list(ascii_lowercase):
    count=s.count(alpha)
    if count>0:
        dic[alpha]=count

def dfs(alpha, length):
    if length>=n:
        # print(alpha, length)
        return 1
    
    # print(alpha, length)
    
    count=0
    for key in dic.keys():
        if key==alpha:
            continue

        if dic[key]>0:
            dic[key]-=1
            count+=dfs(key, length+1)
            dic[key]+=1
    
    return count

print(dfs("!", 0))
