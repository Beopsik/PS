from sys import stdin

s=stdin.readline().rstrip()
result=set()
for i in range(1, len(s)+1):
    for j in range(len(s)):
        if j+i>len(s):
            break
        result.add(s[j:j+i])
print(len(result))
