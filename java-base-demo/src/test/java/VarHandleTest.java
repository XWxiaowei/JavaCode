import com.jay.jdk9.newFeature.HandleTarget;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

import static org.junit.Assert.assertEquals;

/**
 * @author xiang.wei
 * @create 2018/1/17 13:18
 */
@RunWith(JUnit4.class)
public class VarHandleTest {
    private HandleTarget handleTarget = new HandleTarget();
    private VarHandle varHandle;
    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        this.handleTarget = new HandleTarget();
        this.varHandle = MethodHandles.lookup().findVarHandle(HandleTarget.class,"count",int.class);
    }
    @Test
    public void testGet() {
        assertEquals(1, this.varHandle.get(this.handleTarget));
        assertEquals(1, this.varHandle.getVolatile(this.handleTarget));
        assertEquals(1, this.varHandle.getVolatile(this.handleTarget));
        assertEquals(1, this.varHandle.getAcquire(this.handleTarget));

    }
}
