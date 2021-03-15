#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;

int n, k;
int arr[10];
int cnt=0;
int di;

void Min(int n)
{
	for(int i=n-1; i>=0; i--)
	{
		if(k/arr[i]!=0){
			//printf("cnt: %d, arr[i]: %d, k:%d\n", cnt, arr[i], k);
			di=(k/arr[i]);
			cnt+=di;	
			k-=(di*arr[i]);
		}
		if(k==0)
			break;
	}
}
int main()
{
	scanf("%d %d",&n, &k);
	for (int i=0;i<n;i++){
		scanf("%d",&arr[i]);
	}
	Min(n);
	
	printf("%d\n", cnt);
	
	return 0;
}


