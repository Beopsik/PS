#include<cstdio>
#include<cstring>
#include<algorithm>
#include<time.h>
using namespace std;

int korean[100001];
int english[100001];
int math[100001];
char name[100001][11];

void Korean(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = l + rand() % (r - l + 1);
	swap(korean[l], korean[p]);
	swap(english[l], english[p]);
	swap(math[l], math[p]);
	swap(name[l], name[p]);
	while (i < j) {
		do { i++; } while (korean[l] < korean[i]&&i<=r);
		do { j--; } while (korean[l] > korean[j]&&j>=l+1);
		if (i < j){
		    swap(korean[i], korean[j]);
	        swap(english[i], english[j]);
	        swap(math[i], math[j]);
	        swap(name[i], name[j]);
		}
	}
	swap(korean[l], korean[j]);
	swap(english[l], english[j]);
	swap(math[l], math[j]);
	swap(name[l], name[j]);
	
	Korean(l, j - 1);
	Korean(j + 1, r);
}
void English(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = l + rand() % (r - l + 1);
	swap(korean[l], korean[p]);
	swap(english[l], english[p]);
	swap(math[l], math[p]);
	swap(name[l], name[p]);
	while (i < j) {
		do { i++; } while (english[l] > english[i]&&i<=r);
		do { j--; } while (english[l] < english[j]&&j>=l+1);
		if (i < j){
		    swap(korean[i], korean[j]);
	        swap(english[i], english[j]);
	        swap(math[i], math[j]);
	        swap(name[i], name[j]);
		}
	}
	swap(korean[l], korean[j]);
	swap(english[l], english[j]);
	swap(math[l], math[j]);
	swap(name[l], name[j]);
	
	English(l, j - 1);
	English(j + 1, r);
}
void Math(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = l + rand() % (r - l + 1);
	swap(korean[l], korean[p]);
	swap(english[l], english[p]);
	swap(math[l], math[p]);
	swap(name[l], name[p]);
	while (i < j) {
		do { i++; } while (math[l] < math[i]&&i<=r);
		do { j--; } while (math[l] > math[j]&&j>=l+1);
		if (i < j){
		    swap(korean[i], korean[j]);
	        swap(english[i], english[j]);
	        swap(math[i], math[j]);
	        swap(name[i], name[j]);
		}
	}
	swap(korean[l], korean[j]);
	swap(english[l], english[j]);
	swap(math[l], math[j]);
	swap(name[l], name[j]);
	
	Math(l, j - 1);
	Math(j + 1, r);
}
void Name(int l, int r) {
	if (r <= l) return;
	int i = l;
	int j = r+1;
	int p = l + rand() % (r - l + 1);
	swap(korean[l], korean[p]);
	swap(english[l], english[p]);
	swap(math[l], math[p]);
	swap(name[l], name[p]);
	while (i < j) {
		do { i++; } while (strcmp(name[l], name[i])>0&&i<=r);
		do { j--; } while (strcmp(name[l], name[j])<0&&j>=l+1);
		if (i < j){
		    swap(korean[i], korean[j]);
	        swap(english[i], english[j]);
	        swap(math[i], math[j]);
	        swap(name[i], name[j]);
		}
	}
	swap(korean[l], korean[j]);
	swap(english[l], english[j]);
	swap(math[l], math[j]);
	swap(name[l], name[j]);
	
	Name(l, j - 1);
	Name(j + 1, r);
}

int main(void) {
    
    srand(time(NULL));
    int t;
	int n;
	
	scanf("%d", &n);
	
	for (int i = 0; i < n; i++) {
	    scanf("%s", &name[i]);
		scanf("%d", &korean[i]);
		scanf("%d", &english[i]);
		scanf("%d", &math[i]);
	}
	Korean(0, n - 1);
	for(int i=0; i<n; i=t+1)
	{
	    for(t=i; korean[t]==korean[t+1]&&t+1<n; t++)
	    {
	    }
	        English(i,t);
	}
	for(int i=0; i<n; i=t+1)
	{
	    for(t=i; korean[t]==korean[t+1]&&english[t]==english[t+1]&&t+1<n; t++)
	    {
	    }
	        Math(i,t);
	}
	for(int i=0; i<n; i=t+1)
	{
	    for(t=i; korean[t]==korean[t+1]&&english[t]==english[t+1]&&math[t]==math[t+1]&&t+1<n; t++)
	    {
	    }
	        Name(i,t);
	}
	for (int i = 0; i < n; i++){
		printf("%s\n", name[i]);
	}
}









