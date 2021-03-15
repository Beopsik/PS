#include<iostream>
#include<algorithm>
#include<cstring>
#include <vector>
using namespace std;

int main(void)
{
	string p;
	string s;
	int n, m;
	int index=-1;
	int cnt=0;
	
	scanf("%d", &n);
	scanf("%d", &m);
	cin>>s;
	
	for(int i=0; i<n; i++){
		p.push_back('I');
		p.push_back('O');
	}
	p.push_back('I');
	
	for(int i=0; i<m;){
		int temp;
		temp=index;
		
		index=s.find(p, i);
		if(index==string::npos)
			break;
		if(index!=temp){
			cnt++;
			i=index+2;
		}
	}
	
	printf("%d\n", cnt);
	
    return 0;
}

















