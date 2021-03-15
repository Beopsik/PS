#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;

int N,arr[500001];
int *arr2;
long long int cnt=0;

void merge(int left, int right)
{
	int mid = (left + right) / 2;

	int i = left;
	int j = mid + 1;
	int k = left;
	while (i <= mid && j <= right)
	{
		if (arr[i] <= arr[j]){//앞쪽 배열이 들어갈 경우에는 순서대로 넣으면 된다. swap이 되더라도 뒤쪽 배열에서 들어갈 경우에서 카운트 되기 때문
			arr2[k++] = arr[i++];
		}
		else{//뒤쪽 배열이 들어갈 때는 swap이 발생하는 경우이기 때문에 뒤쪽 배열의 인덱스와 swap된 경우의 배열의 인덱스 차이를 swap된 횟수로 카운트한다.
			cnt+=(j-k);
			arr2[k++] = arr[j++];
		}
	}

	int tmp = i>mid ? j : i;
	
	while(k<=right){
		arr2[k++] = arr[tmp++];
	}

	for (int i=left;i<=right;i++){
		arr[i] = arr2[i];
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
	scanf("%d",&N);
	arr2 = new int[N];
	for (int i=0;i<N;i++){
		scanf("%d",&arr[i]);
	}

	partition(0, N - 1);
	printf("%lld\n", cnt);
}

