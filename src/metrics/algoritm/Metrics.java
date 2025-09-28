package metrics.algoritm;

public class Metrics {

    private long comparisons;
    private long allocations;
    private int maxRecursionDepth;

    public void incComparisons() {
        comparisons++;
    }
    public void addComparisons(int i) {
        comparisons++;
    }

    public void incAllocations() {
        allocations++;
    }

    public Object getComparisons() {
        return comparisons;
    }

    public Object getAllocations() {
        return allocations;
    }

    public Object getMaxRecursionDepth() {
        return maxRecursionDepth;
    }
    public void reset() {
        comparisons = 0;
        allocations = 0;
        maxRecursionDepth = 0;
    }

    public void setMaxRecursionDepth(int currentDepth) {
        int depth = 0;
        if (depth > maxRecursionDepth) {
            maxRecursionDepth = depth;
        }
    }
}
