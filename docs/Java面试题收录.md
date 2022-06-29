# Java 面试题归纳
<!-- GFM-TOC -->
[一、集合](#一集合)
  * [Q1. 讲一下HashMap的源码，如何解决hash碰撞？](#)
  * [Q2. ArrayList是如何实现的？ArrayList和LinkedList区别？ArrayList如何实现扩容？](#)
<!-- GFM-TOC -->

## 一、集合

Java集合或容器主要包括 Collection 和 Map 两种，Collection 存储着对象的集合，而 Map 存储着键值对（两个对象）的映射表。

<div align="center"> <img src="https://cs-notes-1256109796.cos.ap-guangzhou.myqcloud.com/image-20191208220948084.png"/> </div><br>

### Q1. 讲一下HashMap的源码，如何解决hash碰撞？
维护了Node/Entry数组的table，Node的结构是hash,k,v,next，根据数据的hash值放到数组的某个位置上。

- Java7: 数组+链表。数组的位置可以看作是一个一个的bucket，可以放不止一个数据。多个数据用链表存放。

- Java8: 数组+链表+红黑树。链表在长度随着长度越长，查询性能越低；因此长度超过8时会转换为红黑树，提升查询性能；

Java8选择红黑树是一种trade-off考虑，红黑树不追求绝对的平衡，兼顾查询性能的同时又减少了维护平衡的开销。


### Q2. ArrayList是如何实现的？ArrayList和LinkedList区别？ArrayList如何实现扩容？

通过动态数组实现，维护了一个Object数组elementData，可以动态扩容，可以理解ArrayList是一个自动扩容的数组。

初始化大小是10，每次动态扩容为1.5倍，最大容量是Integer.MAX_VALUE - 8（预留一些给VM，比如存放header）。

与LinkedList区别：

- 底层实现不同。ArrayList基于动态数组实现，如上解析；LinkedList是通过双向链表实现的，维护了包含item、prev、next信息的Node；

- 实现不同导致查询操作性能不同。ArrayList查询性能可以很高，支持根据下标点查，但add/remove性能比较低，因为需要移动数据；LinkedList查询性能比较低，需要遍历查询，但add/remove性能比较高，只需移动prev/next指针。

