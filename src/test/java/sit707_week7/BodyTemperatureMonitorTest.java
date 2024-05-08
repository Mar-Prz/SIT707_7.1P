package sit707_week7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.mockito.*;
import static org.mockito.Mockito.*;

public class BodyTemperatureMonitorTest {
	
	  @Mock private TemperatureSensor sensor;
	    @Mock private CloudService cloudService;
	    @Mock private NotificationSender notificationSender;
	    @InjectMocks private BodyTemperatureMonitor monitor;

	    @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }

	@Test
	public void testStudentIdentity() {
		String studentId = "216293263";
		Assert.assertNotNull("Student ID is 216293263", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Mark Przybylkiewicz";
		Assert.assertNotNull("Student name is Mark Przybylkiewicz", studentName);
	}
	
	 @Test
	    public void testReadTemperatureNegative() {
	        when(sensor.readTemperatureValue()).thenReturn(-1.0);
	        double temp = monitor.readTemperature();
	        Assert.assertEquals("Temperature should be negative", -1.0, temp, 0.01);
	    }

	
	 @Test
	    public void testReadTemperatureZero() {
	        when(sensor.readTemperatureValue()).thenReturn(0.0);
	        double temp = monitor.readTemperature();
	        Assert.assertEquals("Temperature should be zero", 0.0, temp, 0.01);
	    }
	
	  @Test
	    public void testReadTemperatureNormal() {
	        when(sensor.readTemperatureValue()).thenReturn(36.5);
	        double temp = monitor.readTemperature();
	        Assert.assertEquals("Temperature should be normal", 36.5, temp, 0.01);
	    }
	  @Test
	    public void testReadTemperatureAbnormallyHigh() {
	        when(sensor.readTemperatureValue()).thenReturn(39.0);
	        double temp = monitor.readTemperature();
	        Assert.assertEquals("Temperature should be abnormally high", 39.0, temp, 0.01);
	    }

	/*
	 * CREDIT or above level students, Remove comments. 
	 */
//	@Test
//	public void testReportTemperatureReadingToCloud() {
//		// Mock reportTemperatureReadingToCloud() calls cloudService.sendTemperatureToCloud()
//		
//		Assert.assertTrue("Not tested", false);
//	}
	
	
	/*
	 * CREDIT or above level students, Remove comments. 
	 */
//	@Test
//	public void testInquireBodyStatusNormalNotification() {
//		Assert.assertTrue("Not tested", false);
//	}
	
	/*
	 * CREDIT or above level students, Remove comments. 
	 */
//	@Test
//	public void testInquireBodyStatusAbnormalNotification() {
//		Assert.assertTrue("Not tested", false);
//	}
}
