#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>

using namespace std;
int arr[50][50];
bool check[50][50];
int dx[4]={1, -1, 0, 0};
int dy[4]={0, 0, 1, -1};
int t, m, n, k;
int cnt;
void dfs(int y, int x)
{
	check[y][x]=true;
	arr[y][x]=0;
	
	for(int i=0; i<4; i++){
		if(y+dy[i]<n&&y+dy[i]>=0&&x+dx[i]<m&&x+dx[i]>=0){
			if(arr[y+dy[i]][x+dx[i]]==1&&check[y+dy[i]][x+dx[i]]==false){
				arr[y+dy[i]][x+dx[i]]=0;
				dfs(y+dy[i], x+dx[i]);
			}
		}
	}
}
int main(){
	
	scanf("%d", &t);
	
	for(int i=0; i<t; i++){
		memset(arr, 0, sizeof(arr));
		memset(check, false, sizeof(check));
		cnt=0;
		scanf("%d %d %d", &m, &n, &k);

		for(int j=0; j<k; j++){
			int x, y;
			
			scanf("%d %d", &x, &y);
			arr[y][x]=1;
		}
		for(int sero=0; sero<n; sero++){
			for(int garo=0; garo<m; garo++){
				if(arr[sero][garo]==0)
					continue;
				else{
					dfs(sero, garo);
					cnt++;
				}
			}
		}
		printf("%d\n", cnt);
	}
	return 0;
}













