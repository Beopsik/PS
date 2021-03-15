#include <iostream>
#include <cstdio>
#include <algorithm>


using namespace std;
int coordi[200001];

int main(void){
 
	int N=0;
	int C=0;
	
	scanf("%d %d", &N, &C);
	
	for(int i=0; i<N; i++)
	{
		scanf("%d", &coordi[i]);
	}
	sort(coordi, coordi+N);
	
	int left=1;
	int right=coordi[N-1]-coordi[0];
	int d=0;
	int ans=0;
	
	while(left<=right){
		int mid=(left+right)/2;
		int start=coordi[0];
		int cnt=1;
		
		for(int i=1; i<N; i++){
			d=coordi[i]-start;
			if(mid<=d){
				++cnt;
				start=coordi[i];
			}
		}
		if(cnt>=C){
			ans=mid;
			left=mid+1;
		}else{
			right=mid-1;
		}
	}
	
	printf("%d\n", ans);
	
    return 0;
}


