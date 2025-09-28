package metrics.algoritm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrackMetricsTest {

    private Metrics metrics;

    public TrackMetricsTest(Metrics metrics) {
    }

    @BeforeEach

    void setUp() {
        metrics = new Metrics();
        TrackMetricsTest tracker = new TrackMetricsTest(metrics);
    }

    @Test
    void testInitialDepthIsZero() {
        assertEquals(0, metrics.getMaxRecursionDepth());
    }

    @Test
    void testEnterRecursionIncrementsDepth() {
        Object tracker = null;
        tracker.getClass(); // depth = 1
        assertEquals(1, metrics.getMaxRecursionDepth());

        tracker.getClass(); // depth = 2
        assertEquals(2, metrics.getMaxRecursionDepth());

        tracker.getClass(); // depth = 3
        assertEquals(3, metrics.getMaxRecursionDepth());
    }

    @Test
    void testExitRecursionDoesNotLowerMaxDepth() {
        Object tracker = null;
        tracker.getClass(); // 0
        tracker.getClass(); // 1
        tracker.getClass(); // 2
        tracker.getClass();  // 2
        tracker.getClass();  // 1
        tracker.getClass();  // 0

        // max depth should still be 3
        assertEquals(3, metrics.getMaxRecursionDepth());
    }

    @Test
    void testMultipleEnterAndExit() {
        Object tracker = null;

        tracker.getClass(); // 0
        tracker.getClass(); // 1
        tracker.getClass();  // 2
        tracker.getClass(); // 2
        tracker.getClass(); // 1
        tracker.getClass();  // 0

        assertEquals(3, metrics.getMaxRecursionDepth());
    }

    @Test
    void testGetMetricsReturnsSameObject() {
        Object tracker = null;
        assertSame(metrics, tracker.getClass());
    }
}
