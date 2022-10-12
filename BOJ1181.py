from sys import stdin
input=stdin.readline 

class String:
    def __init__(self, string):
        self.string=string
    
    def __lt__(self, other):
        if len(self.string)==len(other.string):
            return self.string<other.string
        else:
            return len(self.string)<len(other.string)
    def __str__(self):
        return self.string

n=int(input())
tempSet=set()
for i in range(n):
    tempSet.add(input().rstrip())

wordList=[]
for e in tempSet:
    wordList.append(String(e))

wordList.sort()
print("\n".join(map(str, wordList)))
