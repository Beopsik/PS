from sys import stdin        

n, m=map(int, stdin.readline().split())
memo={}
for i in range(n):
    site, password=map(str, stdin.readline().split())
    memo[site]=password

result=[]
for i in range(m):
    site=stdin.readline().rstrip()
    result.append(memo[site])

print("\n".join(result))

    
