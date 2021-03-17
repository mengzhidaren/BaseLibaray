adb connect 192.168.10.184:5555
#卸载应用
adb uninstall com.meicet.charder
#####  adb shell input keyevent 命令
```
返回桌面 adb shell input keyevent 3
返回键 adb shell input keyevent 4
停止应用adb shell am force-stop com.meicet.charder
停止应用adb shell am kill com.meicet.charder
清空数据adb shell pm clear com.meicet.charder
keycode	含义
3	HOME 键
4	返回键
5	打开拨号应用
6	挂断电话
24	增加音量
25	降低音量
26	电源键
27	拍照（需要在相机应用里）
64	打开浏览器
82	菜单键
85	播放/暂停
86	停止播放
87	播放下一首
88	播放上一首
122	移动光标到行首或列表顶部
123	移动光标到行末或列表底部
126	恢复播放
127	暂停播放
164	静音
176	打开系统设置
187	切换应用
207	打开联系人
208	打开日历
209	打开音乐
210	打开计算器
220	降低屏幕亮度
221	提高屏幕亮度
223	系统休眠
224	点亮屏幕
231	打开语音助手
276	如果没有 wakelock 则让系统休眠
```
######
```
wifi连接adb
adb connect 192.168.10.251
卸载应用
adb uninstall com.meicet.charder

查看竖屏支持的分辨率
adb shell wm size
旋转屏幕 至竖屏
adb shell wm size 800x1280

下载数据库到电脑
adb pull /data/data/com.tiaooo.aaron/databases/tiaoba_v3.db D:\s

```