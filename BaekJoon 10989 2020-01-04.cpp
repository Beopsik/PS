#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;

short n[10001];

int main(void) {
    
    short t;
	int N;
	
	scanf("%d", &N);
	
	for (int i = 0; i < N; i++) {
	    scanf("%hd", &t);
	    n[t]++;
	}
	
	for (short i = 0; i < 10001; i++){
	    if(n[i]!=0)
	    {
	        for(int s=0; s<n[i]; s++)
		    printf("%hd\n", i);
	    }
	}
}









