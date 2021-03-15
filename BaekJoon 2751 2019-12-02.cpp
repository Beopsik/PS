#include<cstdio>
#include<vector>
#include<algorithm>
#include<set>
#include<time.h>
#define inf 1000500000
using namespace std;
typedef struct pair<int, int> Pair;

int arr[1000005];

void go(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = l + rand() % (r - l + 1);
	swap(arr[l], arr[p]);
	while (i < j) {
		do { i++; } while (arr[l] > arr[i]&&i<=r);
		do { j--; } while (arr[l] < arr[j]&&j>=l+1);
		if (i < j) swap(arr[i], arr[j]);
	}
	swap(arr[l], arr[j]);
	go(l, j - 1);
	go(j + 1, r);
}

int main(void) {
	srand(time(NULL));
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	go(0, n - 1);
	for (int i = 0; i < n; i++)
		printf("%d\n", arr[i]);
}
