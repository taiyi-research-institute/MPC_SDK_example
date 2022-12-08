# keygen

原型: `public static native void keygen(String, String, String, String);`

参数列表:

1. `manager_url: String` 是MPC Manager (也叫MPC Server) 的http(s)链接.

2. `keyfile: String` 是私钥分片保存的路径. Rust程序把私钥分片以纯文本形式写在keyfile.

   > 若结盟关系或门限数发生变化，则keyfile也会变化. 持有方需自行维护keyfile是跟谁、用何门限值生成的.

3. `config: String` 是参与方的配置, 格式为`t/n`. 其中`t`为门限, `n`为参与方数. 在签名阶段, 需要至少`t+1`名参与方才能完成签名. 

4. `code: String` 代表参与方的结盟关系. 这个号码是从MPC Manager申请的. 具体来说, 一个结盟在创建私钥之前, 需要向MPC Manager申请一个号码, 用来标记这个结盟.

其他输出: 

1. 把私钥分片保存到`keyfile`.
2. 终端输出私钥分片对应的助记词.

例子:

步骤1: 在 http://xxxxx:8008/swagger-ui/index.html 上申请一个code. 笔者申请到了

```
40c00b17-82ad-429e-9f7d-be930471a191
```

步骤2: 将以下三个命令分别执行在三个终端里. 这三个终端可以在三个不同的主机上.

```
# terminal 1
java MPC_HD_GG18_JavaBinding keygen \
http://xxxxx:8008 keys1.store 1/3 40c00b17-82ad-429e-9f7d-be930471a191

# terminal 2
java MPC_HD_GG18_JavaBinding keygen \
http://xxxxx:8008 keys2.store 1/3 40c00b17-82ad-429e-9f7d-be930471a191

# terminal 3
java MPC_HD_GG18_JavaBinding keygen \
http://xxxxx:8008 keys3.store 1/3 40c00b17-82ad-429e-9f7d-be930471a191
```

# sign

原型: `public static native void keygen(String, String, String, String, String, String);` (6个String)

重载1: `public static native void keygen(String, String, String, String, String);` (5个String)

参数列表:

1. `manager_url: String` 详见keygen.
2. `keyfile: String` 是私钥分片的路径. 在keygen的时候, Rust程序把私钥分片以纯文本形式写在keyfile.
3. `config: String` 是签名参与方的配置, 格式为`t/c/n`. 意思是: 在`t/n`的keygen配置下 (详见`keygen`函数的`config`参数), 选`c`名参与方进行签名.
4. `message: String` 是待签名的文本.
5. `code: String` 详见keygen.
6. `derive: String` (可选) 是密钥衍生的路径, 默认为空字符串.

其他输出:

1. 把签名结果打印到console. 

   > TODO: 笔者也知道这样是不行的. 会尽快改进.

例子:

将以下两个命令分别执行在两个终端里. 这两个终端可以在两个不同的主机上.

```
# terminal 1
java MPC_HD_GG18_JavaBinding sign \
http://xxxxx:8008 keys1.store 1/2/3 yetanothertext 40c00b17-82ad-429e-9f7d-be930471a191

# terminal 2
java MPC_HD_GG18_JavaBinding sign \
http://xxxxx:8008 keys3.store 1/2/3 yetanothertext 40c00b17-82ad-429e-9f7d-be930471a191
```

