package demo.test;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {

		int row = 10000;
		int col = 10000;
		int tagertNumber = 5;
		int searchers = 5;
		int processRows = row / searchers;

		Matrix matrix = new Matrix(row, col, tagertNumber);
		Result result = new Result(row);
		Grouper grouper = new Grouper(result);
		CyclicBarrier barrier = new CyclicBarrier(searchers, grouper);

		for (int i = 0; i < searchers; i++) {
			int firstRow = i * processRows;
			int lastRow = firstRow + processRows;
			Searcher searcher = new Searcher(firstRow, lastRow, matrix, result, tagertNumber, barrier);
			searcher.setName("searcher-" + i);
			searcher.start();
		}
		System.out.println("Main thread has finished.");
	}
}

// 矩阵封装
class Matrix {

	private int[][] data;

	/**
	 * @param row
	 *            行数
	 * @param col
	 *            列数
	 * @param number
	 *            要寻找的目标数值
	 */
	public Matrix(int row, int col, int number) {

		int counter = 0;
		data = new int[row][col];
		Random rand = new Random();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i][j] = rand.nextInt(10);
				if (data[i][j] == number) {
					counter++;
				}
			}
		}
		System.out.printf("There are %d ocurrences of number in data.\n", counter);
	}

	public int[] getRow(int row) {
		if (row >= 0 && row < data.length) {
			return data[row];
		}
		return null;
	}

}

// 结果封装
class Result {
	// 保存矩阵每行中目标数值出现的次数
	private int data[];

	public Result(int col) {
		data = new int[col];
	}

	public void setData(int col, int value) {
		data[col] = value;
	}

	public int[] getData() {
		return data;
	}
}

// 搜索器
class Searcher extends Thread {
	private int firstRow;
	private int lastRow;
	private Matrix matrix = null;
	private Result result;
	private int number; // 要寻找的目标数值
	private CyclicBarrier barrier = null;

	public Searcher(int firstRow, int lastRow, Matrix matrix, Result result, int number, CyclicBarrier barrier) {
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.matrix = matrix;
		this.result = result;
		this.number = number;
		this.barrier = barrier;
	}

	public void run() {
		int counter = 0;
		String name = Thread.currentThread().getName();
		System.out.printf("%s: processing rows from %d to %d.\n", name, firstRow, lastRow);
		for (int i = firstRow; i < lastRow; i++) {
			int row[] = matrix.getRow(i);
			counter = 0;
			for (int j = 0; j < row.length; j++) {
				if (row[j] == number) {
					counter++;
				}
			}
			result.setData(i, counter);
		}
		System.out.printf("%s: processed.\n", name);

		try {
			// 关键语句
			barrier.await();
		} catch (InterruptedException e) {
		} catch (BrokenBarrierException e) {
		}
	}
}

class Grouper implements Runnable {

	private Result result = null;

	public Grouper(Result result) {
		this.result = result;
	}

	public void run() {
		int totalCount = 0;
		System.out.println("Grouper process results...");
		int[] data = result.getData();
		for (int count : data) {
			totalCount += count;
		}
		System.out.printf("Grouper total count: %d.\n", totalCount);
	}
}
