#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
#include<algorithm>
#include<cmath>
#include<map>

using namespace std;
bool check[1000001];
long long int arr[1000001];

int main() {
    
    long long int n1;
    long long int n2;
    long long int count=0;
    
    scanf("%lld %lld", &n1, &n2);
    
    long long int sq_max=(long long int)sqrt(n2);
	long long int cntNum=0;
	for(long long int i=2; i<=sq_max; i++){
		arr[i]=i*i;
		cntNum++;
	}
	for(int i=2; i<cntNum+2; i++){
		long long int div_min=n1;
		if(div_min%arr[i]!=0){
			div_min=(n1/arr[i]+1)*arr[i];
		}
		
		for(long long int tmp=div_min; tmp<=n2; tmp+=arr[i]){
			if(check[tmp-n1]==false){
				check[tmp-n1]=true;
				count++;
			}
		}
	}
	printf("%lld\n", (n2-n1+1)-count);
    
	return 0;
}


















