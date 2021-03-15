#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>

using namespace std;

int n;
int paper[128][128];
int color[2];

int check(int x, int y, int len)
{
	int start=paper[y][x];
	bool ok=true;
	
	for(int i=0; i<len; i++){
		for(int j=0; j<len; j++){
			if(start!=paper[y+i][x+j]){
				ok=false;
				break;
			}
		}
		if(ok==false)
			break;
	}
	
	return ok;
}
void cut(int x, int y, int len)
{
	if(len==0)
		return;
	
	if(check(x, y, len)){
		color[paper[y][x]]++;
	}else{
		len/=2;
		cut(x, y, len);
		cut(x+len, y, len);
		cut(x+len, y+len, len);
		cut(x, y+len, len);
	}
}
int main() {
	
	scanf("%d", &n);
	
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++)
			scanf("%d", &paper[i][j]);
	}
	cut(0, 0, n);
	
	printf("%d\n", color[0]);
	printf("%d\n", color[1]);
	
	return 0;
}













