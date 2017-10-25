package craftdemo.service;

import org.junit.Before;
import org.junit.Test;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {LoginApplicationConfig.class})
public class UserTweetServiceTest {
	
	@Before
	public void before() {
		
	}
	
//	@Autowired
//    @Qualifier("userTweetService")
//	private UserTweetService userTweetService;
	
	@Test
	public void testGetFeed() throws Exception {
		System.out.println("test");
		
//        assertThat(userTweetService, instanceOf(UserTweetService.class));
//        assertNotNull(userTweetService.getFeed());
	}

}
