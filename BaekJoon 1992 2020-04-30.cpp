#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;
char arr[65][65];

void quad(int beginX, int beginY, int size)
{
	char beginData=arr[beginY][beginX];
	bool isCombinable=true;
	for(int y=beginY; y<beginY+size; y++)
	{
		for(int x=beginX; x<beginX+size; x++)
		{
			if(beginData!=arr[y][x])
			{
				isCombinable=false;
				break;
			}
		}
		if(isCombinable==false)
			break;
	}
	
	if(isCombinable)
	{
		printf("%c", beginData);
		return;
	}
	
	int halfSize=size/2;
	printf("(");
	quad(beginX, beginY, halfSize);
	quad(beginX+halfSize, beginY, halfSize);
	quad(beginX, beginY+halfSize, halfSize);
	quad(beginX+halfSize, beginY+halfSize, halfSize);
	printf(")");
		
}

int main(void){
	
	int n;
	
	scanf("%d", &n);
	for(int i=0; i<n; i++)
	{
		scanf("%s", arr[i]);
	}
	
	quad(0, 0, n);
	
    return 0;
}

