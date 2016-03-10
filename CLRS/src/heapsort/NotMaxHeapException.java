package heapsort;

@SuppressWarnings("serial")
class NotMaxHeapException extends Exception{
	int end;
	public NotMaxHeapException(){}
	public NotMaxHeapException(int end) {
		this.end = end;
	}
	@Override
	public String getMessage() {
		return String.valueOf(this.end);
	}
}
