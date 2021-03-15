#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

long long dp[201][201];
    
class makeOne{
    
    private:
        int N;
        int K;
    public:
    void setNum()
    {
        cin>>N;
        cin>>K;
    }
    void solution()
    {
        for(int n=0; n<=N; n++)
        {
            dp[1][n]=1;
        }
        
        for(int k=2; k<=K; k++)
        {
            for(int n=0; n<=N; n++)
            {
                for(int l=0; l<=n; l++)
                {
                    dp[k][n]+=dp[k-1][l];
                }
                dp[k][n]%=1000000000;
            }
        }
    }
    void printMin()
    {
        cout<<dp[K][N]<<endl;
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










