#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;

int n, m, k;

void Max()
{
	int woman=n, man=m;
	int team=0;
	int tmp;
	
	for(int i=0; i<=k; i++){
		tmp=min((woman-i)/2,(man-k+i));
		team=max(team, tmp);
	}
	printf("%d\n", team);
	
}
int main()
{
	scanf("%d %d %d",&n, &m, &k);
	
	Max();
	
	return 0;
}

