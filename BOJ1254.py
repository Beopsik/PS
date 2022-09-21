from sys import stdin

s=list(stdin.readline().rstrip())
reverseS=list(reversed(s))
for i in range(len(s)):
    check=True
    idx=i
    for j in range(len(reverseS)):
        if idx==len(s):
            break

        if s[idx]!=reverseS[j]:
            check=False
            break
        idx+=1
    
    if check:
        print(len(s[:i])+len(reverseS))
        break





