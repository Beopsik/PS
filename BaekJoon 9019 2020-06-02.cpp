#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include <queue>
#include <vector>
using namespace std;

int arr[4];
int lt[4];
int rt[4];
int graph[10000][2];
bool c[10000];

int D(int n)
{
	n*=2;
	
	if(n>9999)
		n%=10000;
	
	return n;
}
int S(int n)
{
	if(n==0)
		n=9999;
	else
		n-=1;
	
	return n;
}
int L(int a[])
{
	int tmp;
	int result=0;
	
	tmp=a[0];
	for(int i=0; i<3; i++){
		a[i]=a[i+1];
	}
	a[3]=tmp;
	
	result=a[0]*1000+a[1]*100+a[2]*10+a[3];
	
	return result;
}
int R(int a[])
{
	int tmp;
	int result=0;
	
	tmp=a[3];
	for(int i=2; i>=0; i--){
		a[i+1]=a[i];
	}
	a[0]=tmp;
	
	result=a[0]*1000+a[1]*100+a[2]*10+a[3];
	
	return result;
}
int main() {

    int T;
	long long int num;
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
		
		int d, s ,l, r;
		
		memset(graph,0,sizeof(graph));
		fill_n(c, 10000, false);
		while(!q.empty()){
			q.pop();
		}
		
		q.push(pair<int, int>(cs[i][0], 0));
		c[cs[i][0]]=true;
		while(!q.empty()){
			pair<int, int> oprand=q.front();
			num=oprand.second+1;
			q.pop();
			
			if(oprand.first==cs[i][1]){
				char *ord=new char[num-1];
				int order=oprand.first;
				for(int i=num-2; i>=0; i--){
					if(graph[order][1]==0)
						ord[i]='D';
					else if(graph[order][1]==1)
						ord[i]='S';
					else if(graph[order][1]==2)
						ord[i]='L';
					else if(graph[order][1]==3)
						ord[i]='R';
					
					order=graph[order][0];
				}
				for(int i=0; i<num-1; i++){
					printf("%c", ord[i]);
				}
				printf("\n");
				break;
			}
			
			int temp=oprand.first;
			int div=1000;
			for(int j=0; j<4; j++){
				arr[j]=temp/div;
				lt[j]=arr[j];
				rt[j]=arr[j];
				temp%=div;
				div/=10;
			}
			
			d=D(oprand.first);
			if(c[d]==false){
				graph[d][0]=oprand.first;
				graph[d][1]=0;
				c[d]=true;
				q.push(pair<int, int>(d, num));
			}
			s=S(oprand.first);
			if(c[s]==false){
				graph[s][0]=oprand.first;
				graph[s][1]=1;
				c[s]=true;
				q.push(pair<int, int>(s, num));
			}
			l=L(lt);
			if(c[l]==false){
				graph[l][0]=oprand.first;
				graph[l][1]=2;
				c[l]=true;
				q.push(pair<int, int>(l, num));
			}
			r=R(rt);
			if(c[r]==false){
				graph[r][0]=oprand.first;
				graph[r][1]=3;
				c[r]=true;
				q.push(pair<int, int>(r, num));
			}
		}		
	}
	return 0;
}











