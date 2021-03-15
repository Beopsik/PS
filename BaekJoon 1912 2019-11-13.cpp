#include<iostream>
#include<algorithm>
#include<cstring>
#include <vector>
using namespace std;

long long arr[100001];
long long dp1[100001];

class makeOne{
    
    private:
        int k;
        int n;
        long long sum;
        long long Max=0;
    
    public:
    makeOne()
        : sum(0)
    {
    }
    void setNum()
    {
        cin>>n;
    }
    void solution()
    {
        for(int i=1; i<=n; i++)
        {
            cin>>arr[i];
        }
        
        dp1[1]=arr[1];
        
        for(int i=2; i<=n; i++)
        {
            dp1[i]=arr[i];
            dp1[i]=max(dp1[i-1]+arr[i],arr[i]);
        }
        Max=dp1[1];
        for(int i=1; i<=n; i++)
        {
            Max=max(Max, dp1[i]);
        }
    }
    void printMin()
    {
        cout<<Max<<endl;
    }
};

int main(void)
{
    makeOne one;
    one.setNum();
    one.solution();
    one.printMin();
    
    return 0;
    
}

















