import java.util.ArrayList;

public class movieTest {
	public static void main(String[] args) {
		movie m = new movie();
		m.setMovieTime(125);
		m.setMovieSort(Sort.comedy);
		m.setMovieName("Forrest Gump");
		m.setMovieIntroduction("阿甘正传");
		m.setMovieGrade(9.5);
		m.setMovieCountry(Country.America);
		m.setMovieDate(new Date(1994, 7, 6));
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("汤姆·汉克斯");
		actors.add("罗宾·怀特");
		actors.add("加里·西尼斯");
		actors.add("莎莉·菲尔德");
		m.setMovieActors(actors);
		
		
		System.out.println("片名：");
		System.out.println(m.getMovieName());
		System.out.println("简介：");
		System.out.println(m.getMovieIntroduction());
		System.out.println("豆瓣评分：");
		System.out.println(m.getMovieGrade());
		System.out.println("产地：");
		System.out.println(m.getMovieCountry());
		System.out.println("类别：");
		System.out.println(m.getMovieSort());
		System.out.println("上映日期：");
		System.out.println(m.getMovieDate().getYear() + "-" + m.getMovieDate().getMonth() + "-" + m.getMovieDate().getDay());
		System.out.println("时长：");
		System.out.println(m.getMovieTime() + "分钟");
		System.out.println("演员：");
		System.out.println(m.getMovieActors());
	}
}