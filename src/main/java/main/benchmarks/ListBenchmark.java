package main.benchmarks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ListBenchmark {

    private final int ELEMENT_COUNT = 100000;
    private final int bound = 10000;
    private final int OPERATION_COUNT = ELEMENT_COUNT / 2;
    private List<Integer> sut = new LinkedList<>();
    private final ArrayList<List<Integer>> lists = new ArrayList<>();
    private final Random random = new Random();

    public ListBenchmark() {
        System.out.println("number of elements: " + ELEMENT_COUNT);
        Random random = new Random();

        IntStream.range(0, ELEMENT_COUNT).forEach(i -> sut.add(random.nextInt(bound)));

        for (int i = 0; i < OPERATION_COUNT; ++i) {
            List<Integer> newList = new ArrayList<>();
            int newListLength = random.nextInt(50);
            for (int j = 0; j < newListLength; j++) {
                newList.add(random.nextInt(bound));
            }
            lists.add(newList);
        }

        benchmarkListOperations();
    }

    private void benchmarkListOperations() {
        List<Integer> originalSut = sut;
        benchmarkAdd(sut);
        sut = originalSut;
        benchmarkAddAll(sut);
        sut = originalSut;
        benchmarkAddFirst(sut);
        sut = originalSut;
        benchmarkAddLast(sut);
        sut = originalSut;
        benchmarkContains(sut);
        sut = originalSut;
        benchmarkContainsAll(sut);
        sut = originalSut;
        benchmarkGet(sut);
        sut = originalSut;
        benchmarkSet(sut);
        sut = originalSut;
        benchmarkRemove(sut);
        sut = originalSut;
        benchmarkRemoveFirst(sut);
        sut = originalSut;
        benchmarkRemoveLast(sut);
        sut = originalSut;
        benchmarkIndexOf(sut);
        sut = originalSut;
        benchmarkLastIndexOf(sut);
        sut = originalSut;
        benchmarkSubList(sut);
        sut = originalSut;
        benchmarkSort(sut);
    }

    private void benchmarkAdd(List<Integer> list) {
        long start = System.nanoTime();
        IntStream.range(0, OPERATION_COUNT).mapToObj(i -> random.nextInt(bound)).forEach(list::add);
        long end = System.nanoTime();
        displayTime("add operation", end - start);
    }

    private void benchmarkAddFirst(List<Integer> list) {
        long start = System.nanoTime();
        IntStream.range(0, OPERATION_COUNT).mapToObj(i -> random.nextInt(bound)).forEach(list::addFirst);
        long end = System.nanoTime();
        displayTime("addFirst operation", end - start);
    }

    private void benchmarkAddLast(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.addLast(random.nextInt(bound));
        }
        long end = System.nanoTime();
        displayTime("addLast operation", end - start);
    }

    private void benchmarkAddAll(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.addAll(lists.get(i));
        }
        long end = System.nanoTime();
        displayTime("addAll operation", end - start);
    }

    private void benchmarkContains(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.contains(random.nextInt(bound));
        }
        long end = System.nanoTime();
        displayTime("contains operation", end - start);
    }

    private void benchmarkContainsAll(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.containsAll(lists.get(i));
        }
        long end = System.nanoTime();
        displayTime("containsAll operation", end - start);
    }

    private void benchmarkGet(List<Integer> list) {
        int size = list.size();
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.get(random.nextInt(size));
        }
        long end = System.nanoTime();
        displayTime("get operation", end - start);
    }

    private void benchmarkSet(List<Integer> list) {
        int size = list.size();
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.set(random.nextInt(size), random.nextInt(bound));
        }
        long end = System.nanoTime();
        displayTime("set operation", end - start);
    }

    private void benchmarkRemove(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.remove(Integer.valueOf(random.nextInt(bound)));
        }
        long end = System.nanoTime();
        displayTime("remove operation", end - start);
    }

    private void benchmarkRemoveFirst(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.removeFirst();
        }
        long end = System.nanoTime();
        displayTime("removeFirst operation", end - start);
    }

    private void benchmarkRemoveLast(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.removeLast();
        }
        long end = System.nanoTime();
        displayTime("removeLast operation", end - start);
    }

    private void benchmarkIndexOf(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.indexOf(random.nextInt(bound));
        }
        long end = System.nanoTime();
        displayTime("indexOf operation", end - start);
    }

    private void benchmarkLastIndexOf(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.lastIndexOf(random.nextInt(bound));
        }
        long end = System.nanoTime();
        displayTime("lastIndexOf operation", end - start);
    }

    private void benchmarkSubList(List<Integer> list) {
        int size = list.size();
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT; ++i) {
            list.subList(random.nextInt(size / 2), random.nextInt(size / 2) + size / 2);
        }
        long end = System.nanoTime();
        displayTime("subList operation", end - start);
    }

    private void benchmarkSort(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < OPERATION_COUNT/100; ++i) {
            list.sort(Integer::compareTo);
        }
        long end = System.nanoTime();
        displayTime("sort operation", end - start);
    }

    private void displayTime(String operation, long timeInNanoseconds) {
        System.out.printf("%s took %d ns%n", operation, timeInNanoseconds);
    }
}