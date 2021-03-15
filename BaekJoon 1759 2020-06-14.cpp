#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>

using namespace std;
int L, C;

void dfs(int position, string str, int mo, int ja, char pw[])
{
	if(str.size()==L){
		if(mo>=1&&ja>=2)
			cout<<str<<endl;
		return;
	}
	for(int i=position; i<C; i++){
		if(pw[i]=='a'||pw[i]=='e'||pw[i]=='i'||pw[i]=='o'||pw[i]=='u'){
			dfs(i+1, str+pw[i], mo+1, ja, pw);
		}else{
			dfs(i+1, str+pw[i], mo, ja+1, pw);
		}
	}
}
int main(){
	
	scanf("%d %d", &L, &C);
	char *pw=new char[C];
	for(int i=0; i<C; i++){
		scanf(" %c", &pw[i]);
	}
	sort(pw, pw+C);
	

	dfs(0,"",0,0, pw);
	
	return 0;
}













