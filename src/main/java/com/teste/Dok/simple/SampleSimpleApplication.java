/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teste.Dok.simple;

import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.teste.Dok.simple.service.HelloWorldService;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SampleSimpleApplication implements CommandLineRunner {

	// Simple example shows how a command line spring application can execute an
	// injected bean service. Also demonstrates how you can use @Value to inject
	// command line args ('--name=whatever') or application properties

	@Autowired
	private HelloWorldService helloWorldService;
	@Override
	public void run(String... args) {
		System.out.println(this.helloWorldService.getHelloMessage());
		try {
			String ver = System.getProperty("java.version");
			String testDate = "11/04/2007 1:00 AM";
			Date currentDate = new Date();
			Calendar instance = Calendar.getInstance();
			System.out.println("calendar ----------- " + instance);
			System.out.println("JREion : " + ver);
			System.out.println(currentDate);
			// Default timezone from the system is used.
			TimeZone tz = TimeZone.getDefault();
			// Could manually set the timezone above. e.g :
			// TimeZone tz = TimeZone.getTimeZone("America/New_York");
			System.out.println("TimeZoneed : " + tz.getDisplayName(tz.inDaylightTime(currentDate), TimeZone.LONG));
			boolean indaylight = tz.inDaylightTime(currentDate);
			System.out.println("Youred time is " + (indaylight ? "in " : "not in ") + "daylight-savings time.");
			System.out.println("zone offset"+ZoneOffset.systemDefault());
		} catch (Exception e) {
			System.out.println("Errorutered. Please insure you supply a valid date format pattern.");
			System.out.println("Ensureve quotes placed around the pattern!");
			System.out.println("e.g DSTTest \"11/04/2007 1:00 AM\"");
		}

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleSimpleApplication.class, args);
	}
}
