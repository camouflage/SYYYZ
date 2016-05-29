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
	public String movieName;   //��Ӱ����
	public Country movieCountry;    //��Ӱ���أ����ң�
	public Sort movieSort;    //��Ӱ���
	public int movieTime;    //��Ӱʱ��
	public Date movieDate;    //��Ӱ��ӳ����
	public double movieGrade;    //��Ӱ����
	public ArrayList<String> movieActors;   //��Ա�б���������Ա������
    public String movieIntroduction;   //��Ӱ���

    public movie() {
    	movieActors = new ArrayList<String>();
    }
    //��Ӱ���ֵ�set��get
    public void setMovieName(String movieName) {
    	this.movieName = movieName;
    }
    public String getMovieName() {
    	return movieName;
    }

    //��Ӱ���ص�set��get
    public void setMovieCountry(Country movieCountry) {
    	this.movieCountry = movieCountry;
    }
    public Country getMovieCountry() {
    	return movieCountry;
    }

    //��Ӱ����set��get
    public void setMovieSort(Sort movieSort) {
    	this.movieSort = movieSort;
    }
    public Sort getMovieSort() {
    	return movieSort;
    }

    //��Ӱʱ����set��get
    public void setMovieTime(int movieTime) {
    	this.movieTime = movieTime;
    }
    public int getMovieTime() {
    	return movieTime;
    }

    //��Ӱ��ӳ���ڵ�set��get
    public void setMovieDate(Date movieDate) {
    	this.movieDate = movieDate;
    }
    public Date getMovieDate() {
    	return movieDate;
    }

    //��Ӱ���ֵ�set��get
    public void setMovieGrade(double movieGrade) {
    	this.movieGrade = movieGrade;
    }
    public double getMovieGrade() {
    	return movieGrade;
    }

    //��Ա�б��set��get
    public void setMovieActors(ArrayList actors) {
    	if (!this.movieActors.isEmpty()) {
    		this.movieActors.clear();
    	}
    	this.movieActors.addAll(actors);
    }
    public ArrayList getMovieActors() {
    	return movieActors;
    }

    //��Ӱ����set��get
    public void setMovieIntroduction(String movieIntroduction) {
    	this.movieIntroduction = movieIntroduction;
    }
    public String getMovieIntroduction() {
    	return movieIntroduction;
    }
}
