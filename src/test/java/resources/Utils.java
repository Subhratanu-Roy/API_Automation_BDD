package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.User;

public class Utils {

	static RequestSpecification reqSpec;

	public RequestSpecification requestSpecification() throws IOException {
		if (reqSpec == null) {

			String s = new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
			PrintStream stream = new PrintStream(
					new FileOutputStream(System.getProperty("user.dir") + "\\logs\\logging_" + s + ".txt"));

			reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("url"))
					.addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream)).setContentType(ContentType.JSON)
					.addHeader("x-api-key", "reqres-free-v1").build();

			return reqSpec;
		}

		return reqSpec;
	}

	public String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\Global.properties"));
		prop.load(fis);
		return prop.getProperty(key);
	}

}
