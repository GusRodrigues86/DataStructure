# Counting Inversions
Counting inversions is a process to measure how UNSORTED an array is.

The general ideia is the following:
> An array is considered sorted when, iff (if and only if) the element in the n positions is less or equals to the next element
>
> But given an array such as (2,1), there is one inversion.
> 
> (3,2,1) will have 3. 3,1 is an inversion, because 3 < 1 is false. same 3,2 for 3 < 2. also 2,1 ::= 2 < 1 is false.


## The Solution
One of the most reliable way to sort is using Merge sort, that runs on linearithmic (n* lg n) time.

## The solution caveat
When breaking down the solution into smaller partition, up to size 1, one can assume the following:

the left child branch of the partition, in a sorted array, all elements will be less or equal to any element on the right child. ex:

> unsorted (3,2,1,6,5,4)
>
> Partitions: Left: (3,2,1) - Right: (6,5,4)
>
> sorted (1,2,3,4,5,6)
>
> Partitions: Left (1,2,3) Right: (4,5,6)

during the merge, due to the original "unsortedness", we may encounter a condition such as:

> unsorted (1,3,5,2,4,6)
>
> Partitions: Left: (1,3,5) - Right: (2,4,6)

2 has two inversions: 3,2 and 5,2
Therefore, iff (right[i] < left[i]), we have an inversion. Since the first element of the right array is AT LEAST the length of the array, the total amount of inversion is given as `left array size - left array index`, when using 0 indexed value, or `(left array size - left array index) + 1` for 1 indexed arrays.

We can count the inversions as the total of elements pairing before being sorted. for 2 and 6. (`(3-1) = 2`) and (`(3-2) = 1`).