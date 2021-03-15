#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>

using namespace std;
int arr[100][100];
int test[100][100];
bool check[100][100];
int dx[4]={1, -1, 0, 0};
int dy[4]={0, 0, 1, -1};
int n;
int cnt;

void dfs(int y, int x)
{
	check[y][x]=true;
	test[y][x]=0;
	
	for(int i=0; i<4; i++){
		if(y+dy[i]<n&&y+dy[i]>=0&&x+dx[i]<n&&x+dx[i]>=0){
			if(test[y+dy[i]][x+dx[i]]>0&&check[y+dy[i]][x+dx[i]]==false){
				test[y+dy[i]][x+dx[i]]=0;
				dfs(y+dy[i], x+dx[i]);
			}
		}
	}
}
int main(){
	
	int Max=1;
	int safe=1;
	
	scanf("%d", &n);
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			scanf("%d", &arr[i][j]);
			Max=max(Max, arr[i][j]);
		}
	}
	
	for(int cs=0; cs<=Max; cs++){

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				test[i][j]=arr[i][j];
			}
		}
		memset(check, false, sizeof(check));
		cnt=0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				test[i][j]-=cs;
				if(test[i][j]<0)
					test[i][j]=0;
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(test[i][j]==0)
					continue;
				else{
					dfs(i, j);
					cnt++;
				}
			}
		}
		safe=max(safe, cnt);
	}
	printf("%d\n", safe);
	
	return 0;
}













