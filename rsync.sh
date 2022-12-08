#!/bin/bash
# 库开发者用此脚本把文件复制过来
# 库使用者不必关心此文件

rsync -avP --delete ~/mpc_hd_gg18/bindings/{libmpc_hd_gg18.so,MPC_HD_GG18_JavaBinding.java} ./
