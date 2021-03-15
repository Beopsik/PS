#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<map>
using namespace std;

int n;
int ab[16000000];
int cd[16000000];
int a[4000];
int b[4000];
int c[4000];
int d[4000];
int caseNum;

int main(){
	
	scanf("%d", &n);
	
	int nn=n*n;
	for(int i=0; i<n; i++)
		scanf("%d %d %d %d", &a[i], &b[i], &c[i], &d[i]);
	
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			ab[n*i+j]=-(a[i]+b[j]);
			cd[n*i+j]=c[i]+d[j];
		}
	}
	sort(cd, cd+nn);
	
	int left=0, right=nn;
	long long ans=0;
	
	for(int i=0; i<nn; i++){
		while(left<right){
			int mid=(left+right)/2;
			if(ab[i]>cd[mid])
				left=mid+1;
			else
				right=mid;
		}
		
		int lo=right;
		
		left=0, right=nn;
		
		while(left<right){
			int mid=(left+right)/2;
			if(ab[i]>=cd[mid])
				left=mid+1;
			else
				right=mid;
		}
		int hi=right;
		ans+=(long long)(hi-lo);
		left=0; right=nn;
	}
	
	printf("%lld\n", ans);
	
	return 0;
}















