#include<iostream>
#include<algorithm>
#include<cstring>
#include <vector>
using namespace std;

int arr[10001];
int dp[10001];
int comp[3];

class makeOne{
    
    private:
        int n;
        int sum;
    
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
        
        dp[1]=arr[1];
        
        if(n>1)
            dp[2]=arr[1]+arr[2];
        
        for(int i=3; i<=n; i++)
        {
            dp[i]=com(dp[i-1], dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
        }
    }
    int com(int n1, int n2, int n3)
    {
        int max=n1;
        
        if(max<n2)
            max=n2;
        if(max<n3)
            max=n3;
        
        return max;
    }
    void printMin()
    {
        cout<<dp[n]<<endl;
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













