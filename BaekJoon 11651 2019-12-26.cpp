#include<cstdio>
#include<vector>
#include<algorithm>
#include<set>
#include<time.h>
#define inf 1000500000
using namespace std;
typedef struct pair<int, int> Pair;

int x[200005];
int y[200005];

void go(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = l + rand() % (r - l + 1);
	swap(x[l], x[p]);
	swap(y[l], y[p]);
	while (i < j) {
		do { i++; } while (y[l] > y[i]&&i<=r);
		do { j--; } while (y[l] < y[j]&&j>=l+1);
		if (i < j){
		    swap(x[i], x[j]);
		    swap(y[i], y[j]);
		}
	}
	swap(x[l], x[j]);
	swap(y[l], y[j]);
	go(l, j - 1);
	go(j + 1, r);
}
void go1(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = (l+r)/2;
	swap(x[l], x[p]);
	swap(y[l], y[p]);
	while (i < j) {
		do { i++; } while (x[l] > x[i]&&i<=r);
		do { j--; } while (x[l] < x[j]&&j>=l+1);
		if (i < j){
		    swap(x[i], x[j]);
		    swap(y[i], y[j]);
		}
	}
	swap(x[l], x[j]);
	swap(y[l], y[j]);
	go1(l, j - 1);
	go1(j + 1, r);
}

int main(void) {
    int t;
    
	srand(time(NULL));
	int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &x[i], &y[i]);
	}
	go(0, n - 1);
	for(int i=0; i<n; i=t+1)
	{
	    for(t=i; y[t]==y[t+1]&&t+1<n; t++)
	    {
	        //printf("%d\n", t);
	    }
	    //printf("%d\n", t);
	    go1(i,t);
	}
	//printf("-------------------\n");
	for (int i = 0; i < n; i++){
		printf("%d %d\n", x[i], y[i]);
	}
}




