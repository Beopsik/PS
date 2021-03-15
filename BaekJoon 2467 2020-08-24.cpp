#include <iostream>
#include <cstdio>
#include <algorithm>
#include <ctime>

using namespace std;
int solution[100000];
int l, r;
int Min=2000000001;

void bianry(int left, int right, int n)
{
	int temp;
	
	if(solution[left]<0&&solution[right]<0){
		l=right-1;
		r=right;
	}else if(solution[left]>=0&&solution[right]>=0){
		l=left;
		r=left+1;
	}else{
		while(left<right){
			int sum=0;
			sum=solution[left]+solution[right];
			temp=Min;
			Min=min(Min, abs(sum-0));
			if(Min!=temp){
				l=left;
				r=right;
			}
			if(sum<0){
				left++;
			}
			else if(sum>0){
				right--;
			}else{
				l=left;
				r=right;
				break;
			}
		}
	}
}

int main(void){
 
	int n;
    int result=0;
	
	scanf("%d", &n);
	for(int i=0; i<n; i++){
		scanf("%d", &solution[i]);
	}
	
	bianry(0, n-1, n);
	printf("%d %d\n", solution[l], solution[r]);
	
    return 0;
}

