#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <cmath>

using namespace std;

int N;
int cnt, Max;
pair<int, int> I[100001];
int M[100001];

bool compare(pair<int, int> I1, pair<int, int> I2)
{
	if(I1.second<I2.second)//회의가 끝나는 시간이 빠를수록 회의를 많이 할 수 있기 때문이다.
		return true;
	else if(I1.second==I2.second)//회의가 끝나는 시간이 같으면 시작하는 시간이 빠를수록 비교가 빨라지기 때문이다.
		return I1.first<I2.first;
	else
		return false;
}
int main(void)
{
	int start, end;
	int next;	
	
	scanf("%d", &N);
	
	for(int i=0; i<N; i++){
		scanf("%d %d", &start, &end);
		I[i]=make_pair(start, end);
	}
	sort(I, I+N, compare);
	
	next=I[0].second;
	cnt++;
	for(int j=1; j<N; j++){
		if(next<=I[j].first){
			next=I[j].second;
			cnt++;
		}
	}
	
	if(N==1){
		printf("%d", 1);
	}else
		printf("%d\n", cnt);
	
    return 0;
}

