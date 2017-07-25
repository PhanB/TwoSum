# TwoSum
Problem: Given an array of integers and a target integer, find a pairing within the array that sum to the target.

## Methods
An obvious solution would be to pair integer with every other integer until a successful pairing is found. However this results in a complexity of O(n<sup>2</sup>), which is far from optimal. There is no way of ruling out pairings without reading them, so the minimum complexity we can achieve is O(n).<br><br>
In order to pursue a complexity of O(n) we will use a hashmap, which has a get/put complexity of O(1). In our hashmap we will store each integer's complement, the second half of the pairing that sums to the target, in the hashmap as a key. As its value we will store its position in the array, which might come in use if we were to expand on this problem. As we read through the given array we will see if any previous integers will pair with the current integer using hashmap's contains key function, which is O(1). Thus the worst case scenario using the hashmap method is O(n).
