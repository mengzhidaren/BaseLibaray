####  五种“生产者”的区别：
```
  Observable ，可多次发送事件，直到 onComplete 或 onError 被调用结束订阅。
  Flowable ，和 Observable 一样。并且可以处理背压（下游处理速度比上游发送速度要慢）。
  Single ，单次发送事件（onSuccess、onError），发完即结束订阅。
  Completable ，单次发送事件（onError、onComplete），发完即结束订阅。
  Maybe ，单次发送事件（onSuccess、onError、onComplete），发完即结束订阅。相当于 Completable 和 Single 结合。
根据五种“生产者”的特性，合理的场景使用：
  Single:当请求接口，需要处理接口返回结果内容的时候。
  Completable:当请求接口，并不需要关心返回结果时。例如：数据打点
  Maybe:相当于上面 Completable 与 Single 的结合体。考虑场景使用即可。
  Observable:当消费者需要处理生产者多次事件时。例如：TCP 长连接；需要逐个处理列表数据时。
  Flowable:都可以做到 Observable 。并且支持背压。例如：下载大文件，可能网络传输速度比本地写入快时。
```
