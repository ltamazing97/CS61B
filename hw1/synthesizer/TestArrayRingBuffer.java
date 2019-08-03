package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
    }

    @Test
    public void testEnqueueDequeue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);

        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals((int)arb.dequeue(), i);
        }
    }

    @Test
    public void testPeek() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);

        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals((int)arb.peek(), 0);
        }

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
