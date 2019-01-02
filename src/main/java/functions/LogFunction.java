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

/**
 * @author David Turanski
 **/
public class LogFunction implements Function<DefaultCloudEventImpl, String> {

	@Override
	public String apply(DefaultCloudEventImpl cloudEvent) {
		String result =
			new String((byte[]) cloudEvent.getData().get());

		System.out.println("Received: " + result);
		return result;
	}
}
