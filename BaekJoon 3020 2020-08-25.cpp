#include <iostream>
#include <cstdio>
#include <algorithm>
#include <ctime>
#include <vector>

using namespace std;
vector<int> bottom(100000);
vector<int> top(100000);
int Min=200001;
int cnt=1;

void bianry(int n, int h)
{
	int temp;
	
	for(int i=1; i<=h; i++){
		temp=bottom.size()-(lower_bound(bottom.begin(), bottom.end(), i)-bottom.begin());
		temp+=top.size()-(upper_bound(top.begin(), top.end(), h-i)-top.begin());
		
		if(temp==Min){
			cnt++;
		}else if(Min>temp){
			Min=temp;
			cnt=1;
		}
	}
	
}

int main(void){
 
	int n, h;
	
	scanf("%d %d", &n, &h);
	for(int i=0; i<n/2; i++){
		scanf("%d %d", &bottom[i], &top[i]);
	}
	sort(bottom.begin(), bottom.end());
	sort(top.begin(), top.end());
	
	bianry(n, h);
	printf("%d %d\n", Min, cnt);
	
    return 0;
}

