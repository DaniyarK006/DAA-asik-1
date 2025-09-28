DAA-asik-1
putting the Divide and Conquer methods into action in Java and checking how well they perform
---------------------------------------------------------------------------------------------------------------------------------------------
 > Project Description

 this project's got a bunch of classic divide and conquer stuff implemented the project also has a set of ways to check how well the algorithms are doing

 number of comparisons,
number of allocated resources (allocations),
maximum recursion depth,
execution time.

 the goal isn't just about getting the right algorithms, but also about actually testing them out with coding

-----------------------------------------------------------------------------------------------------------------------------------------------

 > Algorithms implemented in the project

 Sorting

 Merge Sort — a stable sorting algorithm that operates in O(n log n) time.

 Quick Sort — quick sort (randomized pivot selection).

 Selecting the k-th element in order

 Deterministic Select (median of medians) — a super-fast, always-works-right algorithm that finds the middle value in a list in a straight line.

 Geometry

 Closest Pair — an algorithm for finding the two closest points in a plane by dividing the space into smaller parts.

-----------------------------------------------------------------------------------------------------------------------------------------------

 > Features

 Performance Measurements (Metrics) — key parameters are tracked:.
• Comparisons
• Allocations
• Max recursion depth Recursion depth)
• Execution time CLI interface — you can run algorithms directly from the command line.

 exporting results as CSV makes it super easy to analyze the data

 JUnit tests are all about making sure our algorithms work right and that our metrics system is solid and dependable

 Maven/Gradle — totally set for adding to a standard Java project.

-----------------------------------------------------------------------------------------------------------------------------------------------

 > Environment requirements

 Java 17 or later
Project builder: Maven (versions 3.6+) or Gradle
JUnit 5 support for tests

-----------------------------------------------------------------------------------------------------------------------------------------------

 > Installation and run

 1. Clone the repository:

 ```bash
git clone https://github.com/DaniyarK006/DAA-asik-1.git
cd DAA-asik-1
```
2. Build the project:

 ```bash
mvn clean compile
```
3. Run the tests to ensure everything works:.

 ```bash
mvn test
```
4. Create a jar (or just build the classes)

 ```bash
mvn package
```

-----------------------------------------------------------------------------------------------------------------------------------------------

 > Using the CLI

 Running algorithms via the console:

 ```bash
java -cp target/classes cli.algoritm.Runner   [k]
```

 Parameters:

 `algorithm` — algorithm name: `mergesort`, `quicksort`, `select`, `closest`. `N` — input data size (e.g., number of elements or points).

 `k` — index for the `select` algorithm (0-based).

 Examples:

 ```bash
java -cp target/classes cli.algoritm.Runner mergesort 10000
java -cp target/classes cli.algoritm.Runner quicksort 10000
java -cp target/classes cli.algoritm.Runner select 10000 50
java -cp target/classes cli.algoritm.Runner closest 1000
```

 > Output Format

 At the end, the program spits out something like this

 ```
Algorithm: mergesort
Input size: 10000
Result: ...
Execution Time: 15 ms
Metrics - Comparisons:
5, Allocations: The max recursion depth hit 20, and it was at level 14.
```

 If CSV output is configured (e.g., `Runner.printHeader()` and a special mode), the format can be:.

 ```
algorithmName;runTime;comparisons;depth;allocations
mergesort;15;
5;14;20
```

-----------------------------------------------------------------------------------------------------------------------------------------------

 > Testing

 To run all tests:

 ```bash
mvn test
```

 Tests cover:
 algorithm correctness (sorting, selection, nearest points)
metrics correctness (inc, add, reset, setMaxDepth)
wrapper functionality (e.g., `TrackMetrics`)
CSV export

-----------------------------------------------------------------------------------------------------------------------------------------------

 > Performance Analysis

 Thanks to built- When it comes to metrics, you can actually compare different algorithms not just by how fast they run, but also by looking at their own internal metrics This is super handy when you're looking at how things change with different amounts of input or when the data's got a unique pattern.

 Algorithm | Time | Comparisons | Allocations | Recursion Depth |.

 | -------------------- | ---------- | - The study's methodology was robust and comprehensive. Merge Sort is a sorting algorithm that's pretty efficient, taking O(n log n) time on average.

 Quick Sort is generally O(n log n) but can hit O(n) in the worst-case scenario, depending on the input.

 | Deterministic Select | O(n) | linear | depends | also linear |.

 | Closest Pair | O(n log n) | depends | depends | O(log n) |.
 
 -----------------------------------------------------------------------------------------------------------------------------------------------
 The project's outcome really hinges on how well it's sorted and the success rate
- Algorithm Complexity
Merge Sort: O(n log n) time, O(n) space
Quick Sort: O(n log n) average, O(n²) worst case
Deterministic Select: O(n) worst case time
Closest Pair: O(n log n) time, O(n) space
- Tracked Metrics
Comparisons: Element comparison operations
Allocations: Array and object allocations
Recursion Depth: Maximum call stack depth
Execution Time: Wall-clock time in milliseconds
