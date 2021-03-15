#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>

using namespace std;

int arr[10000];

int main() {
    
    int t;
	
	scanf("%d", &t);
	
	for(int c=0; c<t; c++){
		int n;
		int Min=10000;
		pair <int, int> answer;
		
		scanf("%d", &n);
		for(int i=2; i<=n; i++){
			arr[i]=i;
		}
		
		for(int i=2; i<=sqrt(n); i++){
			if(arr[i]==0)
				continue;
			for(int j=i+i; j<=n; j+=i){
				arr[j]=0;
			}
		}
		for(int i=2; i<=n; i++){
			if(arr[i]!=0&&arr[n-arr[i]]!=0){
				if(Min>abs((n-arr[i])-arr[i])){
					answer=make_pair(n-arr[i],arr[i]);
					Min=abs((n-arr[i])-arr[i]);
				}
			}
		}
		if(answer.first<answer.second)
			printf("%d %d\n", answer.first, answer.second);
		else
			printf("%d %d\n", answer.second, answer.first);
	}
	
	return 0;
}


















