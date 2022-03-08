import re
var=input()


patterCpp=re.compile('([a-z]_?)+[a-z]+')
patternJava=re.compile('([a-z]+[A-Z]*)+')
resultCpp=patterCpp.match(var)
resultJava=patternJava.match(var)
if re.fullmatch(patterCpp, var):
    while '_' in var:
        idx=var.index("_")
        var=var[:idx]+var[idx+1].upper()+var[idx+2:]
        var.lstrip('_')
    print(var)
elif re.fullmatch(patternJava, var):
    patternReplace=re.compile('[A-Z]')
    result=patternReplace.finditer(var)
    for r in result:
        tempStr=r.group()
        var=var.replace(tempStr, '_'+tempStr.lower(), 1)
    print(var)
else:
    print("Error!")
