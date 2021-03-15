#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

char n[1000001];
int N[100001];
int arr[100001];

void merge(int left, int right)
{
	int mid = (left + right) / 2;

	int i = left;
	int j = mid + 1;
	int k = left;
	while (i <= mid && j <= right)
	{
		if (N[i] <= N[j]){
			arr[k++] = N[i++];
		}
		else{
			arr[k++] = N[j++];
		}
	}

	int tmp = i>mid ? j : i;
	
	while(k<=right){
		arr[k++] = N[tmp++];
	}

	for (int i=left;i<=right;i++){
		N[i] = arr[i];
	}
}

void partition(int left,int right)
{
	int mid;
	if (left < right)
	{
		mid = (left + right) / 2; 
		partition(left, mid);
		partition(mid + 1, right);
		merge(left, right);
	}
}

int main()
{
	int num;
	int cnt;
	int zero_num=0;
	long long int sum=0;
	
	scanf("%s", n);
	cnt=strlen(n)-1;
	for(int i=cnt; i>=0; i--){
		N[i]=n[cnt-i]-'0';
		sum+=N[i];
		if(N[i]==0)
			zero_num++;
	}
	
	if(zero_num==0||sum%3!=0){
		printf("%d\n", -1);
	}
	else{
		partition(0, cnt);
		for(int i=cnt; i>=0; i--){
			printf("%d", N[i]);
		}
		printf("\n");
	}
	
	return 0;
}

