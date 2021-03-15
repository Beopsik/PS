#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<map>
using namespace std;

int n, s, half;
int arr[40];
map<int, int> mp;
long long int caseNum;

void dfsLeft(int idx, int sum)
{
	if(idx==half){
		mp[sum]++;
		return;
	}
	dfsLeft(idx+1, sum);
	dfsLeft(idx+1, sum+arr[idx]);
}
void dfsRight(int idx, int sum)
{
	if(idx==n){
		caseNum+=mp[s-sum];
		return;
	}
	dfsRight(idx+1, sum);
	dfsRight(idx+1, sum+arr[idx]);
}
int main(){
	
	scanf("%d %d", &n, &s);
	half=n/2;
	
	for(int i=0; i<n; i++)
		scanf("%d", &arr[i]);
	
	dfsLeft(0, 0);
	dfsRight(half, 0);
	if(s==0)
		caseNum--;
	printf("%lld\n", caseNum);
	
	return 0;
}















