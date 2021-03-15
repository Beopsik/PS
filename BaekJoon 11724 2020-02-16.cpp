#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

void dfs(int start, vector<int> graph[], bool check[]){
	check[start]= true;

	for(int i=0; i < graph[start].size(); i++){
		int next = graph[start][i];
		if(check[next]==false){
			dfs(next, graph, check);
		}
	}
}
int main (){

	int n, m;
	int count=0;
	
	scanf("%d %d", &n, &m);

	vector<int> graph[n+1];
	bool check [n+1];
	fill(check, check+n+1, false);

	for(int i=0; i<m; i++){
		int u,v;
		scanf("%d %d", &u, &v);

		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	for(int i=1; i<=n; i++){
		sort(graph[i].begin(), graph[i].end());
	}
    
    for(int i=1; i<=n; i++)
    {
        if(check[i]==false)
        {
    	    dfs(i, graph, check);
    	    count++;
        }
    }
    
    printf("%d\n", count);

	return 0;
}












