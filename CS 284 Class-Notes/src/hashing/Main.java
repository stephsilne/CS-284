package hashing;
public class Main {

	private HashTableOpenStub<Integer, Long> memo = new HashTableOpenStub<>();

	public long fib(int n) {
		if (n < 2) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public long memo_fib(int n) {

		if (n < 2) {
			return n;
		}

		Long g = memo.get(n);
		if (g != null) {
			return g;
		}

		long result = memo_fib(n - 1) + memo_fib(n - 2);
		memo.put(n, result);

		return result;
	}

	public void runTest(int n) {
		long startTime = System.nanoTime();
		System.out.println(fib(n));
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		System.out.println("Normal took " + duration / 1_000_000_000. + " seconds");

		startTime = System.nanoTime();
		System.out.println(memo_fib(n));
		endTime = System.nanoTime();

		long duration2 = (endTime - startTime);
		System.out.println("Memo took " + duration2 / 1_000_000_000. + " seconds");

		System.out.println("Difference: " + (duration - duration2) / 1_000_000_000. + " seconds");
		System.out.println("Memo " + duration / duration2 + "x faster");
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.runTest(46);
		// System.out.println(m.memo_fib(102));
	}
}

