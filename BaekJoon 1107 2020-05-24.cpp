#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>
#include <cmath>
#include <cstdlib>

using namespace std;

int N, M;
int trouble;
int res;
int press;
int len;
int button[10]={0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

int check(int c)
{
	press=0;
	len=0;
	
	while(true){
		if(button[c%10]==-1)
			return -1;
		else{
			press++;
			c/=10;
		}
		
		if(c==0)
			break;
	}
	return press;
}
int main(void)
{
	
	scanf("%d", &N);
	scanf("%d", &M);
	for(int i=0; i<M; i++){
		scanf("%d", &trouble);
		button[trouble]=-1;
	}
	res=abs(N-100);
	
	for(int i=0; i<=1000000; i++)
	{
		press=check(i);
		
		if(press!=-1){
			res=min(res, abs(N-i)+press);
		}
	}
	
	printf("%d\n", res);
	
    return 0;
}







