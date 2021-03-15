#include<cstdio>
#include<iostream>
#include<cstring>
#include<algorithm>

using namespace std;
char arr[20][20];
bool alpa[26];
int dx[4]={1, -1, 0, 0};
int dy[4]={0, 0, 1, -1};
int r, c;
int cnt;
int Max=1;
int end_flag;
string str;
int entlen;
void dfs(int y, int x)
{	
	int previous_len=str.length();
	for(int i=0; i<4; i++){
		if(previous_len!=str.length())
			str.erase(previous_len);
		if(y+dy[i]<r&&y+dy[i]>=0&&x+dx[i]<c&&x+dx[i]>=0){
			if(str.find(arr[y+dy[i]][x+dx[i]], 0)==string::npos){
				str+=arr[y+dy[i]][x+dx[i]];
				//cout<<str<<endl;
				int len=str.length();
				if(len==entlen){
					end_flag=1;
					Max=entlen;
					return;
				}
				Max=max(Max, len);
				dfs(y+dy[i], x+dx[i]);
			}
		}
		if(end_flag==1)
		return;
	}
}

int main(){
	
	scanf("%d %d",&r, &c);

	for(int i=0; i<r; i++){
		scanf("%s", arr[i]);
	}
	for(int i=0; i<r; i++){
		for(int j=0; j<c; j++){
			if(alpa[arr[i][j]-'A']==false){
				alpa[arr[i][j]-'A']=true;
				entlen++;
			}
		}
	}
	str+=arr[0][0];
	dfs(0, 0);
	printf("%d\n", Max);
	
	return 0;
}













