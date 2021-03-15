#include<iostream>
#include<algorithm>
#include<cstring>
using namespace std;

class makeOne{
    
    private:
        int numCase;
        int maxVal;
        int *integer;
        int arr[1000];
    
    public:
    makeOne()
        : maxVal(0)
    {
    }
    void setNum()
    {
        cin>>numCase;
        integer=new int[numCase];
        
        for(int i=0; i<numCase; i++)
        {
            do
            cin>>integer[i]; 
            while(integer[i]<1||integer[i]>10);
        }
        for(int i=0; i<numCase; i++)
        {
            maxVal=max(integer[i],maxVal);
        }
        
    }
    void solution()
    {
        arr[1]=1;
        arr[2]=2;
        arr[3]=4;
        
        for(int i=4; i<=maxVal; i++)
        {
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
        }
    }
    void printMin()
    {
        for(int i=0; i<numCase; i++)
        {
            cout<<arr[integer[i]]<<endl;
        }
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








