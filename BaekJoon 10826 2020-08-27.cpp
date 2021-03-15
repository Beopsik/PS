#include <iostream>
#include <string>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

string Add(string s1, string s2)
{
	string result(max(s1.size(), s2.size()), '0');
	int temp;
	bool carry=false;
	
	for(int i=0; i<result.size(); i++){
		if(carry)
			temp=1;
		else
			temp=0;
		
		carry=false;
		
		if(i<s1.size())
			temp+=s1[s1.size()-i-1]-'0';
		if(i<s2.size())
			temp+=s2[s2.size()-i-1]-'0';
		
		if(temp>=10){
			carry=true;
			temp-=10;
		}
		
		result[result.size()-i-1]=temp+'0';
	}
	if(carry)
		result.insert(result.begin(), '1');
	
	return result;
}
void Fibo(int n)
{
	string arr[n+2];
	arr[0]='0', arr[1]='1';
	for(int i=2; i<=n; i++){
		arr[i]=Add(arr[i-1], arr[i-2]);
	}
	cout<<arr[n]<<endl;
}
int main (){
	
	int n;
	scanf("%d", &n);
	
	Fibo(n);
	
	return 0;
}



