package com.cg.iter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.cg.iter.bean.Booking;
import com.cg.iter.bean.Movie;
import com.cg.iter.bean.Screen;
import com.cg.iter.bean.Seat;
import com.cg.iter.bean.Show;
import com.cg.iter.bean.Theatre;
import com.cg.iter.bean.Ticket;
import com.cg.iter.db.DatabaseImpl;
import com.cg.iter.exception.MismatchInputException;

public class MainController{
	static List<Movie> listOfMovies = new ArrayList<Movie>() ;
	static List<Screen> listOfScreens= new ArrayList<Screen>(); 
	static List<Theatre> listOfTheatres= new ArrayList<Theatre>();
	

	public static void main(String[] args) throws IOException{
		listOfMovies = DatabaseImpl.getMovies();
		listOfScreens = DatabaseImpl.getListOfScreens();
		listOfTheatres = DatabaseImpl.getListOfTheatres(listOfMovies, listOfScreens);

		Scanner scanner = new Scanner(System.in);
		System.out.println("==========================================================");
		System.out.println("\t\tONLINE MOVIE TICKET SYSTEM");
		System.out.println("==========================================================");
		int loopController;
		int expiryYear1=2020;
		do 
		{

			System.out.println("Press:\n\t1.PVR Cinemas\n\t2.Cinepolis Cinemas\n\t3.INOX Cinemas");
			
			int theatreNameChoice=scanner.nextInt();
			//String theatreName = scanner.nextLine();
			String theatreName="";
			if(theatreNameChoice==1)
			{
				theatreName="PVR Cinemas";
			}
			if(theatreNameChoice==2)
			{
				theatreName="Cinepolis Cinemas";
			}
			if(theatreNameChoice==3)
			{
				theatreName="INOX Cinemas";
			}
			for(Theatre theatre: listOfTheatres)
			{	
				if(theatre.getTheaterName().equalsIgnoreCase(theatreName))
				{
					System.out.println();
					System.out.println("Press:\n\t1.to search movie\n\t2.to search screen");

					int choice=scanner.nextInt();
					switch(choice)
					{
					case 1 :{
						System.out.println("Enter the name of movie from given choice: ");
						System.out.println("---------------------------");
						System.out.println("1.Chhichhore");
						System.out.println("2.Dream-Girl");
						System.out.println("3.War");
						System.out.println("4.Bala");
						System.out.println("5.Marjaavaan");
						System.out.println("6.Dabangg-3");
						System.out.println("7.Panipat");
						System.out.println("8.Good-News");
						System.out.println("9.Mardaani-2");
						System.out.println("10.Housefull-4");
						System.out.println("---------------------------");
						String movie = scanner.next();
						theatre.searchMovie(movie);
						int bookSeatChoice;
						int totalCount1=0;
						int seatsBooked=0;
						if(theatre.isMovieAvailable())
						{
						do
						{
							System.out.println("Do you want  to continue booking seat for this movie");
							System.out.println("1.Book Seat");
							System.out.println("2.Cancel Seat");
							System.out.println("3.Make Payment");
							System.out.println("4.Exit");
							bookSeatChoice=scanner.nextInt();
							
							if(bookSeatChoice==1)
							{
								System.out.println("Enter the number of seat/s you want to book");
								int noOfSeats=scanner.nextInt();
								seatsBooked+=noOfSeats;
								totalCount1=totalCount1+noOfSeats;
								Seat.bookSeat(noOfSeats);
								Ticket t=new Ticket();
								
								System.out.println("Do you want to checkout?");
								System.out.println("1.Yes");
								System.out.println("2.No");
								int checkOutChoice=scanner.nextInt();
								if(checkOutChoice==1)
								{
									System.out.println("Total cost: Rs. "+Booking.calculateTotalCost(seatsBooked));
								}
								else if(checkOutChoice==2)
								{
									System.out.println("Thanks for visiting");
								}
								else
									System.exit(0);
							}
							else if(bookSeatChoice==2)
							{
								System.out.println("Enter the number of seat/s you want to cancel");
								int cancelSeatCount=scanner.nextInt();
				
								if(cancelSeatCount>0 && cancelSeatCount<=totalCount1)
								{
								totalCount1-=cancelSeatCount;
								seatsBooked-=cancelSeatCount;
								Seat.cancelSeat(cancelSeatCount);
								System.out.println("Total cost: Rs. "+Booking.calculateTotalCost(seatsBooked));
								}
								else
									System.out.println("You haven't booked any seat or you are cancelling more than booked seat");
							}
							else if(bookSeatChoice==3)
							{
								System.out.println("Chose payment method");
								System.out.println("1.Cash Payment");
								System.out.println("2.Card Payment");
								int paymentChoice=scanner.nextInt();
								if(paymentChoice==1)
								{
									System.out.println("Please pay through cash at the time of entry");
									Booking.makePayment(Booking.calculateTotalCost(seatsBooked),seatsBooked,Show.getShowId(),Movie.getMovieId(),Show.getShowStartTime(),Show.getShowEndTime());
								}
								else if(paymentChoice==2)
								{
									if(seatsBooked>0)
									{
										boolean validInput=true;
										while(validInput)
										{
										try
											{
												System.out.println("Enter card no.");
												long cardNo=scanner.nextLong();
												String cardNoLength=Long.toString(cardNo);
												if(cardNoLength.length()==16)
												{
												    validInput=false;
												}
												else
												{
													System.out.println("Please enter 16 Digit Valid Card No");
													validInput=true;
												}
											}
										catch(InputMismatchException e)
											{
												System.out.println("Please enter valid Card No.");
												scanner.next();
											}
										}
										//-------------------------------------------------------
										System.out.println("Enter first name on card");
										String nameOnCard=scanner.next();
										Pattern pattern = Pattern.compile("[A-Z][a-z]*");
								
									    if (!pattern.matcher(nameOnCard).matches()) {
									        throw new IllegalArgumentException("Invalid String");
									    }
										
										
										//---------------------------------------------------------
									    validInput=true;
										while(validInput)
										{
										try
										{
											System.out.println("Enter expiry year of card");
											int expiryYear=scanner.nextInt();
											expiryYear1=expiryYear;
											if(expiryYear<2020)
											{
												System.out.println("Your card has expired");
												validInput=true;
											}
											else
											{
												validInput=false;
											}
										}
										catch(InputMismatchException e)
										{
											System.out.println("Please enter valid year");
											scanner.nextLine();
										}
										
										}
										
									    //---------------------------------------------------------
										validInput=true;
										while(validInput)
										{
										try
										{
											System.out.println("Enter expiry month of card");
											int expiryMonth=scanner.nextInt();
											if(expiryMonth<03 && expiryYear1<=2020 && expiryMonth<=12)
											{
												System.out.println("Your card has expired");
												validInput=true;
											}
											else
											{
												validInput=false;
											}
										}
										catch(InputMismatchException e)
										{
											System.out.println("Please enter valid month");
											scanner.nextLine();
										}
										
										}
										//--------------------------------------------------------------
										System.out.println("Enter cvv");
										validInput=true;
										while(validInput)
										{
										try
										{
										String cvv=scanner.next();
										String numberCheck = "\\d+";
										boolean valid=cvv.length()==3;
										boolean checkNum = cvv.matches(numberCheck);
										if(checkNum==false)throw new MismatchInputException("Please enter valid cvv");
										if(!valid)
										{
											System.out.println("CVV must be of three digit");
											validInput=true;
										}
										else
										{
											Booking.makePayment(Booking.calculateTotalCost(seatsBooked),seatsBooked,Show.getShowId(),Movie.getMovieId(),Show.getShowStartTime(),Show.getShowEndTime());
											validInput=false;
										}
										}
										catch(InputMismatchException e)
										{
											System.out.println("Please enter valid cvv");
											scanner.nextLine();
										} catch (MismatchInputException e) {
											// TODO Auto-generated catch block
											System.out.println(e.getMessage());
										}
										
										}
									}
								}
								else
								{
									System.out.println("Please book seats before making payment");
								}
							}
							else
							{
								System.out.println("Thank you for visiting");
								System.exit(0);
							}
						}while(true);
						}
						else
						{
							System.exit(0);
							break;
						}
					}

					case 2 :{
						System.out.println("Enter screen name from given options"); 
						System.out.println("Screen 1");
						System.out.println("Screen 2");
						System.out.println("Screen 3");
						String screen = scanner.next();
						theatre.searchScreen(screen);
						break;
					}
					default : System.out.println("Invalid Option");
					break;

					}
					break;

				}
			}

			loopController = scanner.nextInt();

		}while(loopController==1);
		scanner.close();
	}

}
