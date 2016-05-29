import java.util.ArrayList;

enum Country {China, America, France, Britain, Australia, Japan, Korea, Russia, German}
enum Sort {scienceFition, love, horror, comedy}
class Date {
	public Date(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public void setYear(int y) {
		year = y;
	}
	public void setMonth(int m) {
		month = m;
	}
	public void setDay(int d) {
		day = d;
	}
	private int year;
	private int month;
	private int day;
}

public class movie {
	public String movieName;   //电影名字
	public Country movieCountry;    //电影产地（国家）
	public Sort movieSort;    //电影类别
	public int movieTime;    //电影时长
	public Date movieDate;    //电影上映日期
	public double movieGrade;    //电影评分
	public ArrayList<String> movieActors;   //演员列表（仅包含演员姓名）
    public String movieIntroduction;   //电影简介

    public movie() {
    	movieActors = new ArrayList<String>();
    }
    //电影名字的set和get
    public void setMovieName(String movieName) {
    	this.movieName = movieName;
    }
    public String getMovieName() {
    	return movieName;
    }

    //电影产地的set和get
    public void setMovieCountry(Country movieCountry) {
    	this.movieCountry = movieCountry;
    }
    public Country getMovieCountry() {
    	return movieCountry;
    }

    //电影类别的set和get
    public void setMovieSort(Sort movieSort) {
    	this.movieSort = movieSort;
    }
    public Sort getMovieSort() {
    	return movieSort;
    }

    //电影时长的set和get
    public void setMovieTime(int movieTime) {
    	this.movieTime = movieTime;
    }
    public int getMovieTime() {
    	return movieTime;
    }

    //电影上映日期的set和get
    public void setMovieDate(Date movieDate) {
    	this.movieDate = movieDate;
    }
    public Date getMovieDate() {
    	return movieDate;
    }

    //电影评分的set和get
    public void setMovieGrade(double movieGrade) {
    	this.movieGrade = movieGrade;
    }
    public double getMovieGrade() {
    	return movieGrade;
    }

    //演员列表的set和get
    public void setMovieActors(ArrayList actors) {
    	if (!this.movieActors.isEmpty()) {
    		this.movieActors.clear();
    	}
    	this.movieActors.addAll(actors);
    }
    public ArrayList getMovieActors() {
    	return movieActors;
    }

    //电影简介的set和get
    public void setMovieIntroduction(String movieIntroduction) {
    	this.movieIntroduction = movieIntroduction;
    }
    public String getMovieIntroduction() {
    	return movieIntroduction;
    }
}
