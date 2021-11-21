package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;

	public ATMImpl() {
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// ATMImpl calling transport layer methods

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}

	// setter based D.I
	public void setMyTransport(Transport myTransport) {
		System.out.println("in set transport");
		this.myTransport = myTransport;
	}

	// init style method : public void anyName() throws Exception
	public void myInit() {
		System.out.println("in init" +myTransport);
	}

	// destroy style method : public void anyName() throws Exception
	public void myDestroy() {
		System.out.println("in destroy" +myTransport);
	}

}