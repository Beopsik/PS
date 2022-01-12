croatiaAlphabet=["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" ]
inputStr=input()

result=0
for alphabet in croatiaAlphabet:
    result+=inputStr.count(alphabet)
    inputStr=inputStr.replace(alphabet, "0")

inputStr=inputStr.replace("0", "")
result+=len(inputStr)

print(result)
