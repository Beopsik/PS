#include<cstdio>
#include <iostream>
#include <algorithm>
using namespace std;

int num[5000001];

void Up(int l, int r) {
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
	Up(l, j - 1);
	Up(j + 1, r);
}

int main() {
    
	int n;
	int s;
	
	scanf("%d %d", &n, &s);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num[i]);
	}
	Up(0, n-1);
	
	printf("%d\n", num[s-1]);
	
	return 0;
}


