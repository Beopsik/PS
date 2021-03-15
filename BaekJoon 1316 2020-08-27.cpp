#include<iostream>
#include<algorithm>
#include<cstring>
#include <vector>
using namespace std;

int main(void)
{
	int n;
	int result=0;
	int check=0;
	bool group=true;
	char alpabet[26];
	char word[26];
	int word_len=0;
	string s;
	
	for(int i=0; i<26; i++){
		alpabet[i]=97+i;
	}
	
	scanf("%d", &n);
	for(int i=0; i<n; i++){
		group=true;
		word_len=0;
		memset(word, '0', sizeof(word));
		
		cin>>s;
		for(int j=0; j<26; j++){
			if(s.find(alpabet[j])!=string::npos)
				word[word_len++]=alpabet[j];
		}
		
		for(int j=0; j<word_len; j++){
			char ch=word[j];
			check=s.find(ch);
			for(int t=check; t<s.length(); t++){
				if(s[t]==ch){
					int temp=check;
					check=t;
					if(check-temp>1){
						group=false;
						break;
					}
				}
			}
			if(group==false){
				break;
			}
		}
		if(group)
			result++;
	}
	
	printf("%d\n", result);
    return 0;
}

















