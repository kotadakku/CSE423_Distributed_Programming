
class BoundedBuffer {
    final int MAX=15;
    final int MIN=0;
    int count =3;
    
    BinarySemaphore mutex = new BinarySemaphore(true);
    CountingSemaphore isMax = new CountingSemaphore(MAX-count);
    CountingSemaphore isMin = new CountingSemaphore(count-MIN);
    
    public int increment() {
		isMax.P();
		mutex.P();
		count ++;
		mutex.V();
		isMin.V();
		return count;
	}
    
	public int decrement() {
		isMin.P();
		mutex.P();
		count--;
		mutex.V();
		isMax.V();
		return count;
	}
}