package com.cg.iter.bean;

import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;


public class Booking{
	private static Logger logger = Logger.getLogger(Booking.class);
	private static int bookingId;
	private int movieId;
	private int showId;
	private Show show;
	private static LocalDate date;
	private static int transactionId;
	private static double totalCost;
	private ArrayList<Seat> seat;
	private Ticket ticket;
	
	public static boolean makePayment(double totalCost,int seatsBooked, int showId,int movieId, LocalTime showStartTime, LocalTime showEndTime)
	{
		System.out.println("Payment Done Successfully");
		System.out.println("Total amount: "+totalCost);
		Random rnd = new Random();
		bookingId=rnd.nextInt(99999999); //This will generate a random number of 8 digit and getting stored in BookingId.
		System.out.println("Booking ID: "+bookingId);
		System.out.println("No. of seats booked: "+seatsBooked);
		transactionId = rnd.nextInt(99999999); //This will generate a random number of 8 digit and getting stored in BookingId.
		System.out.println("Transaction ID: "+transactionId);
		System.out.println("Movie ID: "+movieId);
		System.out.println("Show ID: "+showId);
		System.out.println("Show Start Time: "+showStartTime);
		System.out.println("Show End Time: "+showEndTime);
		logger.info("Payment Done of: "+totalCost+" Booking ID: "+bookingId+" Transaction ID: "+transactionId);
		return true;
	}
	
	public Booking(int bookingId, int movieid, int showid, Show show, LocalDate date, int transactionId,
			double totalCost, ArrayList<Seat> seat, Ticket ticket) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieid;
		this.showId = showid;
		this.show = show;
		this.date = date;
		this.transactionId = transactionId;
		this.totalCost = totalCost;
		this.seat = seat;
		this.ticket = ticket;
	}
	public Booking() {}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getMovieid() {
		return movieId;
	}
	public void setMovieid(int movieid) {
		this.movieId = movieid;
	}
	public int getShowid() {
		return showId;
	}
	public void setShowid(int showid) {
		this.showId = showid;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public static LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public ArrayList<Seat> getSeat() {
		return seat;
	}
	public void setSeat(ArrayList<Seat> seat) {
		this.seat = seat;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	/*private static int ticketId;
	private static int noOfSeats;
	private static String seatName;
	private static Booking bookingRef;
	private static boolean ticketStatus;
	private static String screenName;*/
	
	public static double calculateTotalCost(int noOfSeats)
	{
		totalCost=noOfSeats*120;
		return totalCost;
	}
	
}