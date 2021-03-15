#include<iostream>
#include<string> 
#include<cstdio> 
#include<vector> 
using namespace std; 
vector<int> getPi(string p)
{ 
	int m = (int)p.size(), j=0; 
	vector<int> pi(m, 0); 
	for(int i = 1; i< m ; i++){ 
		while(j > 0 && p[i] != p[j]) 
			j = pi[j-1]; 
		if(p[i] == p[j]) 
			pi[i] = ++j; 
	} 
	return pi; 
} 
int main()
{
	int n, m;
	int s_len;
	string s, p;
	int Max=0;
	
	cin>>s;
	s_len=s.length();
	
	for(int i=0; i<s_len; i++){
		p=s.substr(i, s_len);
		auto matched = getPi(p);
		int num=(int)matched.size();
		for(int t=0; t<num; t++){
			Max=max(Max, matched.at(t));
		}
	}
	printf("%d\n", Max);

}

