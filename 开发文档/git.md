```
取消http代理
git config --global --unset http.proxy

```
#### 添加子模块   https://blog.csdn.net/guotianqing/article/details/82391665
```
命令如下：
git submodule add <url> <path>
例子：
git submodule add https://github.com/mengzhidaren/BaseLibaray.git BaseLibaray
git diff --cached查看修改内容可以看到增加了子模块

```




#### 墙屏蔽解决方法
```
访问 https://www.ipaddress.com/ 网址查询 github 所需的地址对应的IP
修改hosts文件
将上述获取的IP地址添加到hosts文件中
Mac在 /etc/hosts
windows在C:\Windows\System32\drivers\etc\hosts 
# fix git clone github project failed
140.82.113.3 github.com
199.232.5.194 github.global.ssl.fastly.net
192.30.253.120  codeload.github.com
然后刷新DNS缓存
```
####墙屏蔽解决方法  刷新DNS缓存
```
Mac刷新DNS缓存
sudo killall -HUP mDNSResponder
sudo dscacheutil -flushcache

Windows更新DNS缓存
ipconfig /flushdns
```