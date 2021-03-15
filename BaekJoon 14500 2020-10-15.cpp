#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>

using namespace std;
int dy[4]={0, 0, -1, 1};
int dx[4]={1, -1, 0 , 0};
int dy1[4][3]={{-1, 0, 1}, {0, 1, 0}, {-1, 0, 1}, {0, -1, 0}};
int dx1[4][3]={{0, -1, 0}, {-1, 0, 1}, {0, 1, 0}, {-1, 0, 1}};
int board[500][500];
bool check[500][500];
int Max=0;
int n, m;
void dfs(int y, int x, int count, int sum)
{
	
	if(count>=4){
		Max=max(Max, sum);
		return;
	}
	sum+=board[y][x];
	count++;
	for(int t=0; t<4; t++){
		if(y+dy[t]>=0&&y+dy[t]<n&&x+dx[t]>=0&&x+dx[t]<m&&check[y+dy[t]][x+dx[t]]==false){
			check[y+dy[t]][x+dx[t]]=true;
			dfs(y+dy[t], x+dx[t], count, sum);
			check[y+dy[t]][x+dx[t]]=false;
		}
	}
}
int main() {	
	
	scanf("%d %d", &n, &m);
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			scanf("%d", &board[i][j]);
		}
	}
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			for(int t=0; t<4; t++){
				int sum=board[i][j];
				for(int s=0; s<3; s++){
					if(i+dy1[t][s]<0||i+dy1[t][s]>=n||j+dx1[t][s]<0||j+dx1[t][s]>=m){
						sum=board[i][j];
						break;
					}
					sum+=board[i+dy1[t][s]][j+dx1[t][s]];
				}
				Max=max(Max, sum);
			}
		}
	}
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			check[i][j]=true;
			dfs(i, j, 0, 0);
			check[i][j]=false;
		}
	}
	
	printf("%d\n", Max);
	return 0;
}













