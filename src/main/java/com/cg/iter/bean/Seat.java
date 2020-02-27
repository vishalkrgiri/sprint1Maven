package com.cg.iter.bean;

public class Seat
{
	private int seatId;
	private static int totalSeat=100;
	private int bookSeatCount=0;
	private double seatPrice;
	public Seat(int seatId, double seatPrice) {
		super();
		this.seatId = seatId;
		this.seatPrice = seatPrice;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public double getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(double seatPrice) {
		this.seatPrice = seatPrice;
	}
	public static void bookSeat(int noOfSeats)
	{
		System.out.println(noOfSeats+" seats reserved for booking.");	
		totalSeat=totalSeat-noOfSeats;
		System.out.println(totalSeat+" seats left");
	}
	public static void cancelSeat(int cancelSeatCount)
	{
		System.out.println(cancelSeatCount+" seats cancelled Successfully");	
		totalSeat=totalSeat+cancelSeatCount;
		System.out.println(totalSeat+" seats left");
	}
}
