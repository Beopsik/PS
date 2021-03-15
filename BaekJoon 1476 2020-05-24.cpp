#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

int main(void)
{
	int E, S, M;
	int e=15, s=28, m=19;
	int Enum=0, Snum=0, Mnum=0;
	int year=1;
	
	scanf("%d %d %d", &E, &S, &M);
	
	while(true){
		Enum=year%e;
		Snum=year%s;
		Mnum=year%m;
		
		if(Enum==0)
			Enum=15;
		if(Snum==0)
			Snum=28;
		if(Mnum==0)
			Mnum=19;
		
		if(Enum==E&&Snum==S&&Mnum==M)
			break;
		year++;
	}
	
	printf("%d\n", year);
	
	
    return 0;
}

