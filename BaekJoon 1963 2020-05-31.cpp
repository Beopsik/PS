#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include <queue>
using namespace std;

int arr[4];
bool c[10000];

int check(int n){
	if(n==1)
        return -1;
            
    for(int i=2; i<=sqrt(n); i++){
        if(n%i==0)
            return -1;
    }
	return 1;
}

int main() {

    int T;
	int num;
	queue<pair<int,int>> q;
	
	scanf("%d", &T);
	int **cs=new int*[T];
	for(int i=0; i<T; i++){
		cs[i]=new int[2];
	}
	for(int i=0; i<T; i++){
		for(int j=0; j<2; j++){
			scanf("%d", &cs[i][j]);
		}
	}    

	for(int i=0; i<T; i++){
		
		int prime;
		
		if(check(cs[i][0])==-1||check(cs[i][1])==-1)
			printf("Impossible\n");
		
		fill_n(c, 10000, false);
		while(!q.empty()){
			q.pop();
		}
		
		q.push(pair<int, int>(cs[i][0], 0));
		c[cs[i][0]]=true;
		while(!q.empty())
		{
			pair<int, int> temp=q.front();
			num=temp.second+1;
			q.pop();
			int div=1000;
			
			if(temp.first==cs[i][1]){
				printf("%d\n", temp.second);
				break;
			}
			for(int j=3; j>=0; j--){
				arr[j]=temp.first/div;
				temp.first%=div;
				div/=10;
			}

			for(int j=0; j<3; j++){
				int tmp=arr[j];
				for(int t=0; t<10; t++){
					arr[j]=t;
					prime=arr[3]*1000+arr[2]*100+arr[1]*10+arr[0];
					if(check(prime)==1&&c[prime]==false){
						c[prime]=true;
						q.push(pair<int, int>(prime, num));
					}
				}
				arr[j]=tmp;
			}
			for(int t=1; t<10; t++){
				int tmp=arr[3];
				arr[3]=t;
				prime=arr[3]*1000+arr[2]*100+arr[1]*10+arr[0];
				if(check(prime)==1&&c[prime]==false){
					c[prime]=true;
					q.push(pair<int, int>(prime, num));
				}
				arr[3]=tmp;
			}
		}
	}
	return 0;
}











