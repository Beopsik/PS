#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

int N;
int pos[10001];
int neg[10001];

bool desc(int a, int b)
{ 
	return a > b; 
}

int main(void)
{
	int sum=0;
	int j=0, t=0;
	int num;
	int temp;
	
	scanf("%d", &N);
	
	for(int i=0; i<N; i++){
		scanf("%d", &num);
		if(num>0){
			pos[j]=num;
			j++;
		}else{
			neg[t]=num;
			t++;
		}
	}
	sort(pos, pos+j);
	sort(neg, neg+t, desc);
	
	for(int i=j-1; i-1>=0;){
		if(pos[i]>1&&pos[i-1]>1){
			sum+=pos[i]*pos[i-1];
			i-=2;
		}else{
			sum+=pos[i];
			i--;
		}
		temp=i;
	}
	if(temp==0)
		sum+=pos[temp];
	
	for(int i=t-1; i-1>=0;){
		sum+=neg[i]*neg[i-1];
		i-=2;
		temp=i;
	}
	if(temp==0)
		sum+=neg[temp];

	printf("%d\n", sum);
	
    return 0;
}

