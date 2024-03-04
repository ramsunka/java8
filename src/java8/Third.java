package java8;

public class Third {
	
	public static void main(String[] args) {
		//Annonymous inner class where is no name for class. Here we are not creating Runnable object
		//Annonymous inner class is helpfull in case if we have multiple abstract methods
		Runnable r=new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("Child Thread");
				}
			}
		};
		//Lambda expression way of creating child thread
		//Lambda expression is only applicable for functional interfaces
		Runnable r1=()->{
			for(int i=0;i<10;i++) {
				System.out.println("Child R Thread");
			}
		};		
		Thread t=new Thread(r1);
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
		}
	}

}
