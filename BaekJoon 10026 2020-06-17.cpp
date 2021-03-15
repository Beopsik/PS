#include<cstdio>
#include<iostream>
#include<cstring>
#include<algorithm>

using namespace std;
char arr[100][100];
char test[100][100];
bool check[100][100];
int dx[4]={1, -1, 0, 0};
int dy[4]={0, 0, 1, -1};
int n;
int cnt;

void dfs(int y, int x, char color)
{
	check[y][x]=true;
	test[y][x]=0;
	
	for(int i=0; i<4; i++){
		if(y+dy[i]<n&&y+dy[i]>=0&&x+dx[i]<n&&x+dx[i]>=0){
			if(test[y+dy[i]][x+dx[i]]==color&&check[y+dy[i]][x+dx[i]]==false){
				test[y+dy[i]][x+dx[i]]=0;
				dfs(y+dy[i], x+dx[i], color);
			}
		}
	}
}

int main(){
	
	scanf("%d",&n);

	for(int i=0; i<n; i++){
		scanf("%s", arr[i]);
	}
	
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++)
			test[i][j]=arr[i][j];
	}
	memset(check, false, sizeof(check));
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			if(test[i][j]==0)
				continue;
			else{
				dfs(i, j, test[i][j]);
				cnt++;
			}
		}
	}
	printf("%d\n", cnt);
	
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			if(arr[i][j]=='G')
				test[i][j]='R';
			else
				test[i][j]=arr[i][j];
		}
	}
	memset(check, false, sizeof(check));
	cnt=0;
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			if(test[i][j]==0)
				continue;
			else{
				dfs(i, j, test[i][j]);
				cnt++;
			}
		}
	}
	printf("%d\n", cnt);
	
	return 0;
}













