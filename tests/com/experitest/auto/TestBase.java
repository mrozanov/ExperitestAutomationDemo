package com.experitest.auto;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;

import com.experitest.client.Client;

public abstract class TestBase {
	  private String host = "localhost";
	  private int port = 8889;
	  //private String projectBaseDirectory = "/Users/guyarieli/workspace/project2";
	  protected Client client = null;
	  protected static Properties properties = null;
	  protected MyApp app = null;

	  @Before
	  public void setUp() throws Exception{
		  if(properties == null){
			  properties = new Properties();
			  FileReader fr = new FileReader("setup.properties");
			  properties.load(fr);
			  fr.close();
		  }
	      client = new Client(host, port, true);
	      client.setProjectBaseDirectory(new File(System.getProperty("user.dir"), "testdata").getAbsolutePath());
	      client.setReporter("xml", "reports", getTestName());
	     
	      String deviceName = properties.getProperty("device.name");
	      deviceName = client.waitForDevice("@os='ios' and @versionnumber > 9.1", 200000)
	      client.setDevice(deviceName);
	      if(deviceName.startsWith("adb:")){
	    	  app = new MyAndroidApp(client);
	      } else {
	    	  app = new MyIOSApp(client);
	      }
	  }
	  @After
	  public void tearDown(){
	      // Generates a report of the test case.
	      // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
	      client.generateReport(false);
	      // Releases the client so that other clients can approach the agent in the near future. 
	      client.releaseClient();
	  }
	  
	  public abstract String getTestName();

}
