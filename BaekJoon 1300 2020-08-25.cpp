#include <iostream>
#include <cstdio>
#include <algorithm>
#include <ctime>
#include <map>

using namespace std;
int result;
int cnt;

void bianry(int n, int k)
{
	int left=1;
	int right=k;
	
	while(left<=right){
		int cnt=0;
		int mid=(left+right)/2;
		
		for(int i=1; i<=n; i++){
			cnt+=min(mid/i, n);
		}
		if(cnt<k){
			left=mid+1;
		}else{
			result=mid;
			right=mid-1;
		}
	}
}

int main(void){
 
	int n, k;
	
	scanf("%d", &n);
	scanf("%d", &k);
	
	bianry(n, k);
	printf("%d\n", result);
	
    return 0;
}

