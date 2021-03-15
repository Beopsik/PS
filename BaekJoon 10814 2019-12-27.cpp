#include<cstdio>
#include<string>
#include<algorithm>
#include<time.h>
using namespace std;

int age[100001];
char name[100001][101];
int order[100001];

void go(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = l + rand() % (r - l + 1);
	swap(age[l], age[p]);
	swap(name[l], name[p]);
	swap(order[l], order[p]);
	while (i < j) {
		do { i++; } while (age[l] > age[i]&&i<=r);
		do { j--; } while (age[l] < age[j]&&j>=l+1);
		if (i < j){
		    swap(age[i], age[j]);
		    swap(name[i], name[j]);
		    swap(order[i], order[j]);
		}
	}
	swap(age[l], age[j]);
    swap(name[l], name[j]);
	swap(order[l], order[j]);
	
	go(l, j - 1);
	go(j + 1, r);
}
void go1(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = l + rand() % (r - l + 1);
	swap(age[l], age[p]);
	swap(name[l], name[p]);
	swap(order[l], order[p]);
	while (i < j) {
		do { i++; } while (order[l] > order[i]&&i<=r);
		do { j--; } while (order[l] < order[j]&&j>=l+1);
		if (i < j){
		    swap(age[i], age[j]);
		    swap(name[i], name[j]);
		    swap(order[i], order[j]);
		}
	}
	swap(age[l], age[j]);
    swap(name[l], name[j]);
	swap(order[l], order[j]);
	
	go1(l, j - 1);
	go1(j + 1, r);
}

int main(void) {
    
    srand(time(NULL));
    int t;
	int n;
	
	scanf("%d", &n);
	
	for (int i = 0; i < n; i++) {
		scanf("%d", &age[i]);
		scanf("%s", &name[i]);
		order[i]=i;
	}
	go(0, n - 1);
	for(int i=0; i<n; i=t+1)
	{
	    for(t=i; age[t]==age[t+1]&&t+1<n; t++)
	    {
	    }
	    go1(i,t);
	}
	for (int i = 0; i < n; i++){
		printf("%d %s\n", age[i], name[i]);
	}
}





