# flay-array-demo
 拍平数组Json化

### input
```properties
a.b.c=1
a.d=2
e=3
a.f=1
a.b.d=1
```

### output

```json
{"a":{"b":{"c":"1","d":"1"},"d":"2","f":"1"},"e":"3"}
```

### 截图
![](https://s3.bmp.ovh/imgs/2022/06/08/c3e812b4b9d0e229.jpg)