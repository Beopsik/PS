#include<cstdio>
#include<cstdlib>
#include<cstring>
#include <iostream>
#include <algorithm>
#include<stack>
using namespace std;

int main() {
    
    int A;
    int B;
    int C;
    int ret1, ret2, ret3, ret4;
    
    scanf("%d %d %d", &A, &B, &C);
    
    ret1=(A+B)%C;
    ret2=(A%C+B%C)%C;
    ret3=(A*B)%C;
    ret4=(A%C*B%C)%C;
    
    printf("%d\n", ret1);
    printf("%d\n", ret2);
    printf("%d\n", ret3);
    printf("%d\n", ret4);
    
	return 0;
}









