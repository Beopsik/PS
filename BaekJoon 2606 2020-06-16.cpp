#include<cstdio>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<queue>
#include<vector>

using namespace std;
int cnt;

void dfs(bool check[], int start, vector<int> graph[])
{
	check[start]=true;
	//printf("%d ", start);
	
	for(int i=0; i<graph[start].size(); i++){
		int next=graph[start][i];
		if(check[next]==false){
			cnt++;
			dfs(check, next, graph);
		}
	}
}
int main(){

	int n, e;
	
	scanf("%d", &n);
	scanf("%d", &e);
	
	vector<int>graph[n+1];
	bool check[n+1];
	fill(check, check+n+1, false);
	
	for(int i=0; i<e; i++){
		int node1, node2;
		
		scanf("%d %d", &node1, &node2);
		graph[node1].push_back(node2);
		graph[node2].push_back(node1);
	}
	for(int i=1; i<=n; i++){
        sort(graph[i].begin(), graph[i].end());
    }
	dfs(check, 1, graph);
	
	printf("%d\n", cnt);
	return 0;
}













