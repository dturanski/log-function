/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package functions;

import java.util.function.Function;

import io.cloudevents.impl.DefaultCloudEventImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author David Turanski
 **/
@SpringBootApplication
public class LogApp {

	@Bean
	public Function<DefaultCloudEventImpl, String> log() {
		return cloudEvent -> {
			String result = cloudEvent.getData().get() instanceof byte[] ?
				new String((byte[]) cloudEvent.getData().get()) :
				cloudEvent.getData().get().toString();

			System.out.println("Received: " + result);
			return result;
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(LogApp.class, args);
	}

}
