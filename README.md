# leetcode-practice
> about leetcode

### code path
* /LeetCode/app/src/main/java/com/sun/leetcode

### First time
* From Easy Difficulty to Medium,Hard


### Second time

* Tag : Array、Tree

### Third time
* Different company

### All the problem
[Link: This problem list copy from my google From, u can see more click here](https://docs.google.com/spreadsheets/d/12DJ1cYo1e88Xz5V5uS3iFUgbAVCbOl8dktmCuNI8qVY/edit#gid=0)


### Problem
|LeetCode Id |	Question | Difficulty | Data Structures |	Algorithms |	thought |	follow up|
---|---|---|---|---|---|---|
905 |	Sort Array By Parity  |   Easy |	Array,Set    |  	排序	  |  先排序，再交换(前置索引元素)	  |
867 |	Transpose Matrix	| Easy |	Array,Matrix	  |  排序  |  	找规律的题。注意 ret 的行 ，列颠倒过来了  |
832 |	Flipping an Image	| Easy |	Array,Matrix	  |  排序  |  	"注意交换1 转换成0 就是(^=1);找规律：首尾相同，直接将 |元素转0，1； 首尾不同则不用管；a = b ^1 (//等同于b ^= 1, a = b)"	  |
766 |	Toeplitz Matrix	| Easy |	Array,Matrix	  |  排序	  |  思路：下一行的下一列要相等，注意边界值	|
561 |	Array Partition I 	| Easy |	Array	  |  排序	  |  思路：先sort，每2个取i值求和即可	、|
896 |	Monotonic Array	| Easy |	Array		  |    |  满足一个递增/递减即可	|
485 |	Max Consecutive Ones	| Easy |	Array	  |    |  	为1时计数+1，否则计数清零，每次都比较去max	|
888 |	Fair Candy Swap	| Easy |	Array		  |    |  "HashSet存储其中一个数据，便于遍历时查询是否 contains某个元素"	|
283 | *	Move Zeroes	| Easy |	Array		  |    |  "思路：把这个数组中所有的 N 个非 0 元素全部都一一赋值给数组前 N 个元素位，把数组中 N 个元素位之后的元素全部赋值为 0"	|
448 |	"Find All Numbers Disappearedin  an Array"	| Easy |	Array	  |  	"套用那个经典的给元素值赋正负来表达额外信息的套路:正负号标记法  nums[nums[i] -1] = -nums[nums[i]-1]"	|
169 |	Majority Element	| Easy |	Array，Bit	  |  	排序后，中位数肯定是最多的那个	|
122 |	Best Time to Buy and Sell Stock II	| Easy |	Array	  |  	"只要后一个比前一个大，就进行一次买进卖出。。累加差值"	|
217 |	Contains Duplicate	| Easy |	Array,Hash Table	  |  	solution 1:  用个hashset 排重	solution 2: 先排序，前后有相等则true|
717 |	1-bit and 2-bit Characters	| Easy |	Array，Bit	  |  	找规律：1为奇数的时候可以 .有点不太理解???	|
167 |	Two Sum II - Input array is sorted	| Easy |	Array	  |  	solution: while 进行逼近，直到return	|
697 |	Degree of an Array	| Easy |	Array		  |  "分析： [1, 7, 7, 5, 7, 1]   left = 1,right = 4  ;return right-left +1"	|
695 |		| Medium |				|
238 |	Product of Array Except Self	| Medium |	Array	  |  	" 1，2，3，4--第一次for,current 元素前面的所有乘积（ 1 ,1,2,6）； 第二次for,current 元素后面的所有乘积 两次的乘积就是结果（1*2*3*4  ,3*4*1,4*2,6*1）"|
495 |	Teemo Attacking	| Medium |	Array		  |  "solution: 间隔时间大于中毒时间就取中毒时间和，小于则 |取间隔时间。注意：最后一下中毒时间别忘记了"	|
667 |	Beautiful Arrangement II	| Medium |	Array	  |  		|
714 |	"Best Time to Buy and Sell Stock with Transaction Fee"	| Medium |	Array  |  		"solution: hold =  cash - sell cash = hold + sell"	|
287 |	Find the Duplicate Number	| Medium |	Array	  |  	"solution 1:  先排序，前后一致则return. /Time complexity : O(n |lgn)/Space complexity : O(1) (or O(n))solution 2:存set..已经存在则return.Timecomplexity :O(n)  Space complexity : O(n)"	|
700 |	Search in a Binary Search Tree	| Easy |	Tree	  |  	"* 题意：n叉树 搜索一个以val 为跟节点的子树，不存在 返回N |ULL*      solution: 递归"	"二叉查找树（英语：Binary Search Tree），也称为 |二叉搜索树、有序二叉树（ordered binary |
589 |	N-ary Tree Preorder Traversal	| Easy |	Tree		  |  "题意：前序遍历n叉数，不用递归，用遍历  solution: 用 stack 存储child 节点(因为前序遍历，所以遍历用倒序h)。  用while 轮训child 节点值并存储.. // stack 压栈add() == push()"	|
590 |	N-ary Tree Postorder Traversal	| Easy |	Tree	  |  	"题意： n叉树，事后遍历。不用递归，用遍历solution: 用 stack 存储child 节点(因为 |后序遍历，所以遍历)。  用while 轮训child 节点值并存储..最后记得翻转list"	|
617 |	Merge Two Binary Trees	| Easy |	Tree		  |  "题意： 合并两个Tree.. 位置重贴的则叠加solution 1: 迭代：时间复杂度 O(n)"	|
559 |	Maximum Depth of N-ary Tree	| Easy |	Tree		  |  " * solution 1: 递归,最后+1 * solution 2: DFS"	|
226 |	Invert Binary Tree	| Medium |	Tree	  |  	递归翻转	|
623 |	Add One Row to Tree	| Medium |	Tree		dfs	|
701 |	Insert into a Binary Search Tree	| Medium |	Tree	  |  	递归	|
113 |	Path Sum II	| Medium |	Tree		dfs 回溯	|
513 |	Find Bottom Left Tree Value	| Medium |	Tree		BFS	|
746 |	Min Cost Climbing Stairs	| Easy |	DP		  |  记录值	|
198 |	House Robber	| Easy |	dp		  |    * 题意： 抢劫一条街，相邻的回触发报警。如何才能抢到最 |大的金额并且不触发报警 * solution: 一个房子有两种情况： 抢或者不抢 * 抢： 则是 n-2 的最大值 + 当前值 * 不抢： 则是 n-1 的最大值"	|
303 |	Range Sum Query - Immutable	| Easy |	dp	  |  	solution 2:预处理，结果存储一下; res[j+1] - res[i]	|
64  |     Minimum Path Sum	| Medium |	dp		dp	|
213 |    *	House Robber II	| Medium |	dp		  |  "抢了第一个，最后一个就不能抢了，抢了最后一个，第一个就不能抢了（分两次计算，去首&去尾--> 取其max）"	|
264 |	Ugly Number II	| Medium |	dp、Math		  |  " 题意： 丑数-->只包含因子 2、3 和 5 的数称作丑数（被2 ，3，5整除）"	|
100 |	Same Tree	| Easy |	Tree、dfs		"  |   * solution 1: 递归 (暴力解法) * solution 2: stack"	|
200 | *	Number of Islands	| Medium |	dfs		  |  "solution: dfs 找到陆地的上下左右都为0就是1个陆地。遍历过 |后1都标记为0"	|
406 |	Queue Reconstruction by Height	| Medium |	Greed	  |  	先排序，在根据k依次进行插入	|
621 |	Task Scheduler	| Medium |	Greed		  |  "先排序，找到num , max的数.最终需要最少的任务时间:(最多 |任务数-1)(n + 1)+相同最多任务的任务个数）"	|
253 |	Meeting Rooms II	| Medium |	Greed	  |  	" solution: start存一个数组，end存一个数组。进行排序后遍历 |。start[i] <end[索引]则room+1.否则end索引+1"	|
455 |	Assign Cookies	| Medium |	Greed	  |  	solution: sort first. 遍历满足则enough++	|
763 |	Partition Labels	| Medium |	Greed、HashTable	  |  	"solution:根据一个start的字符找到该字符end,查看区间的字符 |是否在区间外，区间外则扩充(时间复杂度O(n |^2)) 所以用HashTable优化,用空间换时间。 这时候会遍历两遍，第一遍将26个字符每个end位置记录下来，第二遍 |去查看是否需要扩充"	|
767 |	Reorganize String	| Medium |	Greed	  |  	"solution: 先存起来，根据数量进行排序。然后用队列一次进行压string"	"优先队列：PriorityQueue是基于优先堆的一个无界队列，这个优先队列中的元素可以默认自然排序或者通过提供的Comparator（比较器）在队列实例化的时排序"|
79  |Word Search	| Medium |	BackTracking		  |  solution: 枚举并进行深度优先搜索	|
78* |	Subsets	| Medium |	BackTracking	  |  	典型的回溯	|
241 |	 Different Ways to Add Parentheses	| Medium |	Divide		  |  "硬做|
240 |	Search a 2D Matrix II	| Medium |	Divide	  |  	由左向右递增，由上向下递增，利用这一个属性进行分治	|
341 |	Flatten Nested List Iterator	| Medium |	Stack	  |  	stack;pop/peek	|
755 |	Pour Water	| Medium |	Array		  |  往左往右	|
787 |	Cheapest Flights Within K Stops	| Medium |	  |  DP "题意： 所有路径最便宜机票。sol |ution:DP.抽象一个二维数组"	|
324 |	Wiggle Sort II	| Medium |	Array   |    |  "排序，调整的方法是找到数组的中间的数，从中间分成两部分，然后从前半段的末尾取一个，在从后半的末尾去一个,这样保证了第一个数小于第二个数，接着从前半段取倒数第二个，从后半段取倒数第二个，这保证了第二个数大于第三个数，且第三个数小于第四个数，以此类推直至都取完。空间复杂度不满足"	|
394 |	Decode String	| Medium |	Stack、DFS	stack  |  	两个stack记录，分别记录num和上次字符串。	|
146 |	LRU Cache	| hard |	Design		  |  "solution: O（1），所以是hash table makes the time of get |() to be O(1)，不是List。使用double link"	|
460 |	LFU Cache	| Hard |	Design	  |  	"题意：LRU:频率RU..频率相同的移除最近不使用的元素；跟LRU相比，有一个使用频率;solution: 两个HashMap 分别存。。valueHash 用于存储Key |查询使用。nodeHash用存储<Key,Node></>于内部操作。LinkedHashSet用于存储count 不同的每个count下的Node的Key.O（1）所以用HashTable(HashMap).最后是一个d |ouble链表  Node(count = 0)-Node(count = 1)-Node(count = 2)-Node(count = 3)-Node(count = 4)"	|
560 |	Subarray Sum Equals K	| Medium |			prefixSum..预存sum与所求K的差值做为key	|
138 |	Copy List with Random Pointer	| Medium |			HashMap 预存。根据key...找出next,random	|
402 |	Remove K Digits	| Medium |	Stack、Greedy		  |  "solution:假设num的组成是""abc.....""，如果删掉'a'，那么剩下的 |是""bc....""，一定是由b打头； * 如果删掉任何a之后的字符，剩下的string必定由a打头。于是比较a和b的大小即可，用Greedy的思路选择最优解即可。"	|
206 |	Reverse Linked List	| Easy |	LinkedList		  |  "solution：iteratively:1指向null..2指向1，3指向2	|
443 |	 String Compression	| Easy |			  |  "“12” -- 遍历：Integer.toString(“12”).toCharArray()；长度为2"	|
103 |	"Binary Tree Zigzag LevelOr |der Traversal"	| Medium |	Stack、Tree、BFS	  |  	根据层级判断先后顺序，list.add(0,num)	|
445 |	Add Two Numbers II	| Medium |	Stack、LinkedList	  |  	借助Stack	|
165 |	Compare Version Numbers	| Medium |	Stack	  |  		|
545 |	Boundary of Binary Tree	| Medium |	DFS,Tree	  |  	递归	|
348 |	Design Tic-Tac-Toe	| Medium |	Design		  |  "用一位数组。可以标识行，列合。在计算一个对角线和逆对角 |线值即可"	|
794 |	Valid Tic-Tac-Toe State	| Medium |			  |  依次校验行，列，对角，斜对角是否满足	|
415 |	415. Add Strings	| Easy |	Math			|
344 |	Reverse String	| Easy |	Math		  |  end 和 start 交换即可	|
75  |     Sort Colors	| Easy |	Math		  |  while..=0 交换，=1则index++,==2则交换	|
251 |	Flatten 2D Vector	| Medium |	Design	  |  	 while (i.hasNext()) v[f()] = i.next();	|
322 |	coin change	| Medium |	DP		  |   dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);	|
