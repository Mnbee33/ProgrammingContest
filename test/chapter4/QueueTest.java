package chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {
    @Test
    void testQueue() {
        MyProcess process = new MyProcess("p1", 150);
        assertEquals("p1", process.name);
        assertEquals(150, process.time);

        // 全てのプロセスをキューへenqueue
        MyQueue queue = new MyQueue(5, 100);
        queue.enqueue("p1", 150);
        queue.enqueue("p2", 80);
        assertEquals(2, queue.size());

        // dequeueでプロセス一つを取り出す
        MyProcess dequeueItem = queue.dequeue();
        assertEquals("p1", dequeueItem.name);
        assertEquals(1, queue.size());
    }

    @Test
    void testExecute() {
        // プロセスの残り時間-基準時間を算出
        // 残り時間が0より大きかったら
        //// 合計時間に基準時間を足す
        //// プロセスの残り時間を算出した時間で更新してenqueue
        MyQueue queue = new MyQueue(5, 100);
        MyProcess process = new MyProcess("p1", 150);
        queue.execute(process);
        assertEquals(50, process.time);

        // 残り時間が0以下だったら
        //// 合計時間に元々のプロセスの残り時間を合計時間に足す
        process = new MyProcess("p2", 80);
        queue.execute(process);
        assertEquals(0, process.time);
        assertEquals(180, process.endtime);


        // キューが空になるまで実行する
        queue = new MyQueue(5, 100);
        queue.enqueue("p1", 150);
        queue.enqueue("p2", 80);
        queue.executeAll();

        StringBuffer result = new StringBuffer();
        result.append("p2 180");
        result.append(System.lineSeparator());
        result.append("p1 230");
        assertEquals(result.toString(), queue.result());
    }

    @Test
    void test() {
        String[] input = {
                "5 100",
                "p1 150",
                "p2 80",
                "p3 200",
                "p4 350",
                "p5 20",
        };
        MyQueue queue = new MyQueue(input);
        queue.executeAll();

        StringBuffer result = new StringBuffer();
        result.append("p2 180");
        result.append(System.lineSeparator());
        result.append("p5 400");
        result.append(System.lineSeparator());
        result.append("p1 450");
        result.append(System.lineSeparator());
        result.append("p3 550");
        result.append(System.lineSeparator());
        result.append("p4 800");

        assertEquals(result.toString(), queue.result());
    }
}
