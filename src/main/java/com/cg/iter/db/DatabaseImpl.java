package com.cg.iter.db;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.cg.iter.bean.Movie;
import com.cg.iter.bean.Screen;
import com.cg.iter.bean.Show;
import com.cg.iter.bean.Theatre;

public class DatabaseImpl{

	DatabaseImpl() {
		throw new IllegalStateException("Utility class");
	}

	public static List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		String[] lang = { "Hindi", "English" };
		movies.add(new Movie(3001, "Chhichhore", "Nitesh Tiwari", 154, lang, LocalDate.parse("2019-09-06")));
		movies.add(new Movie(3002, "Dream-Girl", "Raaj Shaandilyaa", 140, lang, LocalDate.parse("2019-09-13")));
		movies.add(new Movie(3003, "War", "Siddharth Anand", 139, lang, LocalDate.parse("2019-10-02")));
		movies.add(new Movie(3004, "Bala", "Amar Kaushik", 153, lang, LocalDate.parse("2019-11-22")));
		movies.add(new Movie(3005, "Marjaavaan", "Milap Milan Zaveri", 150, lang, LocalDate.parse("2019-11-22")));
		movies.add(new Movie(3006, "Dabangg-3", "Prabhu Deva", 159, lang, LocalDate.parse("2019-12-20")));
		movies.add(new Movie(3007, "Panipat", "Ashutosh Gowariker", 145, lang, LocalDate.parse("2019-12-06")));
		movies.add(new Movie(3008, "Good-News", "Raj Mehta", 160, lang, LocalDate.parse("2019-12-20")));
		movies.add(new Movie(3009, "Mardaani-2", "Gopi Puthran", 163, lang, LocalDate.parse("2019-12-13")));
		movies.add(new Movie(3010, "Housefull-4", "Farhad Samji", 154, lang, LocalDate.parse("2019-10-25")));

		return movies;
	}

	public static List<Screen> getListOfScreens() {
		List<Screen> listOfScreens = new ArrayList<Screen>();
		listOfScreens.add(new Screen(102001, 2001, "Screen1", LocalDate.parse("2019-09-30"), getShows(), 25, 20));
		listOfScreens.add(new Screen(112001, 2001, "Screen2", LocalDate.parse("2019-09-25"), getShows(), 25, 20));
		listOfScreens.add(new Screen(102002, 2002, "Screen1", LocalDate.parse("2019-09-20"), getShows(), 25, 20));
		listOfScreens.add(new Screen(112002, 2002, "Screen2", LocalDate.parse("2019-09-30"), getShows(), 25, 20));
		listOfScreens.add(new Screen(102003, 2003, "Screen1", LocalDate.parse("2019-09-26"), getShows(), 25, 20));
		listOfScreens.add(new Screen(112003, 2003, "Screen2", LocalDate.parse("2019-09-27"), getShows(), 25, 20));
		listOfScreens.add(new Screen(122003, 2003, "Screen3", LocalDate.parse("2019-09-28"), getShows(), 25, 20));

		return listOfScreens;

	}

	public static List<Theatre> getListOfTheatres(List<Movie> movies, List<Screen> listOfScreens) {
		List<Theatre> listOfTheatres = new ArrayList<Theatre>();

		listOfTheatres.add(new Theatre(2001, "PVR Cinemas", "Cuttack", addMoviesToTheatre(movies, 10),
				addScreenToTheatre(listOfScreens, 2001, 2), "Aditya Singh", "9876543210"));
		listOfTheatres.add(new Theatre(2002, "Cinepolis Cinemas", "Bhubaneshwar", addMoviesToTheatre(movies, 10),
				addScreenToTheatre(listOfScreens, 2002, 2), "Mohd. Ikram", "8876543210"));
		listOfTheatres.add(new Theatre(2003, "INOX Cinemas", "BapujiNagar", addMoviesToTheatre(movies, 10),
				addScreenToTheatre(listOfScreens, 2003, 3), "Divyansh Singh", "7876543210"));
		return listOfTheatres;
	}

	public static List<Movie> addMoviesToTheatre(List<Movie> movies, int n) {
		List<Movie> movie = new ArrayList<Movie>();
		for (int i = 0; i < n; i++)
			movie.add(movies.get(i));
			
		return movie;
	}

	public static List<Screen> addScreenToTheatre(List<Screen> listOfScreens, int theatreId, int n) {
		List<Screen> screen = new ArrayList<Screen>();

		for (int i = 0; i < 7; i++)
			if (listOfScreens.get(i).getTheatreId() == theatreId) {
				screen.add(listOfScreens.get(i));

			}
		return screen;

	}

	public static List<Show> getShows() {
		List<Integer> seat = new ArrayList<Integer>();
		seat.add(1);
		seat.add(2);
		seat.add(3);
		seat.add(4);
		seat.add(5);
		seat.add(6);
		seat.add(7);
		seat.add(8);
		seat.add(9);
		seat.add(10);

		List<Show> shows = new ArrayList<Show>();
		shows.add(new Show(4001, LocalTime.of(8, 12, 00), LocalTime.of(10, 00, 12), seat, "Morning Show", " War"));
		shows.add(new Show(4002, LocalTime.of(12, 12, 00), LocalTime.of(2, 00, 12), seat, "Afternoon Show", " War"));
		shows.add(new Show(4003, LocalTime.of(4, 12, 00), LocalTime.of(6, 00, 12), seat, "Evening Show", " War"));
		shows.add(new Show(4004, LocalTime.of(9, 12, 00), LocalTime.of(11, 00, 12), seat, "Late Night Show", " War"));
		return shows;
	}

}
