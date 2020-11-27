import java.util.Scanner;

public class GuessANumberThread extends Thread {
     
    private int guessNumber = 0;
    private int count = 0;
     
    public GuessANumberThread(int guessNumber) {
        this.guessNumber = guessNumber;
    }
 
    @Override
    public void run() {
        int randomNumber = 0;
        do {
            randomNumber = (int) (Math.random() * 100 + 1);
            count++;
            System.out.println(getName() + " đoán số " + randomNumber);
             
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (randomNumber != guessNumber);
         
        System.out.println(getName() + " đã đoán ra số " + guessNumber + " trong " + count + " lần đếm");
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Nhập một số nguyên để các thread đoán: ");
			int number = scanner.nextInt();
			    
			GuessANumberThread thread1 = new GuessANumberThread(number);
			GuessANumberThread thread2 = new GuessANumberThread(number);
			    
			thread1.setName("Thread 1");
			thread2.setName("Thread 2");
			    
			thread1.start();
			thread2.start();
		}
    }
}