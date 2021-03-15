#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>

using namespace std;
int n;
int arr[4000000];
int prime[4000000];
int primeLen;
int caseNum=0;

void Sum()
{
	int sum=0;
	int left=0, right=0;
	while(left<=right&&right<=primeLen){
		if(sum>=n){
			if(sum==n){
				caseNum++;
			}
			sum-=prime[left++];
		}else{
			if(right==primeLen)
				break;
			sum+=prime[right++];
		}
	}
}
void primeNum()
{
	for(int i=2; i<=n; i++)
		arr[i]=i;
	
	for(int i=2; i<=sqrt(n); i++){
		if(arr[i]==0)
			continue;
		for(int j=i+i; j<=n; j+=i)
			arr[j]=0;
	}
	int j=0;
	for (int i=2; i<=n; i++){
        if (arr[i]!=0){
			prime[j++]=arr[i];
		}
    }
	primeLen=j;
}
int main(){
	
	scanf("%d", &n);
	primeNum();
	Sum();
	
	printf("%d\n", caseNum);
	return 0;
}














