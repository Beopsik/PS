from fractions import Fraction
from sys import stdin        

m=int(stdin.readline())
e=0
for i in range(m):
    n, s=map(int, stdin.readline().split())
    e+=Fraction(s, n)
reverse=pow(e.denominator, -1, 1000000007)
print((e.numerator*reverse)%1000000007)
