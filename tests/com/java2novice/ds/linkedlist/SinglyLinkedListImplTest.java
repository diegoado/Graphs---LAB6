package com.java2novice.ds.linkedlist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SinglyLinkedListImplTest {

    private ByteArrayOutputStream console;
    private PrintStream defaultOut;

    private SinglyLinkedListImpl<Integer> linkedList;

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    @Before
    public void setUp() {
        // Create a stream to hold the output
        console = new ByteArrayOutputStream();
        PrintStream newPrintStream = new PrintStream(console);
        // IMPORTANT: Save the old System.out!
        defaultOut = System.out;
        // Tell Java to use your special stream
        System.setOut(newPrintStream);
        linkedList = new SinglyLinkedListImpl<>();
    }

    @Test
    public void testAdd() {
        linkedList.add(1);
        linkedList.add(2);
        assertEquals("Adding: 1" + LINE_SEPARATOR + "Adding: 2" + LINE_SEPARATOR, console.toString());
    }

    @Test
    public void testAddAfter() {
        linkedList.add(1);
        linkedList.add(2);

        console.reset();
        linkedList.addAfter(3, 2);
        assertEquals("Traversing to all nodes.." + LINE_SEPARATOR, console.toString());

        console.reset();
        linkedList.addAfter(4,5);
        assertEquals("Traversing to all nodes.." +
                LINE_SEPARATOR + "Unable to find the given element..." + LINE_SEPARATOR, console.toString());
    }

    @Test
    public void testDeleteFront() {
        linkedList.deleteFront();

        assertEquals("Underflow..." + LINE_SEPARATOR, console.toString());
        linkedList.add(1);

        console.reset();
        linkedList.deleteFront();
        assertEquals("Deleted: 1" + LINE_SEPARATOR, console.toString());
    }

    @Test
    public void testDeleteAfter() {
        linkedList.add(1);

        console.reset();
        linkedList.deleteAfter(1);
        assertEquals("Traversing to all nodes.." + LINE_SEPARATOR, console.toString());

        console.reset();
        linkedList.deleteAfter(2);
        assertEquals("Traversing to all nodes.." +
                LINE_SEPARATOR + "Unable to find the given element..." + LINE_SEPARATOR, console.toString());

        linkedList.add(2);
        linkedList.add(3);

        console.reset();
        linkedList.deleteAfter(2);
        assertEquals("Traversing to all nodes.." +
                LINE_SEPARATOR + "Deleted: 3" + LINE_SEPARATOR, console.toString());
    }

    @Test
    public void testTraverse() {
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            linkedList.add(i);
            output.append(String.valueOf(i)).append(LINE_SEPARATOR);
        }
        console.reset();
        linkedList.traverse();
        assertEquals(output.toString(), console.toString());
    }

    @After
    public void tearDown() {
        System.out.flush();
        System.setOut(defaultOut);
    }

}