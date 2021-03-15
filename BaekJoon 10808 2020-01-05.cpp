#include<cstdio>
#include<cstring>
#include <iostream>
#include <algorithm>
using namespace std;

int alpabet[26];
	
int main() {
    
	char word[101];

	scanf("%s", word);
	
	for(int i=0; word[i]!=NULL; i++)
	{
	    alpabet[word[i]-'a']++;
	}
	
	for(int i=0; i<26; i++)
	{
	    printf("%d ",alpabet[i]);
	}

	return 0;
}





