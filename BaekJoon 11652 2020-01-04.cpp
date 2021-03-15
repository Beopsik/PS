#include<cstdio>
#include <iostream>
#include <algorithm>
using namespace std;

long long num[1000001];

void Card(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = l + rand() % (r - l + 1);
	swap(num[l], num[p]);
	while (i < j) {
		do { i++; } while (num[l] > num[i]&&i<=r);
		do { j--; } while (num[l] < num[j]&&j>=l+1);
		if (i < j){
		    swap(num[i], num[j]);
		}
	}
	swap(num[l], num[j]);
	Card(l, j - 1);
	Card(j + 1, r);
}

int main() {
    
	int n;
	
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%lld", &num[i]);
	}
	Card(0, n-1);
	
	long long ans = num[0];
	int ans_cnt = 1;
	int cnt = 1;
	
	for (int i = 1; i < n; i++) {
		if (num[i] == num[i - 1]) {
			cnt++;
		}
		else cnt = 1;
		if (ans_cnt < cnt) {
			ans_cnt = cnt;
			ans = num[i];
		}
	}
	printf("%lld\n", ans);
	
	return 0;
}


