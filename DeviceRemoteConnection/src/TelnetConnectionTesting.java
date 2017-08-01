import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

 public class TelnetConnectionTesting{
	 @Test
	 public void TestConnedtion() throws IOException, InterruptedException {
		 DeviceRemoteConnection.Helo();
	}
 }