/// 在release目录下载对应平台的node库，解压重命名后缀为.node放在当前目录下
/// 先运行：node test.js
/// 再另一个终端运行：node test2.js
/// code说明参见java_samples/readme

console.log(process.argv);
var mpc = require('./mpc_hd_gg18');

let code = "5b475de6-0bbc-410d-8e3f-86c58c93f23b";
manager_addr = "http://47.100.101.81:8008/"


let resp = mpc.mkeygen(manager_addr, "1/2", code, "", "");
console.log(JSON.parse(resp))