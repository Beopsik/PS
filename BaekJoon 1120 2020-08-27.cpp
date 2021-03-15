#include<iostream>
#include<algorithm>
#include<cstring>
#include <vector>
using namespace std;

int main(void)
{
	string x, y;
	
	cin>>x>>y;
	int unmatch=x.length();
	int len_x=x.length();
	int len_y=y.length();
	for(int i=0; i<=len_y-len_x; i++){
		int k=0;
		for(int j=0; j<len_x; j++){
			if(x[j]!=y[i+j])
				k++;
		}
		if(unmatch>k)
			unmatch=k;
	}
	
	printf("%d\n", unmatch);
    return 0;
}


















