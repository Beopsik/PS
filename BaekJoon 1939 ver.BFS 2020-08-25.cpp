#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
int n, m, weight;
int start;
int finish;

bool bfs(bool check[], vector<pair<int, int>> graph[], int start, int weight)
{
    queue<int> q;
    q.push(start);
    check[start]=true;
    
    while(!q.empty()){
        int temp=q.front();
        q.pop();
        if(temp==finish)
			return true;
        for(int i=0; i<graph[temp].size(); i++){
			int next=graph[temp][i].first;
			int next_weight=graph[temp][i].second;
            if(check[next]==false&&weight<=next_weight){
                q.push(next);
                check[next]=true;
            }
        }
    }
	return false;
}
int main (){
	int Max=0;
	
	scanf("%d %d", &n, &m);

	vector<pair<int,int>> graph[n+1];
	bool check[n+1];
	
	for(int i=0; i<m; i++){
		int u,v;
		scanf("%d %d %d", &u, &v, &weight);
		Max=max(Max, weight);
		
		graph[u].push_back(make_pair(v, weight));
		graph[v].push_back(make_pair(u, weight));
	}
	scanf("%d %d", &start, &finish);
	
	for(int i=1; i<=n; i++){
		sort(graph[i].begin(), graph[i].end());
	}

	int low=1;
	int high=Max;
	int mid;
	bool ret;

	while(low<=high){
    	fill(check, check+n+1, false);
		mid=(low+high)/2;
		ret=bfs(check, graph, start, mid);
		if(ret){
			low=mid+1;
		}else{
			high=mid-1;
		}
	}

	printf("%d\n", high);
	
	return 0;
}

