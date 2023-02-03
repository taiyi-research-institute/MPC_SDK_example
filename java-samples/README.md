# Java samples说明
- 在release目录中下载对应平台的sdk，放置到系统的库文件目录中（例如：linux中的/usr/lib，windows中的C:\Program Files\Microsoft\jdk-11.0.18.10-hotspot\bin\）
- 

# code使用说明

`code: String` 代表参与方的结盟关系. 这个号码是从MPC Manager申请的. 具体来说, 一个结盟在创建私钥之前, 需要向MPC Manager申请一个号码, 用来标记这个结盟.

- 测试例子:
  - 步骤1: 在 http://xxxxx:8008/swagger-ui/index.html 上申请一个code. 笔者申请到了
      ```
      40c00b17-82ad-429e-9f7d-be930471a191
      ```
  - 步骤2: 将其替换项目代码中的CODE字符串，再依次运行Test1、Test2