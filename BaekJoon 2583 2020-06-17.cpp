#include<cstdio>
#include<iostream>
#include<cstring>
#include<algorithm>

using namespace std;
int arr[100][100];
bool check[100][100];
int area[10000];
int dx[4]={1, -1, 0, 0};
int dy[4]={0, 0, 1, -1};
int m, n, k;
int cnt;

void dfs(int y, int x)
{
	check[y][x]=true;
	arr[y][x]=1;
	
	for(int i=0; i<4; i++){
		if(y+dy[i]<m&&y+dy[i]>=0&&x+dx[i]<n&&x+dx[i]>=0){
			if(arr[y+dy[i]][x+dx[i]]==0&&check[y+dy[i]][x+dx[i]]==false){
				arr[y+dy[i]][x+dx[i]]=1;
				area[cnt]++;
				dfs(y+dy[i], x+dx[i]);
			}
		}
	}
}
int main(){
	
	scanf("%d %d %d", &m, &n, &k);
	int x1, y1, x2, y2;
	
	for(int i=0; i<k; i++){
		scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
		for(int y=y1; y<y2; y++){
			for(int x=x1; x<x2; x++){
				arr[y][x]=1;
			}
		}
	}
	
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			if(arr[i][j]==1)
				continue;
			else{
				dfs(i, j);
				cnt++;
			}
		}
	}
	sort(area, area+cnt);
	
	printf("%d\n", cnt);
	for(int i=0; i<cnt; i++){
		printf("%d ",area[i]+1);
	}
	printf("\n");
	
	return 0;
}













