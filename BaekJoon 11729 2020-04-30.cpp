#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;
int k=0;

void move(int from, int to)
{
	printf("%d %d\n", from, to);
}

void hanoi(int n, int from, int by, int to)
{
	if(n==1)
		move(from, to);
	else{
		hanoi(n-1, from, to, by);
		move(from, to);
		hanoi(n-1, by, from, to);
	}
}
int main(void){
	
	int n;
	long long int k;
	
	scanf("%d", &n);
	k=pow(2,n)-1;
	printf("%lld\n", k);
	hanoi(n, 1, 2, 3);
	
    return 0;
}


