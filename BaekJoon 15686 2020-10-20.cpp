#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<vector>

using namespace std;

const int MAX=50;
const int INF=987654321;

int city[50][50];
vector <pair<int, int>> house;
vector <pair<int, int>> chicken;
bool check[13];
int n, m, result;

int distance(pair<int, int> a, pair<int, int> b)
{
	return abs(a.first-b.first)+abs(a.second-b.second);
}
void dfs(int idx, int selected)
{
	if(selected==m){
		
		int tempResult=0;
		for(int i=0; i<house.size(); i++){
			int dist=INF;
			for(int j=0; j<chicken.size(); j++){
				if(check[j])
					dist=min(dist, distance(house[i], chicken[j]));
			}
			tempResult+=dist;
		}
		result=min(result, tempResult);
		return;
	}
	if(idx==chicken.size()){
		return;
	}
	
	check[idx]=true;
	dfs(idx+1, selected+1);
	check[idx]=false;
	dfs(idx+1, selected);
}
int main() {	
	
	scanf("%d %d", &n, &m);
	
	for(int i=0; i<n; i++){
		for(int j=0; j<n; j++){
			scanf("%d", &city[i][j]);
			if(city[i][j]==1)
				house.push_back(make_pair(i, j));
			else if(city[i][j]==2)
				chicken.push_back(make_pair(i, j));
		}
	}
	result=INF;
	dfs(0, 0);
	
	printf("%d\n", result);
	return 0;
}













