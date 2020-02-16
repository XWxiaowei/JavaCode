//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;
//
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * @author xiang.wei
// * @create 2018/1/17 11:05
// */
//@RunWith(JUnit4.class)
//public class StreamTest {
//    @Test
//    public void testDropWhile() throws Exception {
//        final long count = Stream.of(1, 2, 3, 4, 5)
//                           .dropWhile(i->i%2!=0)
//                           .count();
//        assertEquals(4, count);
//    }
//
//    /**
//     * 对于输入的 String 流 ，先通过 flatMapping 把 String 映射成 Integer 流 ，再把所有的 Integer 收集到一个集合中。
//     */
//    @Test
//    public void testFlatMapping() {
//        final Set<Integer> result=Stream.of("a","ab","abc")
//                .collect(Collectors.flatMapping(v -> v.chars().boxed(),Collectors.toSet()));
//        assertEquals(3,result.size());
//    }
//
//    /**
//     * Optional 流中包含 3 个 元素，其中只有 2 个有值。在使用 flatMap 之后，结果流中包含了 2 个值。
//     */
//    @Test
//    public void  testStream() {
//        final long count = Stream.of(
//                Optional.of(1),
//                Optional.empty(),
//                Optional.of(2)
//        ).flatMap(Optional::stream).count();
//        assertEquals(2,count);
//    }
//}
