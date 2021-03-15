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

	int n, m, c;
	
	
	scanf("%d", &c);
	
	for(int i=0; i<c; i++)
	{
    	int count=0;
    	scanf("%d", &n);
    
    	vector<int> graph[n+1];
    	bool check [n+1];
    	fill(check, check+n+1, false);
    
    	for(int i=1; i<=n; i++){
    		int u,v;
    		scanf("%d", &u);
    
    		graph[i].push_back(u);
    		graph[u].push_back(i);
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
	}

	return 0;
}













