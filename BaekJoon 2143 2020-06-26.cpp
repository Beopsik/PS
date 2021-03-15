#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<map>
using namespace std;

int t, n, m;
int A[1000000];
int B[1000000];
int a[1000];
int b[1000];
int caseNum;

int main(){
	
	int A_len=0, B_len=0;
	
	scanf("%d", &t);
	
	scanf("%d", &n);
	for(int i=0; i<n; i++)
		scanf("%d", &a[i]);
	
	scanf("%d", &m);
	for(int i=0; i<m; i++)
		scanf("%d", &b[i]);
	
	for(int i=0; i<n; i++){
		int sum=0;
		for(int j=i; j<n; j++){
			sum+=a[j];
			A[A_len++]=sum;
		}
	}
	for(int i=0; i<m; i++){
		int sum=0;
		for(int j=i; j<m; j++){
			sum+=b[j];
			B[B_len++]=sum;
		}
	}
	sort(B, B+B_len);
	
	int left=0, right=B_len;
	long long ans=0;
	
	for(int i=0; i<A_len; i++){
		while(left<right){
			int mid=(left+right)/2;
			if(t-A[i]>B[mid])
				left=mid+1;
			else
				right=mid;
		}
		
		int lo=right;
		
		left=0, right=B_len;
		
		while(left<right){
			int mid=(left+right)/2;
			if(t-A[i]>=B[mid])
				left=mid+1;
			else
				right=mid;
		}
		int hi=right;
		ans+=(long long)(hi-lo);
		left=0; right=B_len;
	}
	
	printf("%lld\n", ans);
	
	return 0;
}
















