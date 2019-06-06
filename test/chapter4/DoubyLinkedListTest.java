package chapter4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubyLinkedListTest {
    @Test
    void testInsert() {
        DoubyLinkedList list = new DoubyLinkedList();

        MyNode node1 = new MyNode("5");
        MyNode node2 = new MyNode("6");

        // insert(x) 先頭にキーxの要素を足す
        list.insert(node1);
        list.insert(node2);
        assertEquals(node1, node2.next);
        assertEquals(node2, node1.prev);

        // delete(x) キーxをもつ要素のうち最初に見つかった要素を削除する
        // deleteFirst 先頭の要素を削除する
        // deleteLast 末尾の要素を削除する
    }

    @Test
    void testGet() {
        DoubyLinkedList list = new DoubyLinkedList();

        MyNode node1 = new MyNode("5");
        MyNode node2 = new MyNode("6");

        list.insert(node1);
        list.insert(node2);
        assertEquals(node1, list.get("5"));
    }

    @Test
    void testDeleteNode() {
        DoubyLinkedList list = new DoubyLinkedList();

        MyNode node1 = new MyNode("5");
        MyNode node2 = new MyNode("6");

        list.insert(node1);
        list.insert(node2);
        list.deleteNode(node1);
        assertEquals("", list.get("5").toString());

        // delete(x) キーxをもつ要素のうち最初に見つかった要素を削除する
        // deleteFirst 先頭の要素を削除する
        // deleteLast 末尾の要素を削除する
    }

    @Test
    void testDelete() {
        DoubyLinkedList list = new DoubyLinkedList();

        MyNode node1 = new MyNode("5");
        MyNode node2 = new MyNode("6");

        list.insert(node1);
        list.insert(node2);
        // delete(x) キーxをもつ要素のうち最初に見つかった要素を削除する
        list.delete("5");
        assertEquals("", list.get("5").toString());
    }

    @Test
    void testDeleteFirst() {
        DoubyLinkedList list = new DoubyLinkedList();

        MyNode node1 = new MyNode("5");
        MyNode node2 = new MyNode("6");

        list.insert(node1);
        list.insert(node2);
        // deleteFirst 先頭の要素を削除する
        list.deleteFirst();
        assertEquals("", list.get("6").toString());
    }

    @Test
    void testDeleteLast() {
        DoubyLinkedList list = new DoubyLinkedList();

        list.insert(new MyNode("5"));
        list.insert(new MyNode("6"));
        list.insert(new MyNode("7"));
        // deleteLast 末尾の要素を削除する
        list.deleteLast();
        assertEquals("", list.get("5").toString());
    }

    @Test
    void testStringCommand() {
        DoubyLinkedList list = new DoubyLinkedList();

        list.parse("insert 5");
        assertEquals("5", list.get("5").toString());

        list.parse("insert 6");
        list.parse("insert 7");
        // 順番：7, 6, 5
        list.parse("deleteFirst");
        assertEquals("", list.get("7").toString());

        // 6, 5
        list.parse("deleteLast");
        assertEquals("", list.get("5").toString());

        list.parse("delete 6");
        assertEquals("", list.get("6").toString());
    }

    @Test
    void testAll() {
        DoubyLinkedList list = new DoubyLinkedList();
        String[] commands = {
                "7",
                "insert 5",
                "insert 2",
                "insert 3",
                "insert 1",
                "delete 3",
                "insert 6",
                "delete 5",
        };
        list.executeAll(commands);
        assertEquals("6 1 2", list.toString());
    }
}
