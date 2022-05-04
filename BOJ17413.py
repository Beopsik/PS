import re

s=input()
tag=re.compile('<[a-z\s]+>')
word=re.compile('[a-z0-9]+')

result=""
while len(s)!=0:
    if s[0]==' ':
        s=s[1:]
        result+=' '
        continue

    mWord=word.search(s)
    mWord.group()

    mTag=tag.search(s)
    if mTag==None:
        temp=s[mWord.start():mWord.end()]
        result+=temp[::-1]
        s=s[mWord.end():]
        continue
    mTag.group()

    if (mTag.start()<mWord.start() and mTag.end()>mWord.end()) or mTag.end()<=mWord.start():
        result+=s[mTag.start():mTag.end()]
        s=s[mTag.end():]
    else:
        temp=s[mWord.start():mWord.end()]
        result+=temp[::-1]
        s=s[mWord.end():]
print(result)

