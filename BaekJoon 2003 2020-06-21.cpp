#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>

using namespace std;
int n, m;
int arr[10000];
int caseNum;

void Sum()
{
	int s=0;
	int left=0, right=0;
	while(left<=right&&right<=n){
		if(s>=m){
			if(s==m)
				caseNum++;
			s-=arr[left++];
		}else{
			if(right==n)
				break;
			s+=arr[right++];
		}
	}
}
int main(){
	
	scanf("%d %d", &n, &m);
	for(int i=0; i<n; i++)
		scanf("%d", &arr[i]);
	
	Sum();
	
	printf("%d\n", caseNum);
	return 0;
}















