package me.totti.example.functional.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Title: StreamTask.class<br>
 * Description: <br>
 * Copyright (c) totti.me 2016    <br>
 * Create DateTime: 2016年07月14日 10:58 <br>
 *
 * @author TottiChen
 */
public class StreamsOperation {
	private enum Status {
		OPEN, CLOSED
	}

	private static final class Task {
		private final Status status;
		private final Integer points;

		Task(Status status, Integer points) {
			this.status = status;
			this.points = points;
		}

		public Integer getPoints() {
			return points;
		}

		public Status getStatus() {
			return status;
		}

		@Override
		public String toString() {
			return String.format("[%s, %d]", status, points);
		}
	}

	final static Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13), new Task(Status.CLOSED, 8));

	private static void sum() {
		long totalPointsOfOpenTasks = tasks.stream().filter(task -> task.getStatus().equals(Status.OPEN)).mapToInt(Task::getPoints).sum();
		System.out.println("Total open task points:" + totalPointsOfOpenTasks);
	}

	private static void reduce() {
		final double totalPoints = tasks.stream().distinct().parallel().map(task -> task.getPoints()).reduce(0, Integer::sum);

		System.out.println("Total points(all tasks): " + totalPoints);
	}

	private static void collectList() {
		List<Task> result = tasks.stream().collect(() -> new ArrayList<>(), (list, item) -> list.add(item), (one, two) -> one.addAll(two));
		result.stream().forEach(System.out::println);
	}

	private static void simplecollectList() {
		List<Task> result = tasks.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		result.stream().forEach(System.out::println);
	}

	private static void collectorscollectList() {
		List<Task> result = tasks.stream().collect(Collectors.toList());
		result.stream().forEach(System.out::println);
	}

	private static void collectMap() {
		Map<Status, Task> lastStatusTask = tasks.stream().collect(() -> new HashMap<>(), (map, item) -> map.put(item.getStatus(), item), (
				mapOne, mapTwo) -> mapOne.putAll(mapTwo));

		System.out.println(lastStatusTask);
	}

	private static void simplecollectMap() {
		Map<Status, Task> lastStatusTask = tasks.stream().collect(HashMap::new, (map, item) -> map.put(item.getStatus(), item), Map::putAll);
		System.out.println(lastStatusTask);
	}

	private static void collectorcollectMap() {
		Map<Status, Task> lastStatusTask = tasks.stream().collect(Collectors.toMap(item -> item.getStatus(), item -> item, (
				exists, newv) -> newv));
		System.out.println(lastStatusTask);
	}

	public static void group() {
		Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(item -> item.getStatus(), Collectors.toList()));

		System.out.println(map);
	}

	public static void simplegroup() {
		Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));

		System.out.println(map);
	}

	public static void mappergroup() {
		Map<Status, List<Integer>> map = tasks.stream().collect(Collectors.groupingBy(item -> item.getStatus(), Collectors.mapping(item -> item.getPoints(), Collectors.toList())));

		System.out.println(map);
	}

	public static void main(String[] args) {
		System.out.println("start sum ===== ");
		sum();
		System.out.println("end sum ===== ");

		System.out.println("start reduce ===== ");
		reduce();
		System.out.println("end reduce ===== ");

		System.out.println("start collect list ===== ");
		collectList();
		System.out.println("end collect list ===== ");

		System.out.println("start simple collect list ===== ");
		simplecollectList();
		System.out.println("end simple collect list ===== ");

		System.out.println("start collectors collect list ===== ");
		collectorscollectList();
		System.out.println("end collectors collect list ===== ");

		System.out.println("start collect map ===== ");
		collectMap();
		System.out.println("end collect map ===== ");

		System.out.println("start simple collect map ===== ");
		simplecollectMap();
		System.out.println("end simple collect map ===== ");

		System.out.println("start collectors collect map ===== ");
		collectorcollectMap();
		System.out.println("end collectors collect map ===== ");

		System.out.println("start group ===== ");
		group();
		System.out.println("end group ===== ");

		System.out.println("start simple group ===== ");
		simplegroup();
		System.out.println("end simple group ===== ");

		System.out.println("start mapper group ===== ");
		mappergroup();
		System.out.println("end mapper group ===== ");
	}
}
