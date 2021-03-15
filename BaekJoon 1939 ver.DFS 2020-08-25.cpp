#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
int n, m, weight;
int start;
int finish;
bool ret;
bool dfs(bool check[], int start, vector<pair<int,int>> graph[], int weight){
	if(start==finish){
		return true;
	}
	for(int i=0; i < graph[start].size(); i++){
		pair<int, int> temp=graph[start][i];
		int next=temp.first;
		int next_weight=temp.second;
		if(check[next]==false&&weight<=next_weight){
			check[next]=true;
			ret=dfs(check, next, graph, weight);
			if(ret==true)
				return ret;
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
	int ans;
	while(low<=high){
		ret=false;
    	fill(check, check+n+1, false);
		mid=(low+high)/2;
		check[start]=true;
		ret=dfs(check, start, graph, mid);
		if(ret){
			low=mid+1;
		}else{
			high=mid-1;
		}
	}

	printf("%d\n", high);
	
	return 0;
}

