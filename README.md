#StateLayout

几乎每个项目中都有状态页面的切换：加载中、无数据、无网络、错误页。这个Demo就是将我以往项目中用到的提取出来，有两种模式：加载页面覆盖到内容页面之上和将内容页面替换掉，根据加载结果再替换回相应的页面，对应的类分别为：StateCoverHeplerImpl(覆盖模式)、StateReplaceHeplerImpl(替换模式)。接下来先看效果图：
###预览图
![enter description here][1]


  [1]: https://github.com/Apeplan/StateLayout/blob/master/screenshot/screenshot.gif
最早是从[简阅](https://github.com/chentao0707/SimplifyReader)中抽取出来放到项目中的。如果妨害了作者的权益，请及时告知