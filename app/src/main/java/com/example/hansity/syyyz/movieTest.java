import java.util.ArrayList;

public class movieTest {
	public static void main(String[] args) {
		movie m = new movie();
		m.setMovieTime(125);
		m.setMovieSort(Sort.comedy);
		m.setMovieName("Forrest Gump");
		m.setMovieIntroduction("��������");
		m.setMovieGrade(9.5);
		m.setMovieCountry(Country.America);
		m.setMovieDate(new Date(1994, 7, 6));
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("��ķ������˹");
		actors.add("�ޱ�������");
		actors.add("�������˹");
		actors.add("ɯ�򡤷ƶ���");
		m.setMovieActors(actors);
		
		
		System.out.println("Ƭ����");
		System.out.println(m.getMovieName());
		System.out.println("��飺");
		System.out.println(m.getMovieIntroduction());
		System.out.println("�������֣�");
		System.out.println(m.getMovieGrade());
		System.out.println("���أ�");
		System.out.println(m.getMovieCountry());
		System.out.println("���");
		System.out.println(m.getMovieSort());
		System.out.println("��ӳ���ڣ�");
		System.out.println(m.getMovieDate().getYear() + "-" + m.getMovieDate().getMonth() + "-" + m.getMovieDate().getDay());
		System.out.println("ʱ����");
		System.out.println(m.getMovieTime() + "����");
		System.out.println("��Ա��");
		System.out.println(m.getMovieActors());
	}
}