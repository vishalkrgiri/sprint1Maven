

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.iter.bean.Movie;
import com.cg.iter.bean.Screen;
import com.cg.iter.db.DatabaseImpl;

public class DaoTest {

	private static DatabaseImpl test;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void getList() {
		List<Screen> list = DatabaseImpl.getListOfScreens();
		assertNotNull(list);
	}

}
